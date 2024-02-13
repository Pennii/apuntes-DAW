CREATE SCHEMA IF NOT EXISTS COMERCIALES;
USE COMERCIALES;


create table if not exists Oficinas (
	codigo		char(3) primary key,
	direccion	varchar(50) not null,
	localidad	varchar(50) not null,
	provincia	varchar(20)
);
create table if not exists Vehiculos (
	matricula	char(7) primary key,
	marca		varchar(20) not null,
	modelo		varchar(20),
	nKilometros	integer(8) not null,
	fRevision	date
);


create table if not exists Comerciales (
	codigo		char(3) primary key,
	nombre		varchar(30) not null,
	salario		float(6,2) not null,
	hijos		integer(2) not null,
	fNacimiento	date not null,
	codOficina	char(3),
	vehiculoAsig char(7),
    constraint com_ofi_fk foreign key (codOficina) references Oficinas(codigo) on delete set null,
    constraint com_veh_fk foreign key (vehiculoAsig) references Vehiculos(matricula) on delete set null    
);

create table if not exists Productos (
	referencia		char(6) primary key,
	nombre		varchar(20) not null,
	descripcion	text(1000),
	precio		float(6,2) not null,
	descuento		float(2,0) not null
);

create table if not exists Vender (
	codComercial char(3),
	refProducto	 char(6),
	cantidad	 integer(6),
	fecha		 date,
	primary key (codComercial, refProducto, fecha),
	foreign key (codComercial) references Comerciales(codigo) on delete restrict,
	foreign key (refProducto) references Productos(referencia) on delete restrict
);

insert into Oficinas values ('101','Avda. Carlos III, 23' ,'Aguadulce','Almería');
insert into Oficinas values ('202','Avda Servero Ochoa, 33' ,'Marbella','Málaga');
insert into Oficinas values ('303','Avda. de Arcos, 43' ,'Jerez de la Frontera','Cádiz');
insert into Oficinas values ('404','Avda. de Lisboa, 53' ,'Andújar','Jaén');

insert into Vehiculos values ('0101BCD', 'Peugeot', '206', 110022, '2011/12/24');
insert into Vehiculos values ('0202CBD', 'Opel', 'Corsa', 80999, '2011/12/12');
insert into Vehiculos values ('0303DFD', 'Toyota', 'Auris', 101200, '2010/02/01');
insert into Vehiculos values ('0404FDF', 'Toyota', 'Corolla', 58230, '2011/11/20');
insert into Vehiculos values ('0505GHG', 'Renault', 'Laguna', 12234, '2012/12/04');
insert into Vehiculos values ('0606DFD', 'Renault', 'Clio', 148023, '2010/12/01');
insert into Vehiculos values ('0707BDF', 'Renault', 'Clio', 133012, '2010/10/15');
insert into Vehiculos values ('0808GGH', 'Seat', 'Ibiza', 45023, '2011/10/13');
insert into Vehiculos values ('0909DDL', 'Seat', 'Leon', 99283, '2010/03/20');

insert into Comerciales values ('111','Pedro Alonso Jiménez',1200.50,0,'1960/02/01','101','0101BCD');
insert into Comerciales values ('222','Julia Pérez Arribas',1305.75,1,'1971/12/11','101','0202CBD');
insert into Comerciales values ('333','Juan Lozano Gómez',1080.25,3,'1975/08/21','202','0303DFD');
insert into Comerciales values ('444','Sandra Molina Sánchez',1120.00,2,'1969/05/09','303','0404FDF');
insert into Comerciales values ('555','Salvador Beltrán Jiménez',975.50,0,'1980/10/11','303','0505GHG');
insert into Comerciales values ('666','Beatriz Martín Gutiérrez',1175.00,1,'1970/11/06','404','0606DFD');
insert into Comerciales values ('777','Eduardo Martínez Puig',1100.50,2,'1967/01/16','101','0707BDF');
insert into Comerciales values ('888','Juan Antonio Ochando Serrano',1000.50,0,'1982/03/03','202','0808GGH');
insert into Comerciales values ('999','Marina Pérez Blanco',1070.20,3,'1972/07/21','303','0909DDL');


insert into Productos values ('AC0001', 'Abrigo Caballero', 'Piel Color Marrón',  120.50, 15);
insert into Productos values ('AS0001', 'Abrigo Señora', 'Piel Color Marrón',  110.75, 25);
insert into Productos values ('CC0001', 'Camisa Caballero', 'Cuadros',  35.99, 10);
insert into Productos values ('PC0001', 'Pantalón Caballero', 'Vaquero',  34.90, 35);
insert into Productos values ('PC0002', 'Pantalón Caballero', 'Pana',  25.90, 0);
insert into Productos values ('AC0002', 'Abrigo Caballero', 'Piel Color Negro',  120.50, 15);
insert into Productos values ('CC0002', 'Camisa Caballero', 'Lisa Color Blanco',  35.99, 10);
insert into Productos values ('CC0003', 'Camisa Caballero', 'Lisa Color Azul',  35.99, 10);
insert into Productos values ('AS0002', 'Abrigo Señora', 'Piel Color Negro',  120.75, 15);
insert into Productos values ('AS0003', 'Abrigo Señora', 'Ante  Color Marrón',  90.95, 35);
insert into Productos values ('PS0001', 'Pantalón Señora', 'Vaquero',  30.90, 30);
insert into Productos values ('PS0002', 'Pantalón Señora', 'Lino',  39.90, 40);


insert into Vender values ('111','PC0001',24,'2011/10/10');
insert into Vender values ('111','PC0002',48,'2011/03/22');
insert into Vender values ('111','CC0001',20,'2011/09/01');
insert into Vender values ('111','AS0001',12,'2011/10/03');
insert into Vender values ('222','AS0001',34,'2011/01/22');
insert into Vender values ('222','AC0001',60,'2011/09/06');
insert into Vender values ('222','AS0002',21,'2011/11/10');
insert into Vender values ('333','AC0001',15,'2011/02/18');
insert into Vender values ('333','AC0002',80,'2011/02/09');
insert into Vender values ('333','AC0002',12,'2011/02/23');
insert into Vender values ('333','CC0003',45,'2011/06/17');
insert into Vender values ('333','CC0003',10,'2011/06/09');
insert into Vender values ('444','CC0001',75,'2011/06/08');
insert into Vender values ('444','PC0001',60,'2011/01/19');
insert into Vender values ('555','PC0002',35,'2011/02/02');
insert into Vender values ('555','PS0001',23,'2011/02/28');
insert into Vender values ('555','CC0002',67,'2011/05/25');
insert into Vender values ('666','CC0002',21,'2011/05/11');
insert into Vender values ('666','AS0003',23,'2011/04/16');
insert into Vender values ('666','CC0001',33,'2011/04/18');
insert into Vender values ('666','CC0001',50,'2011/03/11');
insert into Vender values ('666','CC0002',78,'2011/03/02');
insert into Vender values ('777','AC0002',39,'2011/03/07');
insert into Vender values ('777','AS0003',18,'2011/05/11');
insert into Vender values ('888','AS0002',55,'2011/03/19');
insert into Vender values ('888','PC0001',78,'2011/06/20');
insert into Vender values ('888','PS0002',33,'2011/04/10');
insert into Vender values ('888','PC0002',76,'2011/02/01');
insert into Vender values ('888','CC0003',50,'2011/01/30');
insert into Vender values ('999','AS0003',60,'2011/01/30');
insert into Vender values ('999','AC0002',47,'2011/03/31');
insert into Vender values ('999','PC0001',80,'2011/03/22');

SELECT codigo, localidad FROM oficinas;

SELECT nombre, fNacimiento FROM comerciales WHERE hijos >= 1;

SELECT nombre, descripcion FROM productos where precio < 50;

SELECT * FROM vehiculos ORDER BY nkilometros DESC;

SELECT referencia, nombre, descripcion FROM productos WHERE descuento NOT IN(0, 10, 15) ORDER BY referencia;

SELECT nombre FROM comerciales WHERE salario >= 1100 AND hijos > 0 ORDER BY nombre ASC;

SELECT nombre, descripcion FROM productos WHERE referencia LIKE "CC%" AND descripcion LIKE "%color%";

SELECT count(referencia) "numero de productos" FROM productos;

SELECT nombre, salario, salario + salario * 0.20 "Salario calculado" FROM comerciales WHERE codigo IN('111', '333', '777');

SELECT nombre, descripcion, round((precio - precio * descuento / 100), 2) "precio calculado" FROM productos ORDER BY precio ASC;

SELECT marca, count(matricula) FROM vehiculos WHERE nkilometros > 100000 GROUP BY marca;

SELECT hijos, max(salario) "salario maximo", min(salario) "salario minimo", avg(salario) "media salario" FROM comerciales GROUP BY hijos ORDER BY hijos ASC;

SELECT c.nombre, direccion, localidad FROM comerciales c, oficinas o WHERE codOficina = o.codigo AND fnacimiento > "1971-01-01" ORDER BY provincia ASC;

SELECT codigo, nombre, sum(cantidad) FROM comerciales, vender WHERE codigo = codcomercial GROUP BY codigo HAVING sum(cantidad) BETWEEN 125 AND 175 ORDER BY NOMBRE;

SELECT nombre, v.matricula FROM comerciales c, vehiculos v WHERE c.vehiculoasig = v.matricula AND year(curdate()) - year(frevision) >= 6;

SELECT c.nombre, max(precio), min(precio) FROM comerciales c, productos p, vender WHERE c.codigo = codcomercial AND referencia = refproducto GROUP BY codigo having max(precio) - min(precio) > 50;

SELECT nombre, date_format(fecha, '%d de %M del %Y')  FROM comerciales, vender WHERE codigo = codcomercial AND fecha BETWEEN '2011-01-01' AND '2011-04-01';

SELECT nombre, salario FROM comerciales WHERE salario IN((SELECT max(salario) FROM comerciales), (SELECT min(salario) FROM comerciales));

SELECT nombre, sum(cantidad) FROM comerciales, vender WHERE codigo = codcomercial AND fnacimiento IN(SELECT max(fnacimiento) FROM comerciales) GROUP BY codigo;

SELECT c.nombre, sum(precio*cantidad) FROM comerciales c, productos, oficinas o, vender WHERE codOficina = o.codigo AND codComercial = c.codigo AND referencia = refProducto AND codOficina IN (SELECT codOficina FROM comerciales GROUP BY codOficina having count(c.codigo) > 1) GROUP BY c.codigo ORDER BY sum(precio*cantidad) DESC;