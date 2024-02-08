CREATE DATABASE proyecciones;

CREATE TABLE peliculas(
	codigo CHAR(3) PRIMARY KEY,
    nombre VARCHAR(10),
    clasificacion_edad VARCHAR(6));

CREATE TABLE salas (
	codigo CHAR(3) PRIMARY KEY,
    nombre VARCHAR(20),
    pelicula CHAR(3),
    CONSTRAINT sal_pel_fk FOREIGN KEY (pelicula) REFERENCES peliculas(codigo));


INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('001', 'Pelicula1', 'PG');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('002', 'Pelicula2', 'PG-13');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('003', 'Pelicula3', 'R');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('004', 'Pelicula4', 'PG');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('005', 'Pelicula5', 'R');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('006', 'Pelicula6', 'PG-13');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('007', 'Pelicula7', 'R');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('008', 'Pelicula8', 'PG');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('009', 'Pelicula9', 'PG-13');
INSERT INTO peliculas (codigo, nombre, clasificacion_edad) VALUES ('010', 'Pelicula10', 'R');


INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S001', 'Sala1', '001');
INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S002', 'Sala2', '002');
INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S003', 'Sala3', '003');
INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S004', 'Sala4', '004');
INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S005', 'Sala5', '005');
INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S011', 'Sala11', NULL);
INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S012', 'Sala12', NULL);
INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S013', 'Sala13', NULL);
INSERT INTO salas (codigo, nombre, pelicula) VALUES ('S014', 'Sala14', NULL);
