CREATE DATABASE IF NOT EXISTS agencia;

CREATE TABLE propietario(
DNI CHAR(9) PRIMARY KEY,
nombre VARCHAR(20),
apellido VARCHAR(20),
numCuenta CHAR(16) UNIQUE,
beneficio FLOAT);

CREATE TABLE mantenimiento(
CIF CHAR(9) PRIMARY KEY,
nombre VARCHAR(20),
responsable VARCHAR(20),
numEmpleados SMALLINT,
razonSocial VARCHAR(30));

CREATE TABLE cliente(
DNI CHAR(9) PRIMARY KEY,
nombre VARCHAR(20),
apellido VARCHAR(20),
telefono CHAR(9),
numTarjeta CHAR(16) NOT NULL,
f_nac DATE);

CREATE TABLE vivienda(
referencia CHAR(4) PRIMARY KEY,
direccion VARCHAR(20),
localidad VARCHAR(20),
provincia VARCHAR(20),
n_habitaciones CHAR(2),
n_camas CHAR(2) DEFAULT 01,
n_aseos CHAR(2) DEFAULT 01,
metros2 FLOAT,
precioDia FLOAT CHECK(precioDia BETWEEN 20 AND 120),
CIF_mantenimiento CHAR(9),
DNI_propietario CHAR(9),
CONSTRAINT viv_cif_fk FOREIGN KEY (CIF_mantenimiento) REFERENCES mantenimiento(CIF)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT viv_DNI_fk FOREIGN KEY (DNI_propietario) REFERENCES propietario(DNI)
ON UPDATE CASCADE ON DELETE CASCADE);

CREATE TABLE reserva(
refViv CHAR(4),
DNI_cliente CHAR(9),
f_ent DATE,
f_sal DATE,
precioTotal FLOAT,
cantidadPersonas CHAR(2),
CONSTRAINT res_pk PRIMARY KEY (refViv, DNI_cliente, f_ent),
CONSTRAINT res_dni_fk FOREIGN KEY (DNI_cliente) REFERENCES cliente(DNI)
ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT res_ref_fk FOREIGN KEY (refViv) REFERENCES vivienda(referencia)
	ON UPDATE CASCADE ON DELETE CASCADE,
CONSTRAINT res_fec_ck CHECK(f_ent < f_sal));

CREATE VIEW VIVIENDAS_ALMERIA AS SELECT * FROM vivienda WHERE provincia = 'almeria';

ALTER TABLE propietario RENAME COLUMN numCuenta TO IBAN;

ALTER TABLE reserva ADD COLUMN fechaRes DATETIME DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE mantenimiento ADD INDEX nombres (nombre);

CREATE USER agente@'%' IDENTIFIED BY 'ag123'; 

GRANT SELECT ON reserva TO agente;



INSERT INTO cliente VALUES ("A12345678","Matias", "Pennino", "123456789", "1234567890123456", "2002-04-20");
INSERT INTO cliente VALUES ('B12345678', 'Agustin', 'Pennino', '234567890', '2345678900123456', '2002-04-20');

INSERT INTO mantenimiento VALUES('C12345678', 'Repo', 'Facundo', 15, 'aaa');
INSERT INTO mantenimiento VALUES('C23456780', 'Repa', 'Nahuel', 2, 'bbb');

INSERT INTO PROPIETARIO VALUES('A23456789', 'Ricardo', 'Pennino', '6543210987654321', 32);
INSERT INTO PROPIETARIO VALUES('B23456789', 'Alberto', 'Pennino', '0213456789012345', 25.2);

INSERT INTO VIVIENDA (referencia, direccion, localidad, provincia, n_habitaciones, n_camas, n_aseos, metros2, precioDia) VALUES('A007', 'SSS', 'AGUADULCE', 'ALMERIA', 3, 2, 1, 60, 50);
INSERT INTO VIVIENDA (referencia, direccion, localidad, provincia, n_habitaciones,  metros2, precioDia) VALUES('B002', 'SSE', 'MADRID', 'MADRID', 1, 25, 80);

INSERT INTO RESERVA (refViv, dni_cliente, f_ent, f_sal, precioTotal, cantidadPersonas) VALUES('A001', 'A12345678', '2024-01-25', '2024-01-26', 230, 2);
INSERT INTO RESERVA(refViv, dni_cliente, f_ent, f_sal, precioTotal, cantidadPersonas) VALUES('B002', 'A12345678', '2024-01-30', '2024-02-5', 600, 1);

SELECT * FROM VIVIENDA;
SELECT * FROM viviendas_almeria;
UPDATE propietario SET dni = 'C12345678' WHERE dni = 'A23456789';