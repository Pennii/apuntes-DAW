CREATE DATABASE RESERVA_VIVIENDAS;

CREATE TABLE propietario(
DNI CHAR(9) PRIMARY KEY,
nombre VARCHAR(20),
apellido VARCHAR(20),
numCuenta CHAR(16) UNIQUE,
beneficio FLOAT);

CREATE TABLE mantenimiento(
CIF CHAR(9) PRIMARY KEY,
nombre VARCHAR(20),
responsable VARCHAR(20),
numEmpleados SMALLINT,
razonSocial VARCHAR(30));

CREATE TABLE cliente(
DNI CHAR(9) PRIMARY KEY,
nombre VARCHAR(20),
apellido VARCHAR(20),
telefono CHAR(9),
numTarjeta CHAR(16) NOT NULL,
f_nac DATE);

CREATE TABLE vivienda(
referencia CHAR(4) PRIMARY KEY,
direccion VARCHAR(20),
localidad VARCHAR(20));