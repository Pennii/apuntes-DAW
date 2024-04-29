

ALTER SESSION SET NLS_DATE_FORMAT='DD/MM/YYYY';

CREATE TABLE UNIVERSIDAD(
codigo varchar2(4) PRIMARY KEY,
nombre varchar2(40) UNIQUE,
entrenador varchar2(40),
provincia varchar2(40),
comunidad varchar2(50));

CREATE TABLE ATLETA(
dorsal varchar2(6) primary key,
nombre varchar2(20),
apellidos varchar2(30),
sexo char(1) check (sexo in ('M','F')),
fec_nac date not null,
universidad varchar2(20),
nivel varchar2(20),
constraint atl_uni_FK foreign key (universidad)
references UNIVERSIDAD(codigo) on delete set null);

CREATE TABLE PRUEBA(
codigo varchar2(10) primary key,
distancia number(6),
obstaculos char(1) check (obstaculos in ('S','N')),
categoria char(1) check (categoria in ('M','F')),
fec_hora timestamp,
rec_universitario interval day(2)to second,
rec_nacional interval day(2) to second);

CREATE TABLE COMPETIR(
dorsal_atl varchar2(6),
codigo_pru varchar2(6),
marca_personal interval day(2) to second,
posicion number(3),
puntos number(6),
constraint com_dor_cod_PK primary key(dorsal_atl, codigo_pru),
constraint com_dor_FK foreign key(dorsal_atl)
references ATLETA (dorsal) on delete cascade,
constraint com_cod_FK foreign key(codigo_pru)
references PRUEBA (codigo) on delete cascade);


INSERT INTO UNIVERSIDAD VALUES ('UA','Universidad de Alicante','Pedro Pérez Blanes','Alicante','Comunidad Valenciana');
INSERT INTO UNIVERSIDAD VALUES ('UAM','Universidad Autónoma de Madrid','Luis Sobera Linde', 'Madrid','Comunidad de Madrid');
INSERT INTO UNIVERSIDAD VALUES ('UAB','Universidad Autónoma de Barcelona','María Guerrero Sempere','Barcelona','Cataluña');
INSERT INTO UNIVERSIDAD VALUES ('UAL','Universidad de Almería','José Luis Rodríguez Sainz','Almería','Andalucía');
INSERT INTO UNIVERSIDAD VALUES ('UGR','Universidad de Granada','Marta Benítez Pérez','Granada','Andalucía');
INSERT INTO UNIVERSIDAD VALUES ('UIB','Universidad de Islas Baleares','Jaime López Valenzuela','Mallorca','Islas Baleares');
INSERT INTO UNIVERSIDAD VALUES ('UPV','Universidad Politécnica de Valencia','Claudia Lareda Expósito','Valencia','Comunidad Valenciana');
INSERT INTO UNIVERSIDAD VALUES ('US','Universidad de Sevilla','Jorge Luengo Valdivia','Sevilla','Andalucía');

INSERT INTO ATLETA VALUES ('0151', 'Jaime','Pérez López','M','20/01/1998','UAL',null);
INSERT INTO ATLETA VALUES ('0152', 'Lucía','Gil Martínez','F','15/01/1998','UA',null);
INSERT INTO ATLETA VALUES ('0153', 'Adrián','Ruíz García','M','11/02/1995','UA',null);
INSERT INTO ATLETA VALUES ('0154', 'Pedro','Sanz Lorenzo','M','01/02/1996','UAM',null);
INSERT INTO ATLETA VALUES ('0155', 'Carmen','Aguirre Soria','F','02/03/1997','UPV',null);
INSERT INTO ATLETA VALUES ('0156', 'Carlos','Beltrán Gómez','M','12/03/1998','UAB',null);
INSERT INTO ATLETA VALUES ('0157', 'José','Gómez Gil','M','11/03/1998','UA',null);
INSERT INTO ATLETA VALUES ('0158', 'Manuel','Rodríguez Castilla','M','21/03/1997','UPV',null);
INSERT INTO ATLETA VALUES ('0159', 'Sara','Castro Ramírez','F','28/04/1996','UAB',null);
INSERT INTO ATLETA VALUES ('0160', 'María','Valenzuela Garó','F','26/05/1996','UA',null);
INSERT INTO ATLETA VALUES ('0161', 'Juan','Martínez García','M','12/05/1997','UGR',null);
INSERT INTO ATLETA VALUES ('0162', 'Luis','Suliman Tez','M','11/06/1996','US',null);
INSERT INTO ATLETA VALUES ('0163', 'Diego','Arganda Ruíz','M','10/06/1997','UIB',null);
INSERT INTO ATLETA VALUES ('0164', 'Vicente','Gómez Romero','M','08/07/1995','UIB',null);
INSERT INTO ATLETA VALUES ('0165', 'Laura','Valle Suárez','F','09/08/1998','UAB',null);
INSERT INTO ATLETA VALUES ('0166', 'Carlota','Campillo Pérez','F','10/08/1998','UAL',null);
INSERT INTO ATLETA VALUES ('0167', 'Vanesa','Pérez Soriano','F','12/09/1996','US',null);
INSERT INTO ATLETA VALUES ('0168', 'Jorge','Prieto Lillo','M','24/09/1997','UAM',null);
INSERT INTO ATLETA VALUES ('0169', 'Sergio','Blanco Rodríguez','M','25/10/1997','UAM',null);
INSERT INTO ATLETA VALUES ('0170', 'Alex','Castillo Giménez','M','26/10/1996','UGR',null);
INSERT INTO ATLETA VALUES ('0171', 'Mauro','Silva Torres','M','27/11/1996','US',null);
INSERT INTO ATLETA VALUES ('0172', 'Silvia','Sanz Barberó','F','11/12/1996','US',null);
INSERT INTO ATLETA VALUES ('0173', 'Luisa','Fernández López','F','01/03/1996','UA',null);
INSERT INTO ATLETA VALUES ('0174', 'Carolina','Estévez Peláez','F','03/11/1998','UIB',null);
INSERT INTO ATLETA VALUES ('0175', 'Alba','Gil Muñoz','F','12/10/1997','US',null);
INSERT INTO ATLETA VALUES ('0176', 'Mar','Palao Yuste','F','03/10/1996','UAB',null);
INSERT INTO ATLETA VALUES ('0177', 'Candela','Martínez Gómez','F','23/08/1996','UAM',null);
INSERT INTO ATLETA VALUES ('0178', 'Carla','Suárez Pineda','F','14/07/1997','UAM',null);


INSERT INTO PRUEBA VALUES ('100LM',100,'N','M','03-FEB-17 09.00.00', '0 0:00:10.110','0 00:00:10.060');
INSERT INTO PRUEBA VALUES ('100LF',100,'N','F','03-FEB-17 09.30.00', '0 00:00:12.020','0 00:00:11.060');
INSERT INTO PRUEBA VALUES ('400VM',400,'S','M','03-FEB-17 10.00.00', '0 00:00:50.080','0 00:00:48.870');
INSERT INTO PRUEBA VALUES ('400VF',400,'S','F','03-FEB-17 10.30.00', '0 00:00:57.198','0 00:00:55.230');
INSERT INTO PRUEBA VALUES ('1500M',1500,'N','M','04-FEB-17 12.00.00', '0 00:04:02.380','0 00:03:28.950');
INSERT INTO PRUEBA VALUES ('1500F',1500,'N','F','04-FEB-17 9.00.00', '0 00:04:37.010','0 00:03:59.410');
INSERT INTO PRUEBA VALUES ('3000OM',3000,'S','M','04-FEB-17 11.00.00', '0 00:10:13.830','0 00:08:07.440');
INSERT INTO PRUEBA VALUES ('3000OF',3000,'S','F','05-FEB-17 09.00.00', '0 00:11:12.380','0 00:09:07.320');

INSERT INTO COMPETIR VALUES ('0151','100LM','0 00:00:10.560',2,20);
INSERT INTO COMPETIR VALUES ('0153','100LM','0 00:00:10.210',1,30);
INSERT INTO COMPETIR VALUES ('0157','100LM','0 00:00:10.610',3,15);
INSERT INTO COMPETIR VALUES ('0158','100LM','0 00:00:12.410',8,0);
INSERT INTO COMPETIR VALUES ('0161','100LM','0 00:00:10.790',4,10);
INSERT INTO COMPETIR VALUES ('0162','100LM','0 00:00:10.990',5,5);
INSERT INTO COMPETIR VALUES ('0163','100LM','0 00:00:11.230',6,0);
INSERT INTO COMPETIR VALUES ('0168','100LM','0 00:00:11.980',7,0);
INSERT INTO COMPETIR VALUES ('0152','100LF','0 00:00:12.100',1,30);
INSERT INTO COMPETIR VALUES ('0155','100LF','0 00:00:14.050',8,0);
INSERT INTO COMPETIR VALUES ('0160','100LF','0 00:00:12.120',2,20);
INSERT INTO COMPETIR VALUES ('0166','100LF','0 00:00:12.560',4,10);
INSERT INTO COMPETIR VALUES ('0167','100LF','0 00:00:13.790',5,5);
INSERT INTO COMPETIR VALUES ('0172','100LF','0 00:00:13.880',6,0);
INSERT INTO COMPETIR VALUES ('0176','100LF','0 00:00:12.220',3,15);
INSERT INTO COMPETIR VALUES ('0177','100LF','0 00:00:14.000',7,0);
INSERT INTO COMPETIR VALUES ('0151','400VM','0 00:00:53.890',8,0);
INSERT INTO COMPETIR VALUES ('0153','400VM','0 00:00:50.420',1,30);
INSERT INTO COMPETIR VALUES ('0154','400VM','0 00:00:52.080',6,0);
INSERT INTO COMPETIR VALUES ('0156','400VM','0 00:00:50.780',2,20);
INSERT INTO COMPETIR VALUES ('0158','400VM','0 00:00:51.390',4,10);
INSERT INTO COMPETIR VALUES ('0163','400VM','0 00:00:51.120',3,15);
INSERT INTO COMPETIR VALUES ('0164','400VM','0 00:00:52.020',5,5);
INSERT INTO COMPETIR VALUES ('0170','400VM','0 00:00:53.000',7,0);
INSERT INTO COMPETIR VALUES ('0159','400VF','0 00:00:58.500',4,10);
INSERT INTO COMPETIR VALUES ('0165','400VF','0 00:00:57.340',2,20);
INSERT INTO COMPETIR VALUES ('0166','400VF','0 00:00:58.550',5,5);
INSERT INTO COMPETIR VALUES ('0167','400VF','0 00:00:58.230',3,15);
INSERT INTO COMPETIR VALUES ('0172','400VF','0 00:00:59.580',8,0);
INSERT INTO COMPETIR VALUES ('0178','400VF','0 00:00:59.330',7,0);
INSERT INTO COMPETIR VALUES ('0176','400VF','0 00:00:59.100',6,0);
INSERT INTO COMPETIR VALUES ('0174','400VF','0 00:00:57.230',1,30);
INSERT INTO COMPETIR VALUES ('0153','1500M','0 00:04:03.380',1,30);
INSERT INTO COMPETIR VALUES ('0171','1500M','0 00:04:09.380',2,20);
INSERT INTO COMPETIR VALUES ('0169','1500M','0 00:04:17.380',5,5);
INSERT INTO COMPETIR VALUES ('0168','1500M','0 00:04:15.380',4,10);
INSERT INTO COMPETIR VALUES ('0162','1500M','0 00:04:12.380',3,15);
INSERT INTO COMPETIR VALUES ('0161','1500M','0 00:04:22.380',6,0);
INSERT INTO COMPETIR VALUES ('0156','1500M','0 00:04:31.380',7,0);
INSERT INTO COMPETIR VALUES ('0151','1500M','0 00:04:55.380',8,0);
INSERT INTO COMPETIR VALUES ('0154','1500M','0 00:05:02.380',9,0);
INSERT INTO COMPETIR VALUES ('0157','1500M','0 00:05:52.380',10,0);
INSERT INTO COMPETIR VALUES ('0153','3000OM','0 00:10:43.030',4,10);
INSERT INTO COMPETIR VALUES ('0171','3000OM','0 00:10:32.130',2,20);
INSERT INTO COMPETIR VALUES ('0169','3000OM','0 00:11:42.000',8,0);
INSERT INTO COMPETIR VALUES ('0168','3000OM','0 00:10:14.120',1,30);
INSERT INTO COMPETIR VALUES ('0162','3000OM','0 00:10:40.460',3,15);
INSERT INTO COMPETIR VALUES ('0161','3000OM','0 00:11:15.220',6,0);
INSERT INTO COMPETIR VALUES ('0156','3000OM',NULL,NULL,NULL);
INSERT INTO COMPETIR VALUES ('0151','3000OM','0 00:12:40.100',11,0);
INSERT INTO COMPETIR VALUES ('0154','3000OM','0 00:11:22.540',7,0);
INSERT INTO COMPETIR VALUES ('0157','3000OM','0 00:12:05.020',10,0);
INSERT INTO COMPETIR VALUES ('0158','3000OM','0 00:10:59.230',5,5);
INSERT INTO COMPETIR VALUES ('0164','3000OM','0 00:11:53.130',9,0);
INSERT INTO COMPETIR VALUES ('0173','1500F','0 00:04:55.210',2,20);
INSERT INTO COMPETIR VALUES ('0174','1500F','0 00:04:59.350',3,15);
INSERT INTO COMPETIR VALUES ('0175','1500F','0 00:06:13.050',10,0);
INSERT INTO COMPETIR VALUES ('0178','1500F','0 00:06:04.600',9,0);
INSERT INTO COMPETIR VALUES ('0167','1500F','0 00:05:57.880',8,0);
INSERT INTO COMPETIR VALUES ('0165','1500F','0 00:05:27.110',6,0);
INSERT INTO COMPETIR VALUES ('0159','1500F','0 00:05:38.450',7,0);
INSERT INTO COMPETIR VALUES ('0152','1500F','0 00:04:39.230',1,30);
INSERT INTO COMPETIR VALUES ('0160','1500F','0 00:05:03.140',4,10);
INSERT INTO COMPETIR VALUES ('0166','1500F','0 00:05:23.440',5,5);
INSERT INTO COMPETIR VALUES ('0173','3000OF','0 00:11:45.100',4,10);
INSERT INTO COMPETIR VALUES ('0174','3000OF','0 00:12:20.050',7,0);
INSERT INTO COMPETIR VALUES ('0175','3000OF','0 00:11:48.550',5,5);
INSERT INTO COMPETIR VALUES ('0178','3000OF','0 00:12:34.120',8,0);
INSERT INTO COMPETIR VALUES ('0167','3000OF','0 00:11:22.180',1,30);
INSERT INTO COMPETIR VALUES ('0165','3000OF','0 00:11:32.115',3,15);
INSERT INTO COMPETIR VALUES ('0159','3000OF','0 00:12:55.320',9,0);
INSERT INTO COMPETIR VALUES ('0152','3000OF','0 00:11:24.290',2,20);
INSERT INTO COMPETIR VALUES ('0160','3000OF','0 00:12:09.170',6,0);
INSERT INTO COMPETIR VALUES ('0166','3000OF',null,null,null);
INSERT INTO COMPETIR VALUES ('0172','3000OF','0 00:13:22.150',10,0);
INSERT INTO COMPETIR VALUES ('0176','3000OF',null,null,null);


-- 1
CREATE OR REPLACE PROCEDURE EJ1(NOM VARCHAR2)
AS
CURSOR CEJ1 IS SELECT DORSAL, ATLETA.NOMBRE, APELLIDOS FROM ATLETA INNER JOIN UNIVERSIDAD ON
UNIVERSIDAD = CODIGO WHERE UNIVERSIDAD.NOMBRE = NOM; 
REG CEJ1%ROWTYPE;

BEGIN
OPEN CEJ1;
fetch cej1 into reg;
WHILE CEJ1%FOUND LOOP
    DBMS_OUTPUT.PUT_LINE('DORSAL: '||REG.DORSAL||' NOMBRE: '||REG.NOMBRE||' 
    APELLIDOS: '||REG.APELLIDOS);
    FETCH CEJ1 INTO REG;
END LOOP;
CLOSE CEJ1;
END;

-- 2
CREATE OR REPLACE PROCEDURE EJ2(NOM VARCHAR2, APE VARCHAR2)
AS 
NIV VARCHAR(20);
VNIV VARCHAR(20);
CONTEO NUMBER;
BEGIN
SELECT COUNT(*) INTO CONTEO FROM COMPETIR INNER JOIN ATLETA ON DORSAL = DORSAL_ATL
WHERE NOMBRE = NOM AND APE = APELLIDOS AND POSICION <=3;
SELECT NIVEL INTO  VNIV FROM ATLETA WHERE NOMBRE = NOM AND APE = APELLIDOS;

IF CONTEO > 2 THEN
    NIV := 'PRIMER';
ELSIF CONTEO > 0 THEN
    NIV := 'SEGUNDO';
ELSE NIV := 'TERCER';
END IF;
IF NIV != VNIV OR VNIV IS NULL THEN
    UPDATE ATLETA SET NIVEL = NIV WHERE NOMBRE = NOM AND APELLIDOS = APE;
    DBMS_OUTPUT.PUT_LINE('Num de podios: '||CONTEO||' Nivel: '||NIV);
END IF;

END;


-- 3
CREATE OR REPLACE FUNCTION EJ3(NOM VARCHAR2)
RETURN NUMBER
IS
SUMA NUMBER;

BEGIN
SELECT SUM(PUNTOS) INTO SUMA FROM COMPETIR C, ATLETA A, UNIVERSIDAD U WHERE
UNIVERSIDAD = CODIGO AND DORSAL = DORSAL_ATL AND NOM = U.NOMBRE;
RETURN SUMA;
END;


-- 4
CREATE TABLE AUDITORIA_NIVEL_ATLETA(
    USUARIO VARCHAR(20),
    DORSAL VARCHAR(6),
    NOMBRE VARCHAR(20),
    APELLIDOS VARCHAR(30),
    FECHA DATE,
    NIVEL_ANT VARCHAR(20),
    NIVEL_POS VARCHAR(20));

CREATE OR REPLACE TRIGGER EJ4 AFTER UPDATE OF NIVEL ON ATLETA
FOR EACH ROW

DECLARE

USUARIO VARCHAR(20);

BEGIN

SELECT SYS_CONTEXT('userenv','current_user') INTO USUARIO FROM DUAL;
INSERT INTO AUDITORIA_NIVEL_ATLETA VALUES(USUARIO, :OLD.DORSAL, :OLD.NOMBRE, :OLD.APELLIDOS, SYSDATE, :OLD.NIVEL, :NEW.NIVEL);

END;

SET SERVEROUTPUT ON;

begin
EJ2('Carmen', 'Aguirre Soria');
end;
