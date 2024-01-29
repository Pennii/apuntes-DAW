CREATE DATABASE colegio_tarea;

CREATE TABLE alumno(
	DNI_A CHAR(9) PRIMARY KEY,
    Nombre VARCHAR(20),
    Apellido VARCHAR(30),
    Edad TINYINT);

CREATE TABLE profesor(
	DNI_P CHAR(9) PRIMARY KEY,
    Nombre VARCHAR(20),
    Apellidos VARCHAR(30),
    Direccion VARCHAR(40),
    Tlfn CHAR(9) /*Unicamente se tendran en cuenta telefonos locales*/);

CREATE TABLE aula(
	Cod_Aula CHAR(4) PRIMARY KEY,
    Tipo ENUM ('TIC', 'Informatica', 'Standar'),
    Aforo TINYINT DEFAULT 30);

CREATE TABLE asignatura(
	Cod_asig CHAR(4) PRIMARY KEY,
    Nombre VARCHAR(20) UNIQUE,
    Horas CHAR(3) NOT NULL, /*Se tendra en cuenta que son las horas totales*/
    DNI_P CHAR(9),
    Aula CHAR(4),
    CONSTRAINT asig_dni_fk FOREIGN KEY (DNI_P) REFERENCES profesor(DNI_P) ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT asig_aul_fk FOREIGN KEY (Aula) REFERENCES aula(Cod_aula) ON DELETE SET NULL ON UPDATE CASCADE);
    
CREATE TABLE se_matricula(
	DNI_A CHAR(9),
    Cod_asig CHAR(4),
    Curso_escolar CHAR(9),
    Nota FLOAT CHECK(Nota BETWEEN 0 AND 10),
    CONSTRAINT mat_pk PRIMARY KEY (DNI_A, Cod_asig, Curso_escolar),
    CONSTRAINT mat_dni_fk FOREIGN KEY (DNI_A) REFERENCES alumno(DNI_A) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT mat_cod_fk FOREIGN KEY (Cod_asig) REFERENCES asignatura(Cod_asig) ON DELETE CASCADE ON UPDATE CASCADE);
    
ALTER TABLE alumno DROP COLUMN edad;

ALTER TABLE alumno ADD COLUMN F_nacimiento DATE NOT NULL;

ALTER TABLE se_matricula ADD INDEX notas (nota);

CREATE USER director@'%' IDENTIFIED BY 'admin';

GRANT UPDATE, DELETE ON asignatura TO director@'%';

REVOKE DELETE ON asignatura FROM director@'%';

INSERT INTO alumno VALUES('A12345678', 'JAVIER', 'GUTIERRES', '2005-02-05');
INSERT INTO alumno VALUES('A23456789', 'AGUSTINA', 'PEREZ', '2003-01-10');

INSERT INTO profesor (DNI_P, Nombre) VALUES('B12345678', 'JULIAN');
INSERT INTO profesor VALUES('B23456789', 'ADRIAN', 'RODRIGUEZ', 'CALLE123', '111223344');

INSERT INTO aula (Cod_aula) VALUES('A001');
INSERT INTO aula VALUES('A002', 'TIC', 15);

INSERT INTO asignatura VALUES('AAA1', 'MATEMATICA', '098', 'B12345678', 'A001');
INSERT INTO asignatura VALUES('AAB1', 'INFORMATICA', '064', 'B23456789', 'A002');

INSERT INTO se_matricula VALUES('A12345678', 'AAA1', '2023-2024', 8.7);
INSERT INTO se_matricula VALUES('A12345678', 'AAB1', '2023-2024', 7);

INSERT INTO asignatura VALUES('BBB1', 'FISICA', '100', '123546789', 'A001');/*El dni del profesor no es valido*/

INSERT INTO se_matricula VALUES('A23456789', 'AAA1', '2024-2025', 11);/*La nota esta fuera del limite establecido*/

INSERT INTO aula (Cod_aula, tipo) VALUES('Z003', 'Standar');/*El valor aforo sera el por defecto*/