CREATE SCHEMA IF NOT EXISTS TRANSPORTISTAS;
USE TRANSPORTISTAS;

CREATE TABLE IF NOT EXISTS Cliente (
Codigo		VARCHAR(4),
Nombre		VARCHAR(50) NOT NULL,
Telefono		VARCHAR(9) NOT NULL,
Tipo		ENUM('Particular','Empresa'),
Descuento	TINYINT UNSIGNED,
Direccion	VARCHAR(20),
Localidad	VARCHAR(20),
Provincia		VARCHAR(20),
CONSTRAINT cli_cod_PK PRIMARY KEY(Codigo));

CREATE TABLE IF NOT EXISTS Transportista (
Numero		VARCHAR(3),
Nombre		VARCHAR(30) NOT NULL,
Telefono		VARCHAR(9) NOT NULL,
Salario		FLOAT(6,2),
Fec_alta		DATE NOT NULL,
CONSTRAINT tra_num_PK PRIMARY KEY(Numero));

CREATE TABLE IF NOT EXISTS Destinatario (
DNI 		VARCHAR(10),
Nombre		VARCHAR(30) NOT NULL,
Apellido1	VARCHAR(30) NOT NULL,
Apellido2	VARCHAR(30),
Direccion	VARCHAR(20) NOT NULL, 
Localidad	VARCHAR(20) NOT NULL,
Provincia		VARCHAR(20) NOT NULL,
CONSTRAINT des_dni_PK PRIMARY KEY(DNI));

CREATE TABLE IF NOT EXISTS Paquete (
Referencia	VARCHAR(6),
Precio		FLOAT(6,2),
Peso		FLOAT(6,3),
Estado		ENUM('Almacenado','En Reparto','Entregado'),
Fec_Hora_salida 	DATETIME,
Fec_Hora_entrega	DATETIME,
cod_cli		VARCHAR(10),
DNI_des		VARCHAR(10),
Num_trans	VARCHAR(3),
CONSTRAINT paq_ref_PK PRIMARY KEY(Referencia),
CONSTRAINT paq_cli_FK FOREIGN KEY(cod_cli) REFERENCES Cliente(Codigo) ON DELETE CASCADE,
CONSTRAINT paq_des_FK FOREIGN KEY(DNI_des) REFERENCES Destinatario(DNI) ON DELETE CASCADE,
CONSTRAINT paq_num_FK FOREIGN KEY(Num_trans) REFERENCES Transportista(Numero) ON DELETE CASCADE);

/* DATOS PARA LAS TABLAS */

INSERT INTO Cliente VALUES ('111','Juan Pérez','950333222','Particular',0,'C/Gudalete,8','Sevilla','Sevilla');
INSERT INTO Cliente VALUES ('222','Luis Martínez Gómez','606606606','Particular',10,'C/Sierra,28','Bailén','Jaén');
INSERT INTO Cliente VALUES ('333','Imprenta Sur S.L.','950000001','Empresa',15,'C/Azores,101','Roquetas de Mar','Almería');
INSERT INTO Cliente VALUES ('444','Comercio eTextil','950111222','Empresa',15,'Avda. Alborán,114','Dos Hermanas','Sevilla');
INSERT INTO Cliente VALUES ('555','Sara Kraus','707707707','Particular',0,'C/Gran Vía, 99','Guadix','Granada');
INSERT INTO Cliente VALUES ('666','María Blanes López','666999333','Particular',3,'C/Isla,13','Aguadulce','Almería');

INSERT INTO Transportista VALUES ('101','Jorge Carrión','999000101',1200,'2011/10/21');
INSERT INTO Transportista VALUES ('102','Mateo Palas','999000102',1350.40,'2008/02/03');
INSERT INTO Transportista VALUES ('103','Carlos López','999000103',1400.50,'2002/10/13');

INSERT INTO Destinatario VALUES ('44189123K','Pedro','Jiménez','Marcos','C/Las Norias,33','Pinto','Madrid');
INSERT INTO Destinatario VALUES ('44111099F','María','Cano','Espada','C/Magnolia,5','Benidorm','Alicante');
INSERT INTO Destinatario VALUES ('22980234L','Juan','Laredo','Pontes','C/Luciérnagas,29','San José','Almería');
INSERT INTO Destinatario VALUES ('76209382M','Michael','Brown',NULL,'C/Gran Vía,402','Madrid','Madrid');
INSERT INTO Destinatario VALUES ('44009116S','Jesús','Solís','Estevan','C/Esperanza,8','Cieza','Murcia');
INSERT INTO Destinatario VALUES ('77998823L','Lucía','García','García','C/Merendero,10','Baza','Granada');
INSERT INTO Destinatario VALUES ('76222936F','John','Larry',NULL,'C/Buenaventura,99','Torremolinos','Málaga');
INSERT INTO Destinatario VALUES ('22009557L','Katy','Muller',NULL,'C/Las Palmas,2','Carboneras','Almería');

INSERT INTO Paquete VALUES ('XY0033',7*0.560,0.560,'Entregado','2015/12/18 17:22:00','2015/12/20 15:30:00', '222','44189123K','101');
INSERT INTO Paquete VALUES ('XY0034',7*0.225,0.225,'Entregado','2015/12/18 17:22:00','2015/12/20 15:30:00', '222','44189123K','101');
INSERT INTO Paquete VALUES ('KD0009',7*15.350,15.350,'Entregado','2015/12/21 10:30:00','2015/12/24 11:10:00', '333','44111099F','102');
INSERT INTO Paquete VALUES ('KD0010',7*3.140,3.140,'En Reparto','2015/12/21 10:30:00',NULL, '444','22980234L','103');
INSERT INTO Paquete VALUES ('KD0011',7*1.100,1.100,'En Reparto','2015/12/21 10:30:00',NULL, '444','76209382M','101');
INSERT INTO Paquete VALUES ('XY0099',7*0.225,0.225,'Almacenado',NULL,NULL, '111','44009116S',NULL);
INSERT INTO Paquete VALUES ('XY0100',7*0.445,0.445,'Entregado','2015/12/10 20:10:00','2015/12/11 15:30:00', '555','76222936F','103');
INSERT INTO Paquete VALUES ('XY0101',7*0.725,0.725,'En Reparto','2015/12/10 20:15:00',NULL, '111','44009116S','102');
INSERT INTO Paquete VALUES ('XY0102',7*2.225,2.225,'En Reparto','2015/12/10 20:20:00',NULL, '333','22009557L','103');
INSERT INTO Paquete VALUES ('KD0178',7*0.475,0.475,'En Reparto','2015/12/17 13:45:00',NULL, '555','76209382M','101');
INSERT INTO Paquete VALUES ('KD0179',7*0.125,0.125,'Almacenado',NULL,NULL, '666','77998823L',NULL);
INSERT INTO Paquete VALUES ('KD0080',7*0.525,0.525,'Entregado','2015/12/16 16:30:00','2015/12/20 12:25:00', '222','44189123K','101');
INSERT INTO Paquete VALUES ('KD0081',7*25.225,25.225,'Entregado','2015/12/18 17:22:00','2015/12/20 15:30:00', '222','44189123K','101');
INSERT INTO Paquete VALUES ('XY0056',7*0.560,0.560,'Entregado','2015/12/21 11:10:00','2015/12/22 18:40:00', '444','76209382M','102');
INSERT INTO Paquete VALUES ('XY0057',7*0.425,0.225,'En Reparto','2015/12/20 10:20:00',NULL, '222','76222936F','103');
INSERT INTO Paquete VALUES ('XY0058',7*0.225,0.225,'En Reparto','2015/12/20 10:20:00',NULL, '222','76222936F','103');

SELECT nombre, telefono, provincia FROM cliente;

SELECT * from destinatario WHERE provincia IN ('madrid');

SELECT nombre FROM transportista ORDER BY fec_alta ASC;

SELECT estado, count(referencia) FROM paquete GROUP BY estado;

SELECT max(peso), min(peso) FROM paquete;

SELECT num_trans, count(referencia) FROM paquete WHERE num_trans IS NOT NULL GROUP BY num_trans;

SELECT concat((SELECT sum(precio) FROM paquete),'$') 'precio';

SELECT referencia, timediff(fec_hora_entrega, fec_hora_salida) FROM paquete WHERE timediff(fec_hora_entrega, fec_hora_salida) IS NOT NULL ORDER BY timediff(fec_hora_entrega, fec_hora_salida);

SELECT referencia, ifnull(date_format(fec_hora_salida, '%d de %M del %Y'), "aun no ha salido")FROM paquete ORDER BY Fec_Hora_salida;

SELECT DISTINCT c.nombre, telefono FROM cliente c, paquete p WHERE c.codigo = cod_cli AND peso > 0.5;

SELECT numero, nombre, telefono, salario, year(curdate()) - year(fec_alta) 'antigüedad' FROM transportista ORDER BY year(curdate()) - year(fec_alta) DESC; 

SELECT DISTINCT codigo FROM cliente, destinatario d, paquete WHERE codigo = cod_cli AND DNI_des = DNI AND d.provincia NOT IN('almeria', 'alicante', 'murcia');

SELECT num_trans, avg(peso) FROM paquete WHERE estado IN('en reparto', 'entregado') GROUP BY num_trans ORDER BY avg(peso) DESC;

SELECT localidad, provincia FROM destinatario d, paquete p WHERE DNI = DNI_des GROUP BY localidad HAVING count(referencia) > 2;

SELECT referencia, provincia, t.nombre, t.telefono, datediff(curdate(), fec_hora_salida) FROM paquete, destinatario, transportista t WHERE Num_trans = numero AND dni_des = dni AND Fec_Hora_entrega IS NULL;

SELECT codigo, nombre, sum(precio) FROM cliente, paquete WHERE codigo = cod_cli GROUP BY codigo;

SELECT referencia FROM cliente, paquete, destinatario WHERE codigo = cod_cli AND dni = dni_des AND (cliente.Provincia = 'granada' OR destinatario.Provincia = 'granada');

SELECT c.nombre, concat(d.nombre," ",d.apellido1," ",d.apellido2) "nombre destinatario", fec_hora_salida FROM cliente c, destinatario d, paquete WHERE codigo = cod_cli AND dni = dni_des;

SELECT  c.provincia, c.nombre, d.nombre, t.nombre, referencia, peso FROM cliente c, paquete, transportista t, destinatario d WHERE codigo = cod_cli AND dni = dni_des AND c.provincia = d.Provincia AND num_trans = numero;

SELECT nombre, telefono FROM cliente, paquete WHERE codigo = cod_cli AND count(referencia) = (SELECT max(count(Referencia)) FROM paquete, cliente WHERE codigo = cod_cli GROUP BY codigo);