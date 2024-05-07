
ALTER SESSION SET NLS_DATE_FORMAT='MM-DD-YYYY';

CREATE TABLE RECURSO (
Codigo VARCHAR2(3) PRIMARY KEY,
Nombre VARCHAR2(50) UNIQUE,
Stock number(3)
);

CREATE TABLE RUTA (
Codigo_R VARCHAR2(3) PRIMARY KEY,
Nombre VARCHAR2(50) UNIQUE,
Descripcion VARCHAR2(50),
Precio DECIMAL(6,2),
Tipo varchar2(10) check (Tipo in ('Fácil', 'Media', 'Difícil', 'Extrema'))
);

CREATE TABLE USA (
Ruta VARCHAR2(3),
Recurso VARCHAR2(3),
Cantidad number(3),
CONSTRAINT US_PK PRIMARY KEY(RUTA, RECURSO),
CONSTRAINT USA_RE_FK FOREIGN KEY (RECURSO) REFERENCES  RECURSO (CODIGO) ON DELETE CASCADE,
CONSTRAINT USA_RU_FK FOREIGN KEY (RUTA) REFERENCES  RUTA (CODIGO_R) ON DELETE CASCADE
);


CREATE TABLE EMPLEADO (
DNI VARCHAR2(9) PRIMARY KEY,
Nombre VARCHAR2(50),
Apellidos VARCHAR2(50),
F_nac date,
Salario DECIMAL(6,2)
);


CREATE TABLE USUARIO (
CODIGO_U VARCHAR2(5) PRIMARY KEY,
DNI VARCHAR2(9),
Nombre VARCHAR2(50),
Apellidos VARCHAR2(50),
Telefono VARCHAR2(9),
edad number(3)
);

CREATE TABLE EXCURSION(
Codigo_E VARCHAR2(5) PRIMARY KEY,
Nombre VARCHAR2(50),
Fecha_H_inicio timestamp,
Fecha_H_fin timestamp,
N_plazas number(3),
Ruta VARCHAR2(3),
Empleado VARCHAR2(9),

CONSTRAINT EX_RU_FK FOREIGN KEY (RUTA) REFERENCES  RUTA (CODIGO_R) ON DELETE CASCADE,
CONSTRAINT EX_EM_FK FOREIGN KEY (EMPLEADO) REFERENCES EMPLEADO (DNI) ON DELETE CASCADE

);


CREATE TABLE RESERVA(
Excursion VARCHAR2(5),
Usuario VARCHAR2(5),
importe DECIMAL(6,2),
Forma_pago varchar2(10) check (Forma_pago in ('tarjeta', 'contado', 'bizum')),

CONSTRAINT RE_PK PRIMARY KEY(EXCURSION, USUARIO),
CONSTRAINT RE_EX_FK FOREIGN KEY (EXCURSION) REFERENCES  EXCURSION (CODIGO_E) ON DELETE CASCADE,
CONSTRAINT RE_US_FK FOREIGN KEY (USUARIO) REFERENCES USUARIO (CODIGO_U) ON DELETE CASCADE

);

CREATE TABLE USUARIOS_BORRADOS (
DNI VARCHAR2(9),
Nombre VARCHAR2(50),
Telefono VARCHAR2(9),
fecha_borrado date
);

/* INSERCCIÓN DE DATOS */

INSERT INTO EMPLEADO VALUES ('11111111Q','Luis', 'Ramírez Pardo','11-15-1980', 1200);
INSERT INTO EMPLEADO VALUES ('22222222S','María', 'Sánchez Cid', '10-20-1975',  1000);
INSERT INTO EMPLEADO VALUES ('33333333M','Martín', 'Guerrero López','07-22-1990' ,1000);
INSERT INTO EMPLEADO VALUES ('04444444T','Úrsula', 'Delta Camacho','08-10-1980', 900);
INSERT INTO EMPLEADO VALUES ('55555555J','Carmen', 'Hernández Pío','06-05-1977', 1500);
INSERT INTO EMPLEADO VALUES ('77777777M','Pedro', 'Jiménez Ruiz','05-12-1981', 1000);
INSERT INTO EMPLEADO VALUES ('99999999X','Raúl', 'Rodrigo Roca','10-29-1985', 1000);
INSERT INTO EMPLEADO VALUES ('88888888O','Soledad', 'Campillo Molina','04-12-1978', 1200);
INSERT INTO EMPLEADO VALUES ('03232323P','María Luisa', 'Galdón Ter','03-14-1969', 1200);
INSERT INTO EMPLEADO VALUES ('14567555L','Piedad', 'Colmenero Zapillo','10-15-1991', 1200);
INSERT INTO EMPLEADO VALUES ('14111155T','Sergio', 'Lérida Campos','12-17-1992', 1000);

SELECT * FROM EMPLEADO;

INSERT INTO USUARIO VALUES ('U001', '14188151T','Carlos', 'Sánchez Ruíz', '600259874',25);
INSERT INTO USUARIO VALUES ('U002', '11245621Q','Juan', 'Pardo Rubio', '636254878',30);
INSERT INTO USUARIO VALUES('U003', '04477744T','Laura', 'Jiménez Jiménez', '625874596',14);
INSERT INTO USUARIO VALUES('U004','51235555J','Carmen', 'Capel Pío', '669584712',16);
INSERT INTO USUARIO VALUES('U005','55675675J','Juan', 'Sánchez López', '625845632',45);
INSERT INTO USUARIO VALUES('U006','99009900J','Alejandro', 'Pardo López', '636985621',62);
INSERT INTO USUARIO VALUES ('U007','24138151T','Vicente', 'Sánchez Pelayo', '61039874',42);
INSERT INTO USUARIO VALUES ('U008','21235421Q','Alfredo', 'Jiménez Rubio', '616856878',29);
INSERT INTO USUARIO VALUES ('U009','64574744T','María', 'Jiménez Costa', '623834596',16);
INSERT INTO USUARIO VALUES('U010','71234545J','Lucía', 'Sonora Vigo', '670684752',34);
INSERT INTO USUARIO VALUES('U011','65675454K','Alejandro', 'Sánchez Ocaña', '635845632',55);
INSERT INTO USUARIO VALUES('U012','34006800L','Javier', 'García Muñoz', '636535281',43);

SELECT * FROM USUARIO;

INSERT INTO RECURSO VALUES ('001','Bicicleta',40);
INSERT INTO RECURSO VALUES ('002','Quad', 20);
INSERT INTO RECURSO VALUES ('003','Motoclicleta',30);
INSERT INTO RECURSO VALUES ('004','Patines', 45);
INSERT INTO RECURSO VALUES ('005','Piragua', 40);
INSERT INTO RECURSO VALUES ('006','Caballo', 20);
INSERT INTO RECURSO VALUES ('007','Esquies', 20);
INSERT INTO RECURSO VALUES ('008', 'Tablas de Snow', 20);
INSERT INTO RECURSO VALUES ('009', 'Snorkel',40); 
INSERT INTO RECURSO VALUES ('010', 'Arcos',30); 

SELECT * FROM RECURSO;

INSERT INTO RUTA VALUES ('R01', 'Cabo de Gata', 'Senderismo por Cabo de Gata', 10, 'Fácil');
INSERT INTO RUTA VALUES ('R02', 'Arrecife de las Sirenas', 'Piraguismo por el Arrecife de las Sirenas', 20, 'Fácil');
INSERT INTO RUTA VALUES ('R03', 'Loma Reliblanca', 'Paseo en Quad por la Loma de la Reliblanca', 25, 'Difícil');
INSERT INTO RUTA VALUES ('R04', 'Sierra de Gádor', 'Paseo en Motocicleta por la Sierra de Gádor', 30, 'Extrema');
INSERT INTO RUTA VALUES ('R05', 'La Fabriquilla', 'Multiaventura por la Sierra de los Filabres', 35, 'Media');
INSERT INTO RUTA VALUES ('R06', 'Playa Mónsul', 'Paseo a caballo por la playa de Mónsul', 30, 'Media');
INSERT INTO RUTA VALUES ('R07', 'Desierto de Tabernas', 'Multiaventura por el desierto de Tabernas', 50, 'Media');
INSERT INTO RUTA VALUES ('R08', 'Sierra Nevada', 'Esquí alpino por Sierra Nevada', 80, 'Difícil');

SELECT * FROM RUTA;

INSERT INTO USA VALUES ('R02', '005', 20);
INSERT INTO USA VALUES ('R02', '009', 20);

INSERT INTO USA VALUES ('R03', '002', 10);

INSERT INTO USA VALUES ('R04', '003', 20);

INSERT INTO USA VALUES ('R05', '006', 20);
INSERT INTO USA VALUES ('R05', '001', 30);
INSERT INTO USA VALUES ('R05', '010', 20);

INSERT INTO USA VALUES ('R06', '006', 20);


INSERT INTO USA VALUES ('R07', '006', 20);
INSERT INTO USA VALUES ('R07', '002', 20);
INSERT INTO USA VALUES ('R07', '003', 20);

INSERT INTO USA VALUES ('R08', '007', 20);
INSERT INTO USA VALUES ('R08', '008', 20);

SELECT * FROM USA;

INSERT INTO EXCURSION VALUES ('EX001', 'Conociendo Cabo de Gata' ,'20-SEP-20 09.00.00','20-SEP-20 02.00.00', 40, 'R01', '11111111Q');

INSERT INTO EXCURSION VALUES ('EX002', 'Cabo de Gata en primavera','10-ABR-20 09.00.00', '10-ABR-20 02.00.00', 40, 'R01', '22222222S');

INSERT INTO EXCURSION VALUES ('EX003', 'Cabo de Gata en otoño', '15-OCT-20 09.00.00','15-OCT-20 02.00.00', 40, 'R01', '22222222S');

INSERT INTO EXCURSION VALUES ('EX004', 'Explorando el Arrecife de las Sirenas', '25-AGO-08 08.00.00','25-AGO-08 03.00.00', 30, 'R02', '11111111Q');

INSERT INTO EXCURSION VALUES ('EX005', 'Iniciación Quad Loma Reliblanca','20-MAY-20  09.00.00','20-MAY-08 03.00.00',10, 'R03', '11111111Q');
INSERT INTO EXCURSION VALUES ('EX006', ' Explorando la Loma Reliblanca', '12-MAR-20 09.00.00','12-MAR-20 03.00.00', 10, 'R03', '33333333M');

INSERT INTO EXCURSION VALUES ('EX007', 'Conociendo en moto la Sierra de Gádor', '18-FEB-20  08.00.00','18-FEB-08 04.00.00', 10, 'R04', '33333333M');

INSERT INTO EXCURSION VALUES ('EX008', 'Multiaventura en La Fabriquilla','26-ENE-20  09.00.00','26-ENE-20 08.00.00', 30, 'R05', '04444444T');

INSERT INTO EXCURSION VALUES ('EX009', 'Paraiso Natural, Playa Monsul', '15-AGO-20  11.00.00','15-AGO-08 05.00.00', 30, 'R06', '99999999X');


INSERT INTO EXCURSION VALUES ('EX010', 'Paraiso interior Desierto de Tabernas','20-JUN-20  10.00.00','20-JUN-08 04.00.00', 40, 'R07', '55555555J');

SELECT * FROM EXCURSION;

INSERT INTO RESERVA VALUES ('EX001', 'U008', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX001', 'U010', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX001', 'U011', 10, 'tarjeta');

INSERT INTO RESERVA VALUES ('EX002', 'U001', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX002', 'U003', 5, 'bizum');
INSERT INTO RESERVA VALUES ('EX002', 'U005', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX002', 'U007', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX002', 'U009', 5, 'bizum');
INSERT INTO RESERVA VALUES ('EX002', 'U010', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX002', 'U011', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX002', 'U002', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX002', 'U004', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX002', 'U006', 10, 'bizum');

INSERT INTO RESERVA VALUES ('EX003', 'U001', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX003', 'U002', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX003', 'U003', 5, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX003', 'U004', 5, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX003', 'U005', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX003', 'U006', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX003', 'U007', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX003', 'U008', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX003', 'U009', 10, 'contado');

INSERT INTO RESERVA VALUES ('EX004', 'U001', 20, 'bizum');
INSERT INTO RESERVA VALUES ('EX004', 'U002', 20, 'bizum');
INSERT INTO RESERVA VALUES ('EX004', 'U003', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX004', 'U004', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX004', 'U005', 20, 'contado');

INSERT INTO RESERVA VALUES ('EX005', 'U006', 25, 'contado');
INSERT INTO RESERVA VALUES ('EX005', 'U007', 25, 'contado');
INSERT INTO RESERVA VALUES ('EX005', 'U008', 25, 'bizum');
INSERT INTO RESERVA VALUES ('EX005', 'U009', 15, 'tarjeta');

INSERT INTO RESERVA VALUES ('EX006', 'U002', 25, 'contado');
INSERT INTO RESERVA VALUES ('EX006', 'U005', 25, 'bizum');
INSERT INTO RESERVA VALUES ('EX006', 'U008', 25, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX006', 'U010', 25, 'contado');

INSERT INTO RESERVA VALUES ('EX007', 'U002', 30, 'bizum');
INSERT INTO RESERVA VALUES ('EX007', 'U005', 30, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX007', 'U008', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX007', 'U010', 30, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX007', 'U012', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX007', 'U006', 30, 'bizum');


INSERT INTO RESERVA VALUES ('EX008', 'U008', 35, 'contado');
INSERT INTO RESERVA VALUES ('EX008', 'U010', 35, 'bizum');
INSERT INTO RESERVA VALUES ('EX008', 'U001', 35, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX008', 'U007', 35, 'bizum');
INSERT INTO RESERVA VALUES ('EX008', 'U003', 25, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX008', 'U005', 35, 'contado');
INSERT INTO RESERVA VALUES ('EX008', 'U004', 25, 'contado');


INSERT INTO RESERVA VALUES ('EX009', 'U001', 30, 'bizum');
INSERT INTO RESERVA VALUES ('EX009', 'U002', 30, 'bizum');
INSERT INTO RESERVA VALUES ('EX009', 'U003', 20, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX009', 'U004', 20, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX009', 'U005', 30, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX009', 'U006', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX009', 'U007', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX009', 'U008', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX009', 'U009', 30, 'contado');

INSERT INTO RESERVA VALUES ('EX010', 'U008', 50, 'contado');
INSERT INTO RESERVA VALUES ('EX010', 'U010', 50, 'bizum');
INSERT INTO RESERVA VALUES ('EX010', 'U001', 50, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX010', 'U007', 50, 'bizum');
INSERT INTO RESERVA VALUES ('EX010', 'U003', 40, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX010', 'U005', 50, 'contado');
INSERT INTO RESERVA VALUES ('EX010', 'U004', 40, 'contado');


SELECT * FROM RESERVA;


CREATE OR REPLACE PROCEDURE EJ1(COD VARCHAR)
AS
CURSOR CEJ1 IS SELECT NOMBRE, APELLIDOS, TELEFONO, DNI, CODIGO_U FROM USUARIO, RESERVA
    WHERE COD = EXCURSION AND USUARIO = CODIGO_U;
REG  CEJ1%ROWTYPE;    

BEGIN
DBMS_OUTPUT.PUT_LINE('A LA EXCURSION CON CODIGO: '||COD||'ASISITIERON: ');
DBMS_OUTPUT.PUT_LINE(RPAD('USUARIO',30)||RPAD('U.DNI',12)||'U.TELEFONO');
OPEN CEJ1;
FETCH CEJ1 INTO REG;
WHILE CEJ1%FOUND LOOP
    DBMS_OUTPUT.PUT_LINE(RPAD(REG.NOMBRE ||' '|| REG.APELLIDOS,30)||
    RPAD(REG.DNI,12)||RPAD(REG.TELEFONO, 12)||REG.CODIGO_U);
    FETCH CEJ1 INTO REG;
END LOOP;
CLOSE CEJ1;
END;


CREATE OR REPLACE PROCEDURE EJ2(DOC VARCHAR)
AS
CANTIDAD NUMBER;
SAL NUMBER;
BEGIN

SELECT COUNT(CODIGO_E) INTO CANTIDAD FROM EXCURSION WHERE DOC = EMPLEADO GROUP BY EMPLEADO;
DBMS_OUTPUT.PUT_LINE('EL EMPLEADO ESTUVO EN '||CANTIDAD||' EXCURSIONES');
UPDATE EMPLEADO SET SALARIO = SALARIO + (CANTIDAD * 15) WHERE DNI = DOC;
SELECT SALARIO INTO SAL FROM EMPLEADO WHERE DNI = DOC;
DBMS_OUTPUT.PUT_LINE('EL EMPLEADO TENDRA EL SALARIO DE: '||SAL);
END;


-- 2.1
CREATE OR REPLACE PROCEDURE MOSTRAR_EXCURSIONES(NOM VARCHAR, APE VARCHAR)
AS
CURSOR CEXC IS SELECT CODIGO_E, E.NOMBRE AS EXCURSION, FECHA_H_INICIO, N_PLAZAS, R.NOMBRE AS RUTA, 
PRECIO FROM EXCURSION E, RUTA R, EMPLEADO EMP WHERE CODIGO_R = RUTA AND EMPLEADO = DNI 
AND EMP.NOMBRE = NOM AND APELLIDOS = APE;
REG CEXC%ROWTYPE;
CANT NUMBER;
SAL DECIMAL(6,2);
BEGIN
SELECT SALARIO INTO SAL FROM EMPLEADO WHERE NOM = NOMBRE AND APE = APELLIDOS;

SELECT COUNT(*) INTO CANT FROM EXCURSION E, RUTA R, EMPLEADO EMP 
WHERE CODIGO_R = RUTA AND EMPLEADO = DNI AND EMP.NOMBRE = NOM 
AND APELLIDOS = APE;

OPEN CEXC;
FETCH CEXC INTO REG;
DBMS_OUTPUT.PUT_LINE(RPAD('CODIGO',8)||RPAD('EXCURSION',30)||RPAD('FECHA',25)||
    RPAD('PLAZAS',8)||RPAD('RUTA',30)||'PRECIO');
WHILE CEXC%FOUND LOOP
    DBMS_OUTPUT.PUT_LINE(RPAD(REG.CODIGO_E,8)||RPAD(REG.EXCURSION,30)||
    RPAD(REG.FECHA_H_INICIO,25)||RPAD(REG.N_PLAZAS,8)||RPAD(REG.RUTA,30)||
    REG.PRECIO);
    FETCH CEXC INTO REG;
END LOOP;
CLOSE CEXC;
DBMS_OUTPUT.PUT_LINE('El total de excursiones realizas por el empleado es: '||CANT);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('El empleado no existe');
END;

-- 2.2
CREATE OR REPLACE PROCEDURE RECAUDA_EXCURSION(COD VARCHAR)
AS
CANTIDAD NUMBER;
TOTAL NUMBER;
NOM VARCHAR(50);
PLAZAS NUMBER;
BEGIN
SELECT NOMBRE, N_PLAZAS INTO NOM, PLAZAS FROM EXCURSION WHERE CODIGO_E = COD;
SELECT COUNT(*), SUM(IMPORTE) INTO CANTIDAD, TOTAL FROM RESERVA WHERE EXCURSION = COD;
DBMS_OUTPUT.PUT_LINE('EXCURSION: '||NOM||' PLAZAS: '||PLAZAS||' RESERVAS: '||CANTIDAD||
' RECAUDADO: '||TOTAL);

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('La ruta no existe');
END;

-- 2.3
CREATE OR REPLACE FUNCTION EXC_REALIZADAS(NOM VARCHAR, APE VARCHAR) RETURN NUMBER
AS
CANT NUMBER;
DN VARCHAR(9);
BEGIN
SELECT DNI INTO DN FROM USUARIO WHERE NOMBRE = NOM AND APELLIDOS = APE;
SELECT COUNT(*) INTO CANT FROM RESERVA INNER JOIN USUARIO ON USUARIO = CODIGO_U WHERE NOMBRE = NOM AND APELLIDOS = APE;
RETURN CANT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN -1;
END;

-- 2.4
ALTER TABLE USUARIO ADD TIPO ENUM();