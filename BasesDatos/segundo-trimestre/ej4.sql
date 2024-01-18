DROP DATABASE IF EXISTS conferencias_bd03;

CREATE DATABASE conferencias_bd03;

CREATE TABLE PERSONAL(
	codPersonal char(4) PRIMARY KEY,
	dni char(9) UNIQUE,
	nombre varchar(20),
	apellido varchar(20),
    fecNacimiento DATE,
    telefono char(9) UNIQUE,
    direccion varchar(30));

CREATE TABLE administrativo(
	codAdministrativo char(4) primary key,
	CONSTRAINT ad_cod_fk FOREIGN KEY (codAdministrativo) REFERENCES personal(codPersonal)
    ON UPDATE CASCADE);

CREATE TABLE jefe(
	codJefe char(4) PRIMARY KEY,
    fechaIncorporacion DATE,
    CONSTRAINT jef_cod_fk FOREIGN KEY (codJefe) REFERENCES personal(codPersonal)
    ON UPDATE CASCADE);

CREATE TABLE conferencia(
	codConferencia char(4) PRIMARY KEY,
    titulo VARCHAR(20) UNIQUE);

CREATE TABLE edicion(
	codConferencia CHAR(4),
	numero char(3),
	lugar VARCHAR(30),
	fecha DATE,
	aforo SMALLINT,
	CONSTRAINT ed_PK PRIMARY KEY (codConferencia, numero),
	CONSTRAINT ed_cod_fk FOREIGN KEY (codConferencia) REFERENCES conferencia(codConferencia));

CREATE TABLE ASISTENCIA(
	codJefe CHAR(4),
    codConferencia char(4),
    numero char(3),
    CONSTRAINT asis_PK PRIMARY KEY (codJefe, Codconferencia, numero),
    CONSTRAINT asis_codJef_fk FOREIGN KEY (codJefe) REFERENCES jefe(codJefe) ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT asis_conf_fk FOREIGN KEY (codConferencia, numero) REFERENCES edicion(codConferencia, numero));

CREATE TABLE CATEGORIA(
	codCategoria CHAR(4) PRIMARY KEY,
    nombre VARCHAR(20) UNIQUE);

ALTER TABLE administrativo ADD COLUMN 
codJefeSupervisor char(4);
ALTER TABLE administrativo ADD CONSTRAINT
adminis_codJef_fk FOREIGN KEY (codJefeSupervisor) REFERENCES jefe(codJefe);

ALTER TABLE conferencia ADD COLUMN
codCategoria char(4);
ALTER TABLE conferencia ADD CONSTRAINT
conf_codCat_fk foreign KEY (codCategoria) REFERENCES categoria(codCategoria);

ALTER TABLE PERSONAL ADD INDEX ap_nom_ind (apellido, nombre);

CREATE VIEW personalMayor AS SELECT nombre, apellido FROM personal where fecNac < '1980-01-01';

ALTER TABLE personal Rename COLUMN fecNacimiento TO fecNac;

ALTER TABLE jefe rename column fechaIncorporacion to fecinc;

CREATE USER usuario_bd03@'localhost' identified by 'root';
GRANT INSERT, SELECT ON conferencias_bd03.* TO usuario_bd03@'localhost';





DROP DATABASE usuario_bd03;