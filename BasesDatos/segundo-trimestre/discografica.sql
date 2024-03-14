CREATE DATABASE fonoteca;
use fonoteca;

CREATE TABLE discografica(
	cod_discografica varchar(30) primary key,
    nombre varchar(30),
    pais varchar(30));

CREATE TABLE disco(
	cod_disco varchar (30) primary key,
    titulo varchar(30),
    artista varchar(30),
    fecha date,
    discografia varchar(30),
    precio float,
    soporte varchar(30),
    constraint dis_disc_fk foreign key (discografia) references discografica(cod_discografica) on delete set null on update cascade);
    
insert into discografica values
('d01', 'sony', 'reino unido'),
('d02', 'emi', 'reino unido'),
('d03', 'warner', 'usa'),
('d04', 'polygram', 'suiza'),
('d05', 'bcore', 'españa'),
('d06', 'subterfuge', 'españa'),
('d07', 'abeille', 'francia'),
('d08', 'molecula', 'mexico');

insert into disco values
('lp01','dark side of the moon', 'pink floyd', '1973-03-25', 'd01',23,'vinilo'),
('lp02','rincon exquisito', 'second', '2010-05-25', 'd06',20,'cd'),
('lp03','super8', 'Los planetas', '1998-05-20', 'd06',25,'mp3'),
('lp04','supersubmarina', 'supersubmarina', '2008-10-25', 'd06',15,'cd'),
('lp05','maniobras en japon', 'love of lesbian', '2010-02-02', 'd05',30,'vinilo'),
('lp06','a love supreme', 'john coltrane', '1964-03-25', 'd03',20,'cd'),
('lp07','live in paris', 'diana krall', '2002-08-25', 'd02',14,'cd');
-- 1
INSERT INTO disco (cod_disco, titulo, artista, discografica, precio, soporte) values("lp09", "so", "peter gabriel", "d01", 12, "mp3");
-- 2
UPDATE discografica SET nombre = "bbcore" WHERE pais = "islandia";
-- 3
UPDATE disco SET titulo = "animals" WHERE cod_disco = "lp01";
-- 4
UPDATE disco SET precio = precio * 1.10;
-- 5
UPDATE disco SET precio = precio - 3 WHERE discografica in(SELECT cod_discografica FROM discografica WHERE nombre = "subterfuge");
-- 6
UPDATE disco SET precio = precio + 2 WHERE discografica = "d06" AND soporte = "cd";
-- 7
UPDATE disco SET precio = precio + 5 WHERE fecha IS NOT NULL ORDER BY fecha limit 2;
-- 8
UPDATE disco SET precio = precio - 5 WHERE fecha IS NOT NULL ORDER BY fecha DESC limit 2;
-- 9
DELETE FROM disco WHERE titulo = "a love supreme";
-- 10
DELETE FROM disco WHERE fecha = (SELECT fecha FROM (SELECT * FROM disco) AS DIS ORDER BY 1 DESC LIMIT 1);
select * from disco;
Start TRANSACTION;
UPDATE disco SET cod_disco = "lp01" WHERE titulo = "animals";
ROLLBACK;
COMMIT;
lock tables disco read;
unlock tables;