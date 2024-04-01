CREATE DATABASE IF NOT EXISTS tienda_informatica;
USE tienda_informatica;

CREATE TABLE fabricantes(
	codigo char(3) PRIMARY KEY,
    nombre VARCHAR (20));

CREATE TABLE articulos(
	codigo char(3) PRIMARY KEY,
    nombre varchar(20),
    precio float,
    fabricante char(3),
    constraint art_fab_fk FOREIGN KEY (fabricante) REFERENCES fabricantes(codigo) ON DELETE SET NULL ON UPDATE CASCADE);
    
INSERT INTO fabricantes VALUES(2, 'Julian Gomez');
INSERT INTO articulos VALUES(1, 'Altavoces', 70, 2);

INSERT INTO articulos VALUES(8, 'Altavoces', 70, 2);
UPDATE articulos SET nombre = 'Impresora laser' WHERE codigo = 8;

UPDATE articulos SET precio = precio * 0.9;

INSERT INTO articulos VALUES(3, 'PC', 130, 2);
select * from articulos;
UPDATE articulos SET precio = precio - 10 WHERE precio >= 120;