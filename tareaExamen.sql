/*1. Crear un procedimiento que reciba como parámetro el Número de colegiado de un 
médico y muestre por pantalla el nombre, apellidos y especialidad del médico así como 
un listado con el NSeguridadSocial, DNI, nombre y apellidos, fecha de consulta e 
importe de los pacientes que hayan asistido a consulta con ese médico.  En la última 
línea debe aparecer la suma total de los importes obtenidos por el médico en las 
consultas. Realiza el control de excepciones para el caso de que el médico pasado como 
parámetro no exista y para el caso de que el médico no haya realizado ninguna consulta. 
(3p)*/
CREATE OR REPLACE PROCEDURE listadoPacientes(nume varchar)
AS
NOM VARCHAR(30);
APE VARCHAR(30);
ESPEC VARCHAR(20);
CURSOR CEJ1 IS SELECT NSS, DNI, NOMBRE, APELLIDOS, FECHACONSULTA, IMPORTE 
    FROM CONSULTAS, PACIENTE WHERE NSS = IDPACIENTE AND IDMEDICO = nume;
REG CEJ1%ROWTYPE;
TOTAL NUMBER;
CONS EXCEPTION;
BEGIN
SELECT NOMBRE, APELLIDOS, ESPECIALIDAD INTO NOM, APE, ESPEC FROM MEDICO WHERE 
    NUMCOLEGIADO = nume;
SELECT SUM(IMPORTE) INTO TOTAL FROM CONSULTAS WHERE IDMEDICO = nume;
IF TOTAL = 0 THEN
    RAISE CONS;
END IF;
DBMS_OUTPUT.PUT_LINE(NOM||' '||APE||' '|| ESPEC);
OPEN CEJ1;
FETCH CEJ1 INTO REG;
DBMS_OUTPUT.PUT_LINE(RPAD('NSS',16)||RPAD('DNI',12)||RPAD('NOMBRE',20)||RPAD('APELLIDOS',30)||
    RPAD('FECHA',12)||'IMPORTE');
WHILE CEJ1%FOUND LOOP
    DBMS_OUTPUT.PUT_LINE(RPAD(REG.NSS,16)||RPAD(REG.DNI,12)||RPAD(REG.NOMBRE,20)
    ||RPAD(REG.APELLIDOS,30)||RPAD(REG.FECHACONSULTA,12)||REG.IMPORTE);
    FETCH CEJ1 INTO REG;
END LOOP;
CLOSE CEJ1;
DBMS_OUTPUT.PUT_LINE('EL TOTAL DE IMPORTES ES: '||TOTAL);
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('EL MEDICO NO EXISTE');
    WHEN CONS THEN
        DBMS_OUTPUT.PUT_LINE('EL MEDICO NO HA REALIZADO CONSULTAS');
END;

BEGIN 
listadoPacientes('414117320');
END;
/*2. Crea una función que reciba como parámetro el nombre y apellidos de un paciente y 
devuelva el tipo de paciente que será: - ‘ Bronce’ si el número de consultas a las que ha asistido es menor o igual a 5. - ‘Plata’ si el número de consultas está entre 5 y 10. - ‘Oro’ si ha asistido a más de 10 consultas. 
Realiza  el control de errores para el caso de que el paciente no exista y el bloque de 
sentencias necesario para probar la función con pacientes que existan y que no existan. 
(2p)*/
CREATE OR REPLACE FUNCTION tipo(nom VARCHAR, ape VARCHAR) RETURN VARCHAR
AS
TOT NUMBER;
DNI_P VARCHAR(9);
CAT VARCHAR(15);
BEGIN
SELECT DNI INTO DNI_P FROM PACIENTE WHERE NOMBRE = nom AND ape = APELLIDOS;
SELECT COUNT(*) INTO TOT FROM CONSULTAS, PACIENTE WHERE DNI = DNI_P AND IDPACIENTE = NSS;
IF TOT <= 5 THEN
    CAT := 'BRONCE';
ELSIF TOT <= 10 THEN
    CAT := 'PLATA';
ELSE
    CAT := 'ORO';
END IF;
RETURN CAT;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        CAT := 'INEXISTENTE';
RETURN CAT;
END;

/*3. Crear un disparador (trigger) que cada vez que se inserte o actualice un registro de la 
tabla CONSULTAS con un valor de importe distinto de NULL se actualice el campo 
‘total_gastado’ de la tabla PACIENTE sumando a este campo el valor del campo 
‘importe’. (2p)*/
CREATE OR REPLACE TRIGGER sumaImporte AFTER INSERT OR UPDATE ON CONSULTAS
FOR EACH ROW
DECLARE
SUMA NUMBER;
BEGIN
IF :OLD.IMPORTE IS NULL AND :NEW.IMPORTE IS NOT NULL THEN
    SUMA := :NEW.IMPORTE;
    UPDATE PACIENTE SET TOTAL_GASTADO = TOTAL_GASTADO + SUMA WHERE NSS = :NEW.IDPACIENTE;
END IF;
END;


    