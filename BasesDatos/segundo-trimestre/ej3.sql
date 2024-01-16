CREATE DATABASE IF NOT EXISTS CADENA_HOTEL;

CREATE TABLE categoria(
	ID_categoria char(4) PRIMARY KEY,
	descripcion TINYTEXT,
	iva FLOAT DEFAULT 21);

CREATE TABLE hotel(
	codigo char(3) PRIMARY KEY,
	nombre varchar(20) UNIQUE,
	direccion varchar(20),
	telefono CHAR(9),
	anio DATE, 
    id_categoria CHAR(4),
    CONSTRAINT hot_id_fk FOREIGN KEY (id_categoria) REFERENCES categoria(id_categoria)
    ON DELETE CASCADE ON UPDATE CASCADE);
    
CREATE TABLE habitacion(
	codigo_hotel char(3),
	n_habitacion char(3),
	tamaño VARCHAR(20),
	precio SMALLINT,
	tipo varchar(20),
	CONSTRAINT hab_cod_fk FOREIGN KEY (codigo_hotel) REFERENCES hotel(codigo) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT hab_pk PRIMARY KEY (codigo_hotel, n_habitacion));

CREATE TABLE cliente(
	dni char(9) PRIMARY key,
	nombre_cli VARCHAR(20) NOT NULL,
	direccion varchar(20),
	telefono char(9));

CREATE TABLE reserva(
	codigo_hotel char(3),
	n_habitacion char(3),
	dni_cliente char(9),
	importe SMALLINT,
	f_inicio DATE,
	f_fin DATE,
    CONSTRAINT res_cod_hab_fk FOREIGN KEY (codigo_hotel, n_habitacion) REFERENCES habitacion(codigo_hotel, n_habitacion)
    ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT res_dni_fk foreign key (dni_cliente) REFERENCES cliente(dni) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT res_pk PRIMARY KEY (codigo_hotel, n_habitacion, dni_cliente, f_inicio));

ALTER TABLE hotel DROP COLUMN telefono;

ALTER TABLE reserva ADD INDEX (importe);

ALTER TABLE cliente ADD COLUMN 
tipo ENUM ('Turista','Viajero','Negocios');

CREATE USER gerente IDENTIFIED BY 'root';

CREATE USER recepcionista IDENTIFIED BY 'ROOT';
GRANT INSERT ON reserva TO recepcionista;
GRANT DELETE ON reserva TO recepcionista;

REVOKE DELETE ON reserva FROM recepcionista;