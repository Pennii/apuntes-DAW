CREATE DATABASE CONSTRUCTORA;
USE CONSTRUCTORA;

CREATE TABLE hotel(
	codHotel int PRIMARY KEY,
    direccion VARCHAR(60),
    tipo VARCHAR(60),
    nivelCalidad int,
    categoria int);

CREATE TABLE empleado(
	codEmpleado int PRIMARY KEY,
    nombre VARCHAR(60),
    pagoXHora float,
    profesion VARCHAR(60),
    codEmpleadoSupervisor int,
    CONSTRAINT sup_fk FOREIGN KEY (codEmpleadoSupervisor) REFERENCES empleado(codEmpleado) ON DELETE SET NULL ON UPDATE CASCADE);

CREATE TABLE asignacion(
	codEmpleado int,
    codHotel int,
    fechaInicio DATE,
    numDias int,
    CONSTRAINT asig_pk PRIMARY KEY (codEmpleado, codHotel),
    CONSTRAINT asig_hot_fk FOREIGN KEY (codHotel) REFERENCES hotel(codHotel) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT asig_emp_fk FOREIGN KEY (codEmpleado) REFERENCES empleado(codEmpleado) ON DELETE CASCADE ON UPDATE CASCADE);
    
INSERT INTO Hotel(CodHotel, Direccion, Tipo, NivelCalidad, Categoria) VALUES (111, 'JR. 
LIMA # 120', 'TURISTAS', 4, 1); 
INSERT INTO Hotel(CodHotel, Direccion, Tipo, NivelCalidad, Categoria) VALUES (210, 'JR. 
JIMENEZ PIMENTEL # 340', 'TURISTAS', 3, 1); 
INSERT INTO Hotel(CodHotel, Direccion, Tipo, NivelCalidad, Categoria) VALUES (312, 'JR. 
AUGUSTO B. LEGUIA # 780', 'TURISTAS', 2, 2); 
INSERT INTO Hotel(CodHotel, Direccion, Tipo, NivelCalidad, Categoria) VALUES (435, 'JR. 
MAYNAS # 560', 'RESIDENCIAL', 1, 1); 
INSERT INTO Hotel(CodHotel, Direccion, Tipo, NivelCalidad, Categoria) VALUES (460, 'JR. 
ORELLANA # 450', 'ECOLOGICO', 3, 3); 
INSERT INTO Hotel(CodHotel, Direccion, Tipo, NivelCalidad, Categoria) VALUES (515, 'JR. 
AUGUSTO B. LEGUIA # 386', 'FAMILIAR', 3, 2); 
INSERT INTO Empleado(CodEmpleado, Nombre, PagoXHora, Profesion,
CodEmpleadoSupervisor) VALUES (3231, 'O.ANGULO', 17.40 , 'CARPINTERO', 3231); 
INSERT INTO Empleado(CodEmpleado, Nombre, PagoXHora, Profesion,
CodEmpleadoSupervisor) VALUES (1311, 'E.PEREZ', 15.50 , 'ELECTRONICO', 1311); 
INSERT INTO Empleado(CodEmpleado, Nombre, PagoXHora, Profesion,
CodEmpleadoSupervisor) VALUES (1520, 'D.BARRIA', 11.75 , 'FONTANERO', 1520); 
INSERT INTO Empleado(CodEmpleado, Nombre, PagoXHora, Profesion,
CodEmpleadoSupervisor) VALUES (2920, 'S.SABOYA', 10.00 , 'ALBAÑIL', 2920); 
INSERT INTO Empleado(CodEmpleado, Nombre, PagoXHora, Profesion,
CodEmpleadoSupervisor) VALUES (1235, 'A.CELIS', 12.50 , 'ELECTRONICO', 1311); 
INSERT INTO Empleado(CodEmpleado, Nombre, PagoXHora, Profesion,
CodEmpleadoSupervisor) VALUES (1412, 'C.ROJAS', 13.75 , 'FONTANERO', 1520); 
INSERT INTO Empleado(CodEmpleado, Nombre, PagoXHora, Profesion,
CodEmpleadoSupervisor) VALUES (3001, 'J.RAMIREZ', 8.20 , 'CARPINTERO', 3231); 
INSERT INTO Empleado(CodEmpleado, Nombre, PagoXHora, Profesion,
CodEmpleadoSupervisor) VALUES (4001, 'J.PEREZ', 10.20 , 'ALBAÑIL', 2920);
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1235, 312,'2013-10-10', 5); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1235, 515,'2013-10-17', 22); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1311, 435,'2013-10-08', 12); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1311, 460,'2013-10-23', 24); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1412, 111,'2013-12-01', 4); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1412, 210,'2013-11-15', 12); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1412, 312,'2013-10-10', 10); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1412, 435,'2013-10-15', 15); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1412, 460,'2013-10-08', 18); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1412, 515,'2013-11-05', 8); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1520, 312,'2013-10-30', 17); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(1520, 515,'2013-10-09', 14); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(2920, 210,'2013-11-10', 15); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(2920, 435,'2013-10-28', 10); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(2920, 460,'2013-10-05', 18); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(3001, 111,'2013-10-08', 14); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(3001, 210,'2013-10-27', 14); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(3231, 111,'2013-10-10', 8); 
INSERT INTO Asignacion(CodEmpleado, CodHotel, FechaInicio, NumDias) VALUES 
(3231, 312,'2013-10-24', 20);

-- 1
SELECT nombre FROM empleado WHERE pagoXHora BETWEEN 10 AND 12;

-- 2
SELECT profesion, count(*) FROM empleado e INNER JOIN asignacion a ON a.codEmpleado = e.codEmpleado WHERE codHotel = 435 GROUP BY profesion;

-- 3 
SELECT e.nombre, s.nombre FROM empleado e LEFT JOIN empleado s ON e.codEmpleadoSupervisor = s.codEmpleado;

-- 4
SELECT nombre, a.codHotel FROM empleado e INNER JOIN asignacion a ON a.codEmpleado = e.codEmpleado INNER JOIN hotel h ON h.codHotel = a.codHotel WHERE tipo = "turistas"; 

-- 5
SELECT e.codEmpleado, e.nombre, e.pagoXHora, s.codEmpleado as supervisor, s.pagoXHora FROM empleado e INNER JOIN empleado s ON e.codEmpleadoSupervisor = s.codEmpleado WHERE e.pagoXHora > s.pagoXHora;

-- 6
SELECT sum(numDias) FROM asignacion a INNER JOIN empleado e ON a.codEmpleado = e.codEmpleado INNER JOIN hotel h ON a.codHotel = h.codHotel WHERE profesion = "fontanero" AND h.codHotel = 312;

-- 7
SELECT codEmpleadoSupervisor, codEmpleado, pagoXHora FROM empleado WHERE pagoXHora IN (SELECT max(pagoXHora) FROM empleado GROUP BY codEmpleado) GROUP BY codEmpleadoSupervisor;

-- 8
SELECT round(avg(nivelCalidad)) FROM hotel WHERE categoria = 1 group by tipo;

-- 9
SELECT codEmpleado, pagoXHora FROM empleado WHERE pagoXHora < (SELECT avg(pagoXHora) FROM empleado);

-- 10
SELECT nombre, fechaInicio FROM empleado e INNER JOIN asignacion a ON a.codEmpleado = e.codEmpleado WHERE codHotel = 435 AND profesion = "electronico";


-- 1
INSERT INTO hotel VALUES(620, "TORREZ BERMUDEZ#180", "Familiar", 2, 3);

-- 2
UPDATE empleado SET pagoXHora = pagoXHora + 2 WHERE codEmpleado IN (SELECT a.codEmpleado FROM (SELECT * FROM empleado) as e INNER JOIN asignacion a ON a.codEmpleado = e.codEmpleado INNER JOIN hotel h ON h.codHotel = a.codHotel WHERE tipo = "turistas");

-- 3
Start transaction;
rollback;
UPDATE hotel SET nivelCalidad = nivelCalidad + 1 WHERE codHotel IN(SELECT codHotel FROM asignacion GROUP BY codHotel HAVING sum(numDias * 8) > 50);

-- 4
START TRANSACTION;
DELETE FROM empleado where codEmpleado NOT IN(select codEmpleado FROM asignacion);
rollback;

-- 5
START TRANSACTION;
UPDATE empleado SET pagoXHora = pagoXhora * 1.05 WHERE codEmpleadoSupervisor = (SELECT codEmpleado FROM (SELECT * FROM empleado) AS EMP WHERE nombre = "e.perez");
ROLLBACK;

-- 6
CREATE TABLE pagos_empleados(
	codEmpleado int primary key,
    nombre varchar(60),
    diasTrabajo int,
    totalGanado double);
INSERT INTO pagos_empleados SELECT e.codEmpleado, nombre, sum(numdias), sum(numDias)*pagoXHora*8 FROM empleado e, asignacion a WHERE e.codEmpleado = a.codEmpleado GROUP BY e.codEmpleado;
    
-- 8
START TRANSACTION;
UPDATE empleado SET pagoXHora = pagoXHora * 1.1 WHERE codEmpleado = (SELECT codEmpleado FROM asignacion GROUP BY codEmpleado ORDER BY count(*) DESC LIMIT 1);
ROLLBACK;

-- 9
start transaction;
DELETE FROM empleado WHERE nombre = "a.celis";
ROLLBACK;

-- 10
LOCK TABLE hotel READ;
UPDATE hotel SET codHotel = 3 WHERE codHotel = 312;
UNLOCK TABLES;