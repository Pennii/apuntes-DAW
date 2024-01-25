create database club;

create table atleta(
dorsal CHAR(2) PRIMARY KEY,
nombre VARCHAR(20),
apellido VARCHAR(20), 
nacionalidad VARCHAR(30) DEFAULT 'ESPAÑA',
sexo VARCHAR(20),
fec_nac DATE NOT NULL CHECK(fec_nac > '2000-01-01'));

create table instalacion(
referencia CHAR(3) PRIMARY KEY,
nombre VARCHAR(20) UNIQUE,
descripcion VARCHAR(40),
aforo smallint, 
direccion VARCHAR(40));

create table prueba(
codigo CHAR(3) PRIMARY KEY,
nombre VARCHAR(20),
descripcion VARCHAR(40),
rec_olimp VARCHAR(20),
rec_mundo VARCHAR(20),
fec_hora DATETIME,
ref_instalacion CHAR(3),
CONSTRAINT pru_ref_fk FOREIGN KEY (ref_instalacion) REFERENCES instalacion(referencia)
ON DELETE SET NULL ON UPDATE CASCADE);

create table participar(
dorsal_atl CHAR(2),
codigo_pru CHAR(3),
marca_personal SMALLINT,
posicion TINYINT CHECK(posicion BETWEEN 1 AND 50),
CONSTRAINT part_pk PRIMARY KEY (dorsal_atl, codigo_pru),
CONSTRAINT part_dor_fk FOREIGN KEY (dorsal_atl) REFERENCES atleta(dorsal)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT part_cod_fk FOREIGN KEY (codigo_pru) REFERENCES prueba(codigo)
ON DELETE CASCADE ON UPDATE CASCADE);

alter TABLE atleta MODIFY COLUMN sexo ENUM ("H", "M");

ALTER TABLE participar ADD COLUMN incidencias TINYTEXT AFTER codigo_pru;

ALTER TABLE instalacion DROP COLUMN direccion;

ALTER TABLE participar DROP CONSTRAINT participar_chk_1;
ALTER TABLE participar RENAME COLUMN posicion TO puesto;
ALTER TABLE participar ADD CONSTRAINT part_pues_chk CHECK(puesto BETWEEN 1 AND 50);

ALTER TABLE instalacion ADD 
CONSTRAINT ins_af_chk CHECK(aforo BETWEEN 500 AND 5000);

ALTER TABLE atleta ADD INDEX nombres (nombre);

CREATE USER usuario_club@'%' IDENTIFIED BY 'BD03';

GRANT INSERT, UPDATE ON atleta TO usuario_club@'%';

REVOKE UPDATE ON atleta from usuario_club@'%';


INSERT INTO atleta (dorsal, nombre, apellido, sexo) VALUES("10", "lionel", 'messi', 'H');
INSERT INTO atleta VALUES('05', 'agustin', 'viras', 'frances', 'H', '2001-05-03');
UPDATE atleta SET fec_nac = '2005-04-04' WHERE nombre = 'lionel';
INSERT INTO instalacion VALUES('A01','MIRADOR','CANCHA GRANDE',505);
INSERT INTO instalacion VALUES('B52','RIO AZUL', 'MUCHO AFORO', 5000);

INSERT INTO prueba (codigo, nombre, ref_instalacion) VALUES('X02', 'CORLEJO', 'A01');
INSERT INTO prueba VALUES('Z41', 'DROPEO', 'NO DEJES CAER NADA', 'AAAA', 'BBB', '2024-01-20 15:30:00', 'B52');

INSERT INTO participar (dorsal_atl, codigo_pru, puesto) VALUES('10', 'X02', 1);
INSERT INTO participar VALUES('05', 'X02', 'NINGUNA', 47, 6);
