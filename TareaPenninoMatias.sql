/*
EJERCICIO 1: Crear un procedimiento que reciba como parametro el nombre y apellidos
de un cliente y muestre por pantalla un listado con todos los pedidos que ha realizado 
dicho cliente. Para cada pedido debe mostrar el "num_ped, hora del pedido, hora
entrega, y total_pedido". En la ultima fila debe aparecer la suma total del importe
de todos los pedidos
*/
CREATE OR REPLACE PROCEDURE listadoPedidos(nom varchar, ape varchar)
AS
CURSOR cej1 IS SELECT NUM_PED, HORA_PED,HORA_ENTREGA, TOTAL_PEDIDO FROM 
    PEDIDO, CLIENTE WHERE CLIENTE = COD_CLI AND NOMBRE = NOM AND APELLIDOS = APE;
regej1 cej1%ROWTYPE;
suma NUMBER;
BEGIN
suma:=0;
DBMS_OUTPUT.PUT_LINE('Listado de pedidos del cliente: '||RPAD(nom, 12)||ape);
-- en el cursor introduciremos los registros de ese cliente y los cargamos en el registro
OPEN cej1;
FETCH cej1 INTO regej1;
DBMS_OUTPUT.PUT_LINE(RPAD('NUMERO DE PEDIDO',20)||RPAD('HORA PEDIDO',30)||
    RPAD('HORA ENTREGA',30)||RPAD('TOTAL PEDIDO',14));
WHILE cej1%FOUND LOOP
-- por cada registro se mostraran los datos por pantalla y se sumara el total
    DBMS_OUTPUT.PUT_LINE(RPAD(regej1.NUM_PED,20)||RPAD(regej1.HORA_PED,30)||
        RPAD(regej1.HORA_ENTREGA,30)||LPAD(regej1.TOTAL_PEDIDO,12));
    suma:=suma+regej1.TOTAL_PEDIDO;
    FETCH cej1 INTO regej1;
END LOOP;
CLOSE cej1;
-- una vez terminados los registros se imprime la suma de los totales de cada ped
DBMS_OUTPUT.PUT_LINE(LPAD('--------',92));
DBMS_OUTPUT.PUT_LINE(LPAD(SUMA,92));
END;

DECLARE
nom VARCHAR(20);
ape VARCHAR(40);
BEGIN
nom := 'Soledad';
ape := 'Campillo Molina';
listadoPedidos(nom, ape);
END;

/*
EJERCICIO 2: Crea un procedimiento que reciba como parametro el codigo de un cliente.
El procedimiento debe calcular la suma del importe total de los pedidos realizados 
por este clliente y en funcion de este importe debe incrementar el campo "bono_canjeable"
de ese cliente en 15 euros si el importe total de los pedidos es superiro a 50
euros, en 10 si el importe total se encuentra entre 30 y 50 euros y en 5 euros
si el importe se encuentra entre 10 y 30 euros.
El procedimiento debe mostrar por pantalla el importe total de los pedidos del 
cliente el valor de su bono anterior al incremetno y el valor posterior una vez
actualizado.
En el caso de que el codigo de cliente que se pase como argumento no exista,
se debe mostrar por pantalla un mensaje indicando que el cliente no existe
*/
CREATE OR REPLACE PROCEDURE sumaImporte(cod varchar)
AS
tot NUMBER;
vBono NUMBER;
nBono NUMBER;
incremento NUMBER;
BEGIN
-- se cargan los valores de importe total y el bono actual del cliente
SELECT SUM(TOTAL_PEDIDO) INTO tot FROM PEDIDO WHERE CLIENTE = COD;
SELECT BONO_CANJEABLE INTO vBono FROM CLIENTE WHERE COD_CLI = COD;
-- se le asigna a incremento el aumento que se hara al bono del cliente
IF tot > 50 THEN
    incremento := 15;
ELSIF tot >= 30 AND vBono <= 50 THEN
    incremento := 10;
ELSIF tot >= 10 AND vBono < 30 THEN
    incremento := 5;
END IF;
-- nBono tomara el valor del bono anterior mas el incremento
nBono := incremento + vBono;
-- se actualizan y se muestran los datos del bono del cliente
UPDATE CLIENTE SET BONO_CANJEABLE = nBono WHERE COD_CLI = cod;
DBMS_OUTPUT.PUT_LINE('El importe total de cliente con codigo '||cod||' es de '||tot||
    ' por lo que su bono se ha incrementado en '||incremento||' pasando de '||
    vBono||' a '||nBono);
    
EXCEPTION
-- si el cliente no existe saltara esta excepcion
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('El cliente con codigo '||cod||' no existe');
END;

DECLARE
cod VARCHAR(3);
codInv VARCHAR(3);
BEGIN
cod := '101';
codInv := '129';
sumaImporte(cod);
sumaImporte(codInv);
END;
/*
EJERCICIO 3: Crea una funcion que reciba como parametro el nombre de un plato
y devuelva el numero de veces que se ha pedido en total ese plato. Escribe tambien
el bloque de codigo para ejecutar la funcion.
*/
CREATE OR REPLACE FUNCTION vecesPedido(nom varchar)
RETURN NUMBER
AS
tot NUMBER;
BEGIN
-- se almacena la cantidad de veces que se pidio un plato
SELECT SUM(CANTIDAD) INTO tot FROM PLATO, DETALLE_PEDIDO WHERE PLATO = COD_PLATO
    AND NOMBRE = NOM;
RETURN tot;
END;

DECLARE
nom VARCHAR(40);
BEGIN
nom:='Alioli';
DBMS_OUTPUT.PUT_LINE('El plato '||nom||' se ha pedido '||vecesPedido(nom)||' veces');
END;
/*
EJERCICIO 4: Crear un disparador (trigger) que almacene en una tabla, llamada 
PLATOS_BORRADOS, los valores: usuario (con el que estamos autenticados en Oracle),
cod_plato, nombre, precio, stock y fecha en la que se produce el borrado del plato.
Ese disparador se disparara cuando se detecte un borrado de un registro en la tabla
PLATO. Crea la tabla PLATOS_BORRADOS si no estuviera creada
*/
-- creamos la tabla
CREATE TABLE PLATOS_BORRADOS(
    USUARIO VARCHAR(30),
    COD_PLATO VARCHAR(4),
    NOMBRE VARCHAR(40),
    STOCK NUMBER,
    FECHA DATE,
    CONSTRAINT PB_PK PRIMARY KEY (USUARIO, COD_PLATO, FECHA));

CREATE OR REPLACE TRIGGER platoBorrado AFTER DELETE ON PLATO
FOR EACH ROW
DECLARE
usuario VARCHAR(30);
BEGIN
-- almacenamos en usuario el nombre del usuario que borre el registro
SELECT SYS_CONTEXT('userenv','current_user') INTO usuario FROM DUAL;
-- se insertan en la tabla de platos borrados los datos del plato mas usuario y fecha
INSERT INTO PLATOS_BORRADOS VALUES(usuario,:OLD.COD_PLATO, :OLD.NOMBRE, :OLD.STOCK,
    SYSDATE);
END;

BEGIN 
INSERT INTO PLATO VALUES ('018','Berenjenas rebozadas',2.30,10);
DELETE FROM PLATO WHERE COD_PLATO = '018';
END;