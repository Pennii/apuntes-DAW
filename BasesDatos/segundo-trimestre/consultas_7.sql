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

INSERT INTO proyecto VALUES('A0', 'EXPLORACION',40);
INSERT INTO proyecto VALUES('A1', 'INVESTIGACION', 36);
INSERT INTO proyecto VALUES('B0', 'LIMPIEZA', 12);
INSERT INTO proyecto VALUES('A3', 'DOCUMENTACION', 15);
INSERT INTO proyecto VALUES('C1', 'INVESTIGACION', 14);
INSERT INTO proyecto VALUES('A2', 'DESARROLLO', 34);
INSERT INTO proyecto VALUES('B1', 'PREPARACION', 8);
INSERT INTO proyecto VALUES('A4', 'RESTAURACION', 16);
INSERT INTO proyecto VALUES('B2', 'ESTUDIO', 20);
INSERT INTO proyecto VALUES('C2', 'TRASLADO', 3);

INSERT INTO asignado VALUES('A12345678', 'A0');
INSERT INTO asignado VALUES('A12345678', 'B2');
INSERT INTO asignado VALUES('A12345678', 'A4');
INSERT INTO asignado VALUES('B12345678', 'A0');
INSERT INTO asignado VALUES('C12345678', 'C2');
INSERT INTO asignado VALUES('D12345678', 'C1');
INSERT INTO asignado VALUES('E12345678', 'B1');
INSERT INTO asignado VALUES('A12345678', 'A3');
INSERT INTO asignado VALUES('J12345678', 'B0');
INSERT INTO asignado VALUES('F12345678', 'A4');
INSERT INTO asignado VALUES('G12345678', 'A3');

select c.*, p.id, p.nombre from cientificos c, proyecto p, asignado where dni = cientifico and id = proyecto;
SELECT c.*, count(proyecto) from cientificos c, asignado where cientifico = dni GROUP BY cientifico;
SELECT id, nombre, count(cientifico) FROM proyecto p, asignado WHERE proyecto = id GROUP BY proyecto;
select dni, sum(horas) from cientificos, asignado, proyecto where proyecto = id and cientifico = dni GROUP BY dni;
(select sum(horas) from asignado, proyecto, cientificos where dni = cientifico and proyecto = id GROUP BY dni having sum(horas) > 80) ;
select c.* from cientificos c, asignado, proyecto where dni = cientifico and proyecto = id GROUP BY dni having sum(horas) >= 80 and count(proyecto) > 1 ;