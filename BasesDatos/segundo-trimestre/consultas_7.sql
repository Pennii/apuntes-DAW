CREATE DATABASE ciencia;

CREATE TABLE cientificos(
	DNI CHAR(9) PRIMARY KEY,
    NomApels VARCHAR(20));

CREATE TABLE proyecto(
	Id CHAR(2) PRIMARY KEY,
    Nombre VARCHAR(20),
    Horas INT);

CREATE TABLE asignado(
	Cientifico CHAR(9),
    Proyecto CHAR(2),
    CONSTRAINT asig_cient_fk FOREIGN KEY (cientifico) REFERENCES cientificos(DNI),
    CONSTRAINT asig_pro_fk FOREIGN KEY (proyecto) REFERENCES proyecto(id),
    CONSTRAINT asig_pk PRIMARY KEY (cientifico, proyecto)
    );

INSERT INTO cientificos VALUES('A12345678', 'JOSE GUTIERRES');
INSERT INTO cientificos VALUES('B12345678', 'RAUL DIAZ');
INSERT INTO cientificos VALUES('C12345678', 'CARLOS BERTRAN');
INSERT INTO cientificos VALUES('D12345678', 'LAURA LOPEZ');
INSERT INTO cientificos VALUES('E12345678', 'GONZALO RAMOS');
INSERT INTO cientificos VALUES('F12345678', 'SOFIA LOPEZ');
INSERT INTO cientificos VALUES('G12345678', 'JUAN MARTINEZ');
INSERT INTO cientificos VALUES('H12345678', 'SUSANA FERNANDEZ');
INSERT INTO cientificos VALUES('I12345678', 'MAXIMO PEREZ');
INSERT INTO cientificos VALUES('J12345678', 'ALBERTO MAEZ');

INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
INSERT INTO proyecto VALUES();
    