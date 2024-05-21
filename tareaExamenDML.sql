/*1. Inserta un nuevo paciente con NSeguridadSocial='156487569', DNI='26485695K', 
Nombre= 'Juan', Apellidos= 'López Alcántara, Fec_nac='28/10/1986' y Sexo='v'. Crea 
otra sentencia que almacene en la tabla  CONSULTAS una consulta para este nuevo 
paciente con el médico con N_colegiado='1586865' para el 10/05/2023 con un importe 
de 50 euros (0,3p)*/
INSERT INTO PACIENTE VALUES("156487569","26485695K","Juan","Lopez Alcantara","M","1986/10/28",null);
INSERT INTO CONSULTAS VALUES("1586865", "156487569", "2023/05/10", 50);

/*2. Incrementar en 10 euros el importe de las consultas que estén por debajo de la media 
de los importes de todas las consultas. (0,5p)*/
UPDATE CONSULTAS SET IMPORTE = IMPORTE + 10 WHERE IMPORTE < 
	(SELECT AVG(IMPORTE) FROM (SELECT * FROM CONSULTAS) AS CONS); 

/*3. Realiza un descuento de 20 euros en el importe de todas las consultas de los pacientes 
de Madrid que hayan asistido a consulta más de 10 veces.  (0,6p) */
UPDATE CONSULTAS SET IMPORTE = IMPORTE - 20 WHERE PACIENTE IN 
	(SELECT PACIENTE FROM MEDICO, CONSULTAS, CLINICA WHERE CLINICA = CODIGO AND LOCALIDAD = 'MADRID' GROUP BY PACIENTE 
		HAVING COUNT(*) > 10);

/*4. Bloquea la tabla CONSULTAS en modo lectura seguidamente actualiza el importe de 
las 
consultas realizadas por médicos de la especialidad de 'Traumatología' 
incrementándolas en un 10%. (0,5p)*/
LOCK TABLE CONSULTAS READ;
UPDATE CONSULTAS SET IMPORTE = IMPORTE * 1.1 WHERE MEDICO IN 
	(SELECT N_COLEGIADO FROM MEDICO WHERE ESPECIALIDAD = 'TRAUMATOLOGÍA');
UNLOCK TABLES;

/*5. Inicia una transacción. Elimina todos los pacientes que lleven más de 2 años sin 
asistir a consulta médica.  Deshacer la transacción. (0,6p)*/
START TRANSACTION;
DELETE FROM PACIENTE WHERE NSS NOT IN
	(SELECT PACIENTE FROM CONSULTAS WHERE DATEDIFF(CURDATE(), FECHA_CONSULTA)/365 <= 2);
ROLLBACK;