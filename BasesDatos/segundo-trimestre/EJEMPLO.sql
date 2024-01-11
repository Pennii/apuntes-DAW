CREATE DATABASE base1;

USE base1;

CREATE TABLE alumno(
nombre VARCHAR(20),
apellido VARCHAR(25),
CONSTRAINT alu_pk PRIMARY KEY (nombre, apellido),
ingreso TIMESTAMP DEFAULT CURRENT_TIMESTAMP);

INSERT INTO alumno (nombre, apellido) VALUES ('matias','pennino');
INSERT INTO alumno (nombre, apellido) VALUES ('facundo','sup');

CREATE TABLE PARTIDAS(
Cod_Partida INTEGER(8) PRIMARY KEY,
Nombre VARCHAR(20)
);

CREATE TABLE USUARIOS (
    Login VARCHAR(25) PRIMARY KEY,
    Cod_Partida INTEGER(8),
    F_Partida DATE,
    /*
    DECLARACION DE CLAVES AJENAS, LA RESTRICCION SET NULL PROVOCA QUE AL BORRAR LA FILA CON ESA CLAVE EL VALOR EN LA TABLA SEA NULO,
    TAMBIEN SE PUEDE HACER QUE LA FILA SE BORRE EN AMBAS TABLAS, PERO POR DEFECTO MYSQL NO DEJARA QUE LO BORREMOS.
    DE IGUAL FORMA QUE SUCEDE CON EL DELTE, HAY QUE PONER RESTRICCIONES PARA EL UPDATE.
    */
    CONSTRAINT Usu_Cod_FK FOREIGN KEY (Cod_Partida)
	REFERENCES PARTIDAS (Cod_Partida) ON DELETE SET NULL ON UPDATE CASCADE
); 
/*
INSERCION DE VALOR PONIENDO TODOS LOS CAMPOS
*/
INSERT INTO PARTIDAS (Cod_Partida, nombre) VALUES (1234,'Partida1');

INSERT INTO PARTIDAS (Cod_Partida, nombre) VALUES (1222,'Partida2');
/*
INSERCION DE VALORES SIN PONER TODOS LOS CAMPOS
*/
INSERT INTO USUARIOS VALUES ('U001',1234,'2023/12/19');

INSERT INTO USUARIOS (Login, F_Partida) VALUES ('U002','2023/12/19');
/*
ACTUALIZACION DE CAMPOS 
*/
UPDATE USUARIOS SET Cod_partida = 1222 WHERE login = 'U002';

/*
ELIMINACION DE FILAS
*/
DELETE FROM PARTIDAS WHERE (Cod_partida = 1234);

UPDATE PARTIDAS SET Cod_Partida = 5678 WHERE Cod_partida = 1222;

SELECT * FROM base1.alumno;
SELECT * FROM alumno WHERE apellido = 'pennino';
SELECT * from usuarios;


