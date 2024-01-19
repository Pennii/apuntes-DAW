

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
ON UPDATE CASCADE ON DELETE CASCADE);

CREATE VIEW VIVIENDAS_ALMERIA AS SELECT * FROM vivienda WHERE provincia = 'almeria';

ALTER TABLE propietario RENAME COLUMN numCuenta TO IBAN;

ALTER TABLE reserva ADD COLUMN fechaRes DATETIME DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE mantenimiento ADD INDEX nombres (nombre);

CREATE USER agente@'%' IDENTIFIED BY 'ag123'; 

GRANT SELECT ON reserva TO agente;