/*CREACIÓN DE LA BASE DE DATOS Y SUS TABLAS*/

CREATE DATABASE IF NOT EXISTS EXCURSIONES; 
USE EXCURSIONES;

CREATE TABLE IF NOT EXISTS RECURSO (
Codigo char(3) PRIMARY KEY,
Nombre VARCHAR(50) UNIQUE,
Stock TINYINT
);

CREATE TABLE IF NOT EXISTS RUTA (
Codigo_R char(3) PRIMARY KEY,
Nombre VARCHAR(50) UNIQUE,
Descripcion VARCHAR(50),
Precio FLOAT(6,2),
Tipo enum ('Fácil', 'Media', 'Difícil', 'Extrema')
);

CREATE TABLE IF NOT EXISTS USA (
Ruta char(3),
Recurso char(3),
Cantidad Tinyint,
CONSTRAINT US_PK PRIMARY KEY(RUTA, RECURSO),
CONSTRAINT USA_RE_FK FOREIGN KEY (RECURSO) REFERENCES  RECURSO (CODIGO) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT USA_RU_FK FOREIGN KEY (RUTA) REFERENCES  RUTA (CODIGO_R) ON DELETE CASCADE ON UPDATE CASCADE
);


CREATE TABLE IF NOT EXISTS  EMPLEADO (
DNI CHAR(9) PRIMARY KEY,
Nombre VARCHAR(50),
Apellidos VARCHAR(50),
F_nac DATE,
Salario FLOAT(6,2)
);


CREATE TABLE IF NOT EXISTS  USUARIO (
CODIGO_U CHAR(5) PRIMARY KEY,
DNI CHAR(9),
Nombre VARCHAR(50),
Apellidos VARCHAR(50),
Telefono CHAR(9),
edad tinyint
);

CREATE TABLE IF NOT EXISTS EXCURSION  (
Codigo_E char(5) PRIMARY KEY,
Nombre VARCHAR(50),
Fecha DATE NOT NULL,
H_inicio TIME,
H_fin TIME,
N_plazas TINYINT,
Ruta CHAR(3),
Empleado CHAR(9),

CONSTRAINT EX_RU_FK FOREIGN KEY (RUTA) REFERENCES  RUTA (CODIGO_R) ON DELETE SET NULL ON UPDATE CASCADE,
CONSTRAINT EX_EM_FK FOREIGN KEY (EMPLEADO) REFERENCES EMPLEADO (DNI) ON DELETE SET NULL ON UPDATE CASCADE

);


CREATE TABLE IF NOT EXISTS RESERVA  (
Excursion char(5),
Usuario char(5),
importe FLOAT(6,2),
Forma_pago enum ('tarjeta', 'contado', 'bizum'),

CONSTRAINT RE_PK PRIMARY KEY(EXCURSION, USUARIO),
CONSTRAINT RE_EX_FK FOREIGN KEY (EXCURSION) REFERENCES  EXCURSION (CODIGO_E) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT RE_US_FK FOREIGN KEY (USUARIO) REFERENCES USUARIO (CODIGO_U) ON DELETE CASCADE ON UPDATE CASCADE

);

/* INSERCCIÓN DE DATOS */

INSERT INTO EMPLEADO VALUES ('11111111Q','Luis', 'Ramírez Pardo', '1980-11-15', 1200);
INSERT INTO EMPLEADO VALUES ('22222222S','María', 'Sánchez Cid', '1975-10-20',  1000);
INSERT INTO EMPLEADO VALUES ('33333333M','Martín', 'Guerrero López','1990-07-22' ,1000);
INSERT INTO EMPLEADO VALUES ('04444444T','Úrsula', 'Delta Camacho', '1980-08-10', 900);
INSERT INTO EMPLEADO VALUES ('55555555J','Carmen', 'Hernández Pío','1977-06-05' , 1500);
INSERT INTO EMPLEADO VALUES ('77777777M','Pedro', 'Jiménez Ruiz','1981-05-12' , 1000);
INSERT INTO EMPLEADO VALUES ('99999999X','Raúl', 'Rodrigo Roca','1985-10-29', 1000);
INSERT INTO EMPLEADO VALUES ('88888888O','Soledad', 'Campillo Molina','1978-04-12' , 1200);
INSERT INTO EMPLEADO VALUES ('03232323P','María Luisa', 'Galdón Ter','1969-03-14', 1200);
INSERT INTO EMPLEADO VALUES ('14567555L','Piedad', 'Colmenero Zapillo','1991-10-15', 1200);
INSERT INTO EMPLEADO VALUES ('14111155T','Sergio', 'Lérida Campos','1992-12-17', 1000);
INSERT INTO EMPLEADO VALUES ('aaaaaaaaa','Sergio', 'Lérida Campos','1992-12-17', 1000);


INSERT INTO USUARIO VALUES ('U001', '14188151T','Carlos', 'Sánchez Ruíz', '600259874',25);
INSERT INTO USUARIO VALUES ('U002', '11245621Q','Juan', 'Pardo Rubio', '636254878',30);
INSERT INTO USUARIO VALUES('U003', '04477744T','Laura', 'Jiménez Jiménez', '625874596',14);
INSERT INTO USUARIO VALUES('U004','51235555J','Carmen', 'Capel Pío', '669584712',16);
INSERT INTO USUARIO VALUES('U005','55675675J','Juan', 'Sánchez López', '625845632',45);
INSERT INTO USUARIO VALUES('U006','99009900J','Alejandro', 'Pardo López', '636985621',62);
INSERT INTO USUARIO VALUES ('U007','24138151T','Vicente', 'Sánchez Pelayo', '61039874',42);
INSERT INTO USUARIO VALUES ('U008','21235421Q','Alfredo', 'Jiménez Rubio', '616856878',29);
INSERT INTO USUARIO VALUES ('U009','64574744T','María', 'Jiménez Costa', '623834596',16);
INSERT INTO USUARIO VALUES('U010','71234545J','Lucía', 'Sonora Vigo', '670684752',34);
INSERT INTO USUARIO VALUES('U011','65675454K','Alejandro', 'Sánchez Ocaña', '635845632',55);
INSERT INTO USUARIO VALUES('U012','34006800L','Javier', 'García Muñoz', '636535281',43);


INSERT INTO RECURSO VALUES ('001','Bicicleta',40);
INSERT INTO RECURSO VALUES ('002','Quad', 20);
INSERT INTO RECURSO VALUES ('003','Motoclicleta',30);
INSERT INTO RECURSO VALUES ('004','Patines', 45);
INSERT INTO RECURSO VALUES ('005','Piragua', 40);
INSERT INTO RECURSO VALUES ('006','Caballo', 20);
INSERT INTO RECURSO VALUES ('007','Esquies', 20);
INSERT INTO RECURSO VALUES ('008', 'Tablas de Snow', 20);
INSERT INTO RECURSO VALUES ('009', 'Snorkel',40); 
INSERT INTO RECURSO VALUES ('010', 'Arcos',30); 



INSERT INTO RUTA VALUES ('R01', 'Cabo de Gata', 'Senderismo por Cabo de Gata', 10, 'Fácil');
INSERT INTO RUTA VALUES ('R02', 'Arrecife de las Sirenas', 'Piraguismo por el Arrecife de las Sirenas', 20, 'Fácil');
INSERT INTO RUTA VALUES ('R03', 'Loma Reliblanca', 'Paseo en Quad por la Loma de la Reliblanca', 25, 'Difícil');
INSERT INTO RUTA VALUES ('R04', 'Sierra de Gádor', 'Paseo en Motocicleta por la Sierra de Gádor', 30, 'Extrema');
INSERT INTO RUTA VALUES ('R05', 'La Fabriquilla', 'Multiaventura por la Sierra de los Filabres', 35, 'Media');
INSERT INTO RUTA VALUES ('R06', 'Playa Mónsul', 'Paseo a caballo por la playa de Mónsul', 30, 'Media');
INSERT INTO RUTA VALUES ('R07', 'Desierto de Tabernas', 'Multiaventura por el desierto de Tabernas', 50, 'Media');
INSERT INTO RUTA VALUES ('R08', 'Sierra Nevada', 'Esquí alpino por Sierra Nevada', 80, 'Difícil');


INSERT INTO USA VALUES ('R02', '005', 20);
INSERT INTO USA VALUES ('R02', '009', 20);

INSERT INTO USA VALUES ('R03', '002', 10);

INSERT INTO USA VALUES ('R04', '003', 20);

INSERT INTO USA VALUES ('R05', '006', 20);
INSERT INTO USA VALUES ('R05', '001', 30);
INSERT INTO USA VALUES ('R05', '010', 20);

INSERT INTO USA VALUES ('R06', '006', 20);


INSERT INTO USA VALUES ('R07', '006', 20);
INSERT INTO USA VALUES ('R07', '002', 20);
INSERT INTO USA VALUES ('R07', '003', 20);

INSERT INTO USA VALUES ('R08', '007', 20);
INSERT INTO USA VALUES ('R08', '008', 20);


INSERT INTO EXCURSION VALUES ('EX001', 'Conociendo Cabo de Gata', '2020-09-20', '09:00', '14:00', 40, 'R01', '11111111Q');
INSERT INTO EXCURSION VALUES ('EX002', 'Cabo de Gata en primavera', '2020-04-10', '09:00', '14:00', 40, 'R01', '22222222S');
INSERT INTO EXCURSION VALUES ('EX003', 'Cabo de Gata en otoño', '2020-10-15', '09:00', '14:00', 40, 'R01', '22222222S');

INSERT INTO EXCURSION VALUES ('EX004', 'Explorando el Arrecife de las Sirenas', '2020-08-25', '08:00', '15:00', 30, 'R02', '11111111Q');

INSERT INTO EXCURSION VALUES ('EX005', 'Iniciación Quad Loma Reliblanca', '2020-05-20', '09:00', '15:00', 10, 'R03', '11111111Q');
INSERT INTO EXCURSION VALUES ('EX006', ' Explorando la Loma Reliblanca', '2020-03-12', '09:00', '15:00', 10, 'R03', '33333333M');

INSERT INTO EXCURSION VALUES ('EX007', 'Conociendo en moto la Sierra de Gádor', '2020-02-18', '08:00', '18:00', 10, 'R04', '33333333M');

INSERT INTO EXCURSION VALUES ('EX008', 'Multiaventura en La Fabriquilla', '2020-01-26', '09:00', '20:00', 30, 'R05', '04444444T');

INSERT INTO EXCURSION VALUES ('EX009', 'Paraiso Natural, Playa Monsul', '2020-08-15', '11:00', '17:00', 30, 'R06', '99999999X');


INSERT INTO EXCURSION VALUES ('EX010', 'Paraiso interior Desierto de Tabernas', '2020-06-05', '10:00', '16:00', 40, 'R07', '55555555J');

INSERT INTO EXCURSION VALUES ('EX011', 'Iniciación a la nieve', '2020-02-04', '08:00', '20:00', 30, 'R08', '77777777M');
INSERT INTO EXCURSION VALUES ('EX012', 'Explorando Sierra Nevada', '2020-01-12', '08:00', '20:00', 30, 'R08', '77777777M');


INSERT INTO RESERVA VALUES ('EX001', 'U001', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX001', 'U002', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX001', 'U005', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX001', 'U007', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX001', 'U008', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX001', 'U010', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX001', 'U011', 10, 'tarjeta');

INSERT INTO RESERVA VALUES ('EX002', 'U001', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX002', 'U003', 5, 'bizum');
INSERT INTO RESERVA VALUES ('EX002', 'U005', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX002', 'U007', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX002', 'U009', 5, 'bizum');
INSERT INTO RESERVA VALUES ('EX002', 'U010', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX002', 'U011', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX002', 'U002', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX002', 'U004', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX002', 'U006', 10, 'bizum');

INSERT INTO RESERVA VALUES ('EX003', 'U001', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX003', 'U002', 10, 'bizum');
INSERT INTO RESERVA VALUES ('EX003', 'U003', 5, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX003', 'U004', 5, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX003', 'U005', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX003', 'U006', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX003', 'U007', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX003', 'U008', 10, 'contado');
INSERT INTO RESERVA VALUES ('EX003', 'U009', 10, 'contado');

INSERT INTO RESERVA VALUES ('EX004', 'U001', 20, 'bizum');
INSERT INTO RESERVA VALUES ('EX004', 'U002', 20, 'bizum');
INSERT INTO RESERVA VALUES ('EX004', 'U003', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX004', 'U004', 10, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX004', 'U005', 20, 'contado');

INSERT INTO RESERVA VALUES ('EX005', 'U006', 25, 'contado');
INSERT INTO RESERVA VALUES ('EX005', 'U007', 25, 'contado');
INSERT INTO RESERVA VALUES ('EX005', 'U008', 25, 'bizum');
INSERT INTO RESERVA VALUES ('EX005', 'U009', 15, 'tarjeta');

INSERT INTO RESERVA VALUES ('EX006', 'U002', 25, 'contado');
INSERT INTO RESERVA VALUES ('EX006', 'U005', 25, 'bizum');
INSERT INTO RESERVA VALUES ('EX006', 'U008', 25, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX006', 'U010', 25, 'contado');

INSERT INTO RESERVA VALUES ('EX007', 'U002', 30, 'bizum');
INSERT INTO RESERVA VALUES ('EX007', 'U005', 30, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX007', 'U008', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX007', 'U010', 30, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX007', 'U012', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX007', 'U006', 30, 'bizum');


INSERT INTO RESERVA VALUES ('EX008', 'U008', 35, 'contado');
INSERT INTO RESERVA VALUES ('EX008', 'U010', 35, 'bizum');
INSERT INTO RESERVA VALUES ('EX008', 'U001', 35, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX008', 'U007', 35, 'bizum');
INSERT INTO RESERVA VALUES ('EX008', 'U003', 25, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX008', 'U005', 35, 'contado');
INSERT INTO RESERVA VALUES ('EX008', 'U004', 25, 'contado');


INSERT INTO RESERVA VALUES ('EX009', 'U001', 30, 'bizum');
INSERT INTO RESERVA VALUES ('EX009', 'U002', 30, 'bizum');
INSERT INTO RESERVA VALUES ('EX009', 'U003', 20, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX009', 'U004', 20, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX009', 'U005', 30, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX009', 'U006', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX009', 'U007', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX009', 'U008', 30, 'contado');
INSERT INTO RESERVA VALUES ('EX009', 'U009', 30, 'contado');

INSERT INTO RESERVA VALUES ('EX010', 'U008', 50, 'contado');
INSERT INTO RESERVA VALUES ('EX010', 'U010', 50, 'bizum');
INSERT INTO RESERVA VALUES ('EX010', 'U001', 50, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX010', 'U007', 50, 'bizum');
INSERT INTO RESERVA VALUES ('EX010', 'U003', 40, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX010', 'U005', 50, 'contado');
INSERT INTO RESERVA VALUES ('EX010', 'U004', 40, 'contado');

INSERT INTO RESERVA VALUES ('EX011', 'U001', 80, 'bizum');
INSERT INTO RESERVA VALUES ('EX011', 'U002', 80, 'contado');
INSERT INTO RESERVA VALUES ('EX011', 'U005', 80, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX011', 'U007', 80, 'bizum');
INSERT INTO RESERVA VALUES ('EX011', 'U008', 80, 'bizum');
INSERT INTO RESERVA VALUES ('EX011', 'U010', 80, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX011', 'U011', 80, 'tarjeta');


INSERT INTO RESERVA VALUES ('EX012', 'U001', 80, 'bizum');
INSERT INTO RESERVA VALUES ('EX012', 'U003', 60, 'bizum');
INSERT INTO RESERVA VALUES ('EX012', 'U005', 80, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX012', 'U007', 80, 'tarjeta');
INSERT INTO RESERVA VALUES ('EX012', 'U009', 60, 'bizum');
INSERT INTO RESERVA VALUES ('EX012', 'U010', 80, 'contado');
INSERT INTO RESERVA VALUES ('EX012', 'U011', 80, 'contado');
INSERT INTO RESERVA VALUES ('EX012', 'U002', 80, 'contado');
INSERT INTO RESERVA VALUES ('EX012', 'U004', 80, 'bizum');
INSERT INTO RESERVA VALUES ('EX012', 'U006', 80, 'bizum');

/* 1 */
SELECT * FROM ruta;

/* 2 */
SELECT codigo_e, nombre, empleado, n_plazas, fecha FROM excursion WHERE month(fecha) = 2 AND year(fecha) = 2020;

/* 3 */
SELECT * FROM empleado WHERE (datediff(curdate(), f_nac) / 360) >= 40 AND salario > 1100;

/* 4 */
SELECT nombre, descripcion FROM ruta WHERE tipo IN('media') AND precio > 30;

/* 5 */
SELECT u.nombre, apellidos FROM usuario u, excursion, reserva WHERE usuario = codigo_u AND excursion = codigo_e AND codigo_e = 'ex005';

/* 6 */
SELECT codigo, r.nombre, if(codigo = recurso, count(ruta), 'ninguna') FROM recurso r LEFT JOIN usa ON codigo = recurso GROUP BY recurso ORDER BY codigo;

/* 7 */
SELECT r.nombre, descripcion, count(codigo_e) FROM ruta r, excursion WHERE ruta =  codigo_r GROUP BY ruta;

/* 8 */
SELECT count(codigo_e), date_format(fecha, '%M del %Y') FROM excursion GROUP BY month(fecha) ORDER BY count(codigo_e) DESC;

/* 9 */
SELECT concat(codigo_r,' .',r.nombre) FROM ruta r WHERE tipo IN('media', 'dificil') AND precio > 25 ORDER BY Codigo_R;

/* 10 */
SELECT nombre, precio, descripcion FROM ruta where precio >= (SELECT avg(precio) FROM ruta);

/* 11 */
SELECT empleado.nombre, dni FROM empleado LEFT JOIN excursion ON dni = empleado WHERE empleado IS NULL;

/* 12 */
SELECT e.* FROM excursion e LEFT JOIN ruta ON codigo_r = ruta LEFT JOIN usa ON codigo_r = usa.ruta LEFT JOIN recurso ON recurso = codigo WHERE recurso.nombre ='caballo';

/* 13 */
SELECT empleado, time_format(avg(timediff(h_fin, h_inicio)), '%T') FROM excursion GROUP BY empleado;

/* 14 */
SELECT codigo_e, e.nombre, count(usuario), sum(importe) FROM excursion e LEFT JOIN reserva ON codigo_e = excursion GROUP BY Codigo_E;

/* 15 */
SELECT codigo_r, nombre, precio FROM ruta WHERE precio = (SELECT min(precio) FROM ruta) OR precio = (SELECT max(precio) FROM ruta);

/* 16 */
SELECT codigo_e, e.nombre, count(usuario) FROM excursion e LEFT JOIN reserva ON codigo_e = excursion LEFT JOIN ruta r ON ruta = codigo_r WHERE r.precio >= 20 GROUP BY excursion HAVING count(usuario) > 5;

/* 17 */
SELECT * FROM empleado LEFT JOIN excursion ON dni = empleado LEFT JOIN reserva ON codigo_e = excursion GROUP BY excursion HAVING count(usuario) > 8 ;

/* 18 */
SELECT codigo_u, u.nombre FROM usuario u LEFT JOIN reserva ON codigo_u = usuario LEFT JOIN excursion ON excursion = codigo_e LEFT JOIN ruta ON excursion.ruta = codigo_r LEFT JOIN usa ON usa.ruta = codigo_r LEFT JOIN recurso ON recurso = codigo WHERE recurso.nombre = 'quads'; 