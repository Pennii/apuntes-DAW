DROP DATABASE IF EXISTS cursos_bd03;

CREATE DATABASE cursos_bd03;

CREATE TABLE curso(
	codCurso CHAR(4) PRIMARY KEY,
    titulo VARCHAR(20) UNIQUE,
    descripcion TINYTEXT,
    numHoras CHAR(3) DEFAULT '0');

CREATE TABLE unidad(
	codCurso CHAR(4),
    numero CHAR(4),
    titulo VARCHAR(20) NOT NULL,
    numHoras CHAR(3) DEFAULT '0',
    CONSTRAINT un_cod_fk FOREIGN KEY (codCurso) REFERENCES curso(codCurso)
		ON UPDATE CASCADE,
    CONSTRAINT un_pk PRIMARY KEY (codCurso, numero));

CREATE TABLE videoconferencia(
	fecha DATETIME PRIMARY KEY CHECK(fecha > '2020-01-01'),
    contenido TINYTEXT NOT NULL,
    codCurso CHAR(4),
    numero CHAR(4),
    CONSTRAINT vid_cod_num_fk FOREIGN KEY (codCurso, numero) REFERENCES unidad(codCurso, numero)
		ON UPDATE CASCADE ON DELETE CASCADE);
    
ALTER TABLE videoconferencia RENAME TO sesion;

ALTER TABLE sesion ADD COLUMN tipo ENUM ('videocon', 'presencial', 'cuestionario');

CREATE TABLE profesor(
	codProfesor CHAR(4) PRIMARY KEY,
    dni CHAR(9),
    nombre VARCHAR(20),
    apellidos VARCHAR(20),
    fechaNac DATE,
    telefono CHAR(9),
    email VARCHAR(30));

ALTER TABLE curso ADD COLUMN(
	fechaInicio DATE,
    fechaFin DATE,
    codProfesor CHAR(4));
ALTER TABLE curso ADD   CONSTRAINT 
	cur_cod_fa FOREIGN KEY (codProfesor) REFERENCES profesor(codProfesor);

ALTER TABLE profesor ADD INDEX identificacion (apellidos, nombre);

CREATE VIEW profesores_anio AS SELECT nombre, apellidos FROM profesor 
	WHERE (fechaNac BETWEEN 1980-01-01 AND 2000-01-01);

CREATE VIEW titulos AS SELECT titulo, descripcion, numHoras FROM curso
	ORDER BY titulo ASC;

CREATE USER admin_bd03@'%' IDENTIFIED BY '2023';

GRANT INSERT ON sesion TO admin_bd03@'%';