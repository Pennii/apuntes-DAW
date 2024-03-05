CREATE DATABASE PEDIDOS;
USE PEDIDOS;

CREATE TABLE CLIENTE(
cod_cli char(3) PRIMARY KEY,
nombre varchar(20),
apellidos varchar(40),
domicilio varchar(40),
cod_postal char(5),
localidad varchar(40),
telefono char(9),
tipo_cli enum('Oro','Plata','Bronce'),
bono_canjeable smallint unsigned) ;

CREATE TABLE PEDIDO(
num_ped CHAR(6) PRIMARY KEY,
fecha_ped DATE,
hora_ped TIME,
hora_servir TIME,
hora_entrega TIME,
cliente CHAR(3),
CONSTRAINT ped_cli_FK FOREIGN KEY (cliente) REFERENCES cliente(cod_cli) ON DELETE SET NULL) ;

CREATE TABLE PLATO (
cod_plato CHAR(4) PRIMARY KEY,
nombre VARCHAR(40),
precio FLOAT,
stock TINYINT UNSIGNED
);

CREATE TABLE DETALLE_PEDIDO (
num_pedido CHAR(6),
num_linea CHAR(2),
cantidad TINYINT UNSIGNED,
plato CHAR(4),
CONSTRAINT det_ped_PK PRIMARY KEY (num_pedido, num_linea),
CONSTRAINT det_ped_FK FOREIGN KEY (num_pedido) REFERENCES PEDIDO(num_ped) ON DELETE CASCADE,
CONSTRAINT det_pla_FK FOREIGN KEY (plato) REFERENCES PLATO(cod_plato) ON DELETE CASCADE) ;

/* VALORES EN TABLA CLIENTE*/
INSERT INTO CLIENTE VALUES ('101','Luis','Ram�rez Pardo','C/Piedra,48','04720','Aguadulce','950998877','Plata',10);
INSERT INTO CLIENTE VALUES ('102','Mar�a','S�nchez Cid','C/Lourdes,8','04720','Aguadulce','678234109','Bronce',0);
INSERT INTO CLIENTE VALUES ('103','Mart�n','Guerrero L�pez','C/Plut�n,2','04740','Roquetas de Mar','666099009','Bronce',0);
INSERT INTO CLIENTE VALUES ('104','�rsula','Delta Camacho','C/Singular,109','04740','Roquetas de Mar','600156887','Bronce',0);
INSERT INTO CLIENTE VALUES ('105','Carmen','Hern�ndez P�o','C/Sol Naciente,29','04720','Aguadulce','697111222','Oro',30);
INSERT INTO CLIENTE VALUES ('106','Pedro','Jim�nez Ruiz','C/Estanislao,9','04621','Las Marinas','950009988','Bronce',0);
INSERT INTO CLIENTE VALUES ('107','Ra�l','Rodrigo Roca','C/Salvatore,1','04621','Las Marinas','600900800','Plata',10);
INSERT INTO CLIENTE VALUES ('108','Soledad','Campillo Molina','C/Paraiso,33','04720','Aguadulce','950885522','Bronce',0);
INSERT INTO CLIENTE VALUES ('109','Javier','Mart�nez Real','C/Paraiso,35','04720','Almer�a','950885522','Oro',0);

/* VALORES EN TABLA PEDIDO */
INSERT INTO PEDIDO VALUES ('100101','2018/09/21','10:00:00','14:30:00','14:35:00', '101');
INSERT INTO PEDIDO VALUES ('100102','2018/09/21','10:15:00','14:00:00','13:58:00', '102');
INSERT INTO PEDIDO VALUES ('100103','2018/09/21','10:30:00','14:45:00','14:47:00', '103');
INSERT INTO PEDIDO VALUES ('100104','2018/09/21','10:44:00','14:30:00','14:40:00', '105');
INSERT INTO PEDIDO VALUES ('100105','2018/09/21','10:56:00','14:00:00','14:08:00', '108');
INSERT INTO PEDIDO VALUES ('100106','2018/09/22','11:08:00','14:15:00','14:20:00', '104');
INSERT INTO PEDIDO VALUES ('100107','2018/09/22','10:55:00','14:15:00','14:08:00', '101');
INSERT INTO PEDIDO VALUES ('100108','2018/09/22','11:56:00','13:45:00','14:01:00', '107');
INSERT INTO PEDIDO VALUES ('100109','2018/10/05','11:56:00','14:45:00','14:48:00', '104');
INSERT INTO PEDIDO VALUES ('100110','2018/10/05','10:05:00','14:00:00','14:05:00', '102');
INSERT INTO PEDIDO VALUES ('100111','2018/10/05','11:34:00','14:30:00','14:38:00', '106');
INSERT INTO PEDIDO VALUES ('100112','2018/10/05','12:25:00','14:15:00','14:20:00', '105');
INSERT INTO PEDIDO VALUES ('100113','2018/10/05','09:45:00','13:45:00','13:56:00', '107');

/* VALORES EN TABLA PLATO */
INSERT INTO PLATO VALUES ('001','Pollo asado',7.75,20);
INSERT INTO PLATO VALUES ('002','Espaguettis Carbonara',4.25,15);
INSERT INTO PLATO VALUES ('003','Ensaladilla Rusa',3.85,5);
INSERT INTO PLATO VALUES ('004','Patatas fritas',3.00,30);
INSERT INTO PLATO VALUES ('005','Lasa�a Carne',8.50,17);
INSERT INTO PLATO VALUES ('006','Calamares fritos',5.75,15);
INSERT INTO PLATO VALUES ('007','Caldo de pollo',3.75,40);
INSERT INTO PLATO VALUES ('008','Natillas chocolate',2.25,25);
INSERT INTO PLATO VALUES ('009','Alioli',1.50,20);
INSERT INTO PLATO VALUES ('010','Paella',8.25,30);
INSERT INTO PLATO VALUES ('011','Fideu�',7.50,15);
INSERT INTO PLATO VALUES ('012','Pastel de queso',2.50,15);
INSERT INTO PLATO VALUES ('013','Lentejas',4.15,35);
INSERT INTO PLATO VALUES ('014','Solomillo a la pimienta',8.75,12);
INSERT INTO PLATO VALUES ('015','Bacalao con tomate',7.50,16);
INSERT INTO PLATO VALUES ('016','Berenjenas rebozadas',2.30,10);

/* VALORES EN TABLA DETALLE_PEDIDO */
INSERT INTO DETALLE_PEDIDO VALUES ('100101','1',2,'001');
INSERT INTO DETALLE_PEDIDO VALUES ('100101','2',3,'004');
INSERT INTO DETALLE_PEDIDO VALUES ('100101','3',1,'009');

INSERT INTO DETALLE_PEDIDO VALUES ('100102','1',1,'003');
INSERT INTO DETALLE_PEDIDO VALUES ('100102','2',1,'005');
INSERT INTO DETALLE_PEDIDO VALUES ('100102','3',2,'012');
INSERT INTO DETALLE_PEDIDO VALUES ('100102','4',1,'010');

INSERT INTO DETALLE_PEDIDO VALUES ('100103','1',4,'014');
INSERT INTO DETALLE_PEDIDO VALUES ('100103','2',3,'011');
INSERT INTO DETALLE_PEDIDO VALUES ('100103','3',7,'008');

INSERT INTO DETALLE_PEDIDO VALUES ('100104','1',1,'007');

INSERT INTO DETALLE_PEDIDO VALUES ('100105','1',1,'005');
INSERT INTO DETALLE_PEDIDO VALUES ('100105','2',1,'007');
INSERT INTO DETALLE_PEDIDO VALUES ('100105','3',1,'012');

INSERT INTO DETALLE_PEDIDO VALUES ('100106','1',2,'015');
INSERT INTO DETALLE_PEDIDO VALUES ('100106','2',1,'010');

INSERT INTO DETALLE_PEDIDO VALUES ('100107','1',2,'002');
INSERT INTO DETALLE_PEDIDO VALUES ('100107','2',1,'006');
INSERT INTO DETALLE_PEDIDO VALUES ('100107','3',3,'008');

INSERT INTO DETALLE_PEDIDO VALUES ('100108','1',1,'013');
INSERT INTO DETALLE_PEDIDO VALUES ('100108','2',1,'007');
INSERT INTO DETALLE_PEDIDO VALUES ('100108','3',2,'010');

INSERT INTO DETALLE_PEDIDO VALUES ('100109','1',1,'001');
INSERT INTO DETALLE_PEDIDO VALUES ('100109','2',1,'004');
INSERT INTO DETALLE_PEDIDO VALUES ('100109','3',1,'009');
INSERT INTO DETALLE_PEDIDO VALUES ('100109','4',3,'008');

INSERT INTO DETALLE_PEDIDO VALUES ('100110','1',4,'015');

INSERT INTO DETALLE_PEDIDO VALUES ('100111','1',1,'003');
INSERT INTO DETALLE_PEDIDO VALUES ('100111','2',1,'004');

INSERT INTO DETALLE_PEDIDO VALUES ('100112','1',1,'001');
INSERT INTO DETALLE_PEDIDO VALUES ('100112','2',2,'012');
INSERT INTO DETALLE_PEDIDO VALUES ('100112','3',2,'008');

INSERT INTO DETALLE_PEDIDO VALUES ('100113','1',1,'014');
INSERT INTO DETALLE_PEDIDO VALUES ('100113','2',1,'011');
INSERT INTO DETALLE_PEDIDO VALUES ('100113','3',1,'005');