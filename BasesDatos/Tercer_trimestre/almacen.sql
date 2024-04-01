CREATE DATABASE ALMACENES;
USE ALMACENES;

CREATE TABLE ALMACEN(
	CODIGO CHAR(3) PRIMARY KEY,
    LUGAR VARCHAR(60),
    CAPACIDAD INT);

CREATE TABLE CAJAS(
	REFERENCIA CHAR(4) PRIMARY KEY,
    CONTENIDO VARCHAR(60),
    VALOR FLOAT,
    ALMACEN CHAR(3),
    CONSTRAINT CAJ_ALM_FK FOREIGN KEY (ALMACEN) REFERENCES ALMACEN(CODIGO) ON DELETE SET NULL ON UPDATE CASCADE);

INSERT INTO ALMACEN VALUES('001', 'BARCELONA', 3);
INSERT INTO ALMACEN VALUES('002', 'BARCELONA', 8);
UPDATE ALMACEN SET CAPACIDAD = 3;

INSERT INTO CAJAS VALUES('H5RT', 'PAPEL', 200, '002');
INSERT INTO CAJAS VALUES('H6RT', 'PAPEL', 200, '002');
INSERT INTO CAJAS VALUES('H7RT', 'PAPEL', 200, '002');
INSERT INTO CAJAS VALUES('k7RT', 'PAPEL', 200, '002');
start transaction;
SELECT * FROM CAJAS;
SELECT AVG(VALOR) FROM CAJAS;
UPDATE CAJAS SET VALOR = VALOR * 0.85;

UPDATE CAJAS SET VALOR = VALOR * 0.8 WHERE VALOR > (SELECT avg(VALOR) FROM (SELECT * FROM CAJAS) AS CAJA);

DELETE FROM CAJAS WHERE VALOR < 100;

SELECT * FROM ALMACEN;
ROLLBACK;
DELETE FROM ALMACEN WHERE CODIGO IN(SELECT CODIGO FROM (SELECT * FROM ALMACEN) AS ALM INNER JOIN (SELECT ALMACEN, COUNT(*) AS NUM FROM CAJAS GROUP BY ALMACEN) AS CAJA ON CODIGO = ALMACEN WHERE NUM > CAPACIDAD);


