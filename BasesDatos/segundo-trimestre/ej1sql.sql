CREATE DATABASE GUIATUR;

CREATE TABLE GUIATUR.GUIAS_TURISTICOS(
	NIF CHAR(9) PRIMARY KEY,
    Nombre VARCHAR(30),
    Apellidos VARCHAR(30),
    Fecha_nac DATE,
    Nacionalidad VARCHAR(30) DEFAULT "España",
    Fecha_alta DATE NOT NULL,
    Salario FLOAT,
    Titulacion TINYTEXT);
    
CREATE TABLE GUIATUR.RUTAS(
	Codigo CHAR(3) PRIMARY KEY,
    Nombre VARCHAR(30) UNIQUE,
    Distancia SMALLINT CHECK (Distancia BETWEEN 100 AND 5000),
    Categoria ENUM ("U", "R"),
    Recomendaciones TINYTEXT,
    Valoraciones TINYINT,
    NIF_guia char(9),
	/* LOS CONSTRAINT DEBEN TENER EL NOMBRE DE LA TABLA EN LA QUE ESTAN, NO LA AJENA */
    CONSTRAINT GT_NIF_FK FOREIGN KEY (NIF_guia) REFERENCES GUIAS_TURISTICOS(NIF) ON UPDATE CASCADE ON DELETE SET NULL);
    
CREATE TABLE GUIATUR.LUGARES_INTERES(
	Referencia CHAR(5) PRIMARY KEY,
	Nombre VARCHAR(30),
	Descripcion TINYTEXT,
    Curiosidades TINYTEXT,
	Codigo_ruta CHAR(3),
	CONSTRAINT Rutas_codigo_FK FOREIGN KEY (Codigo_ruta) REFERENCES RUTAS(Codigo) ON UPDATE CASCADE ON DELETE SET NULL);
    
ALTER TABLE guias_turisticos DROP Apellidos;

ALTER TABLE guias_turisticos ADD(
	Apellido1 VARCHAR(20),
	Apellido2 VARCHAR(20));    

ALTER TABLE rutas ADD CONSTRAINT RUT_Val_CHK CHECK (Valoraciones BETWEEN 0 and 10);

ALTER TABLE guias_turisticos ADD CONSTRAINT GT_Fecha_CHK CHECK (Fecha_alta > Fecha_nac);

ALTER TABLE rutas DROP CONSTRAINT rutas_chk_1;

CREATE INDEX indice_nombre ON lugares_interes (nombre);

ALTER TABLE guias_turisticos RENAME COLUMN Salario TO Sueldo;

RENAME TABLE guias_turisticos TO empleados;

ALTER TABLE empleados MODIFY Apellido1 VARCHAR(25) AFTER Nombre;

ALTER TABLE empleados MODIFY Apellido2 VARCHAR(25) AFTER Nombre;

DROP TABLE lugares_interes;