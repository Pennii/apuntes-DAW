CREATE DATABASE IF NOT EXISTS liga;

CREATE TABLE equipos(
	Siglas CHAR(4) PRIMARY KEY,
	nombre VARCHAR(20) UNIQUE,
	puntos TINYINT,
	golesFavor TINYINT,
	golesContra TINYINT,
	nomEntrenador VARCHAR(30),
	provincia VARCHAR(30));
    
CREATE TABLE jugadoras(
	DNI CHAR (9) PRIMARY KEY,
	nombre VARCHAR(30),
	apellidos VARCHAR(30),
	fec_nac DATE NOT NULL,
	equipo CHAR(4),
	CONSTRAINT jug_eq_FK FOREIGN KEY (equipo) REFERENCES equipos (siglas) ON DELETE SET NULL ON UPDATE CASCADE);

CREATE TABLE partidos(
	codigo CHAR(4) PRIMARY KEY,
    fecha DATE CHECK (fecha BETWEEN '2022-01-01' AND '2022-06-30'),
    resultado VARCHAR(5),
    nomArbitro VARCHAR(30),
    incidencias TEXT,
    equipoLoc CHAR(4),
    equipoVist CHAR(4),
    golesLoc TINYINT(3) DEFAULT 0,
    golesVist TINYINT(3) DEFAULT 0,
    CONSTRAINT part_eqLoc_FK FOREIGN KEY (equipoLoc) REFERENCES equipos (Siglas)ON DELETE SET NULL ON UPDATE CASCADE,
    CONSTRAINT part_eqVis_FK FOREIGN KEY (equipoVist) REFERENCES equipos (Siglas)ON DELETE SET NULL ON UPDATE CASCADE);
    
    ALTER TABLE jugadoras ADD COLUMN puesto ENUM ('Portera', 'Defensa', 'Delantera');
    
    ALTER TABLE partidos RENAME COLUMN nomArbitro TO colegiado;
    
    ALTER TABLE equipos ADD INDEX (puntos);
    

    CREATE VIEW CLASIFICACION AS SELECT nombre, puntos  FROM equipos ORDER BY puntos DESC;
    
    INSERT INTO equipos (siglas, nombre, puntos) VALUES ('cabj', 'boca', 12);
    INSERT INTO equipos (siglas, nombre, puntos) VALUES ('carp', 'river', 20);
	select * from equipos;
    select * FROM clasificacion;
    DELETE from equipos where(nombre = 'boca');
    
    CREATE USER arbitro IDENTIFIED BY '1234';
    

    GRANT UPDATE ON partidos TO arbitro;