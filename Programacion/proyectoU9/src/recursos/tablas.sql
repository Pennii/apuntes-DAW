CREATE TABLE IF NOT EXISTS PROVEEDOR(
	ID VARCHAR(3) PRIMARY KEY,
    NOMBRE VARCHAR(20)
);
CREATE TABLE IF NOT EXISTS PRODUCTO(
	CODIGO VARCHAR(4) PRIMARY KEY,
    NOMBRE VARCHAR(20),
    UNIDADES INT(2),
    PROV VARCHAR(4),
    CONSTRAINT PROD_PROV_FK FOREIGN KEY (PROV) REFERENCES PROVEEDOR(ID) ON DELETE SET NULL ON UPDATE CASCADE);
CREATE TABLE IF NOT EXISTS CLIENTE(
	CODIGO VARCHAR(4) PRIMARY KEY,
    NOMBRE VARCHAR(20),
    EDAD SMALLINT);
CREATE TABLE IF NOT EXISTS PEDIDO(
	PROD VARCHAR(4),
    CLIEN VARCHAR(4),
    FECHA DATE,
    CONSTRAINT PED_PK PRIMARY KEY(PROD, CLIEN, FECHA));
CREATE TABLE IF NOT EXISTS REPARTIDOR(
	CODIGO VARCHAR(4) PRIMARY KEY,
    NOMBRE VARCHAR(20),
    VEHICULO ENUM('A','M','B'));
CREATE TABLE IF NOT EXISTS REPARTO(
	REPARTIDOR VARCHAR(4),
    PRODUCTO VARCHAR(4),
    FECHA DATE,
    CONSTRAINT PED_PK PRIMARY KEY (PRODUCTO, REPARTIDOR, FECHA));
INSERT INTO PROVEEDOR VALUES("P01", "Adrian"), 
("P02", "Julian"),
("P03", "Damian"),
("P04", "Julieta");
INSERT INTO PRODUCTO VALUES("B001", "Yerba", 50, "P01"),
("B002", "Azucar", 50, "P01"),
("B003", "Galleta", 50, "P01"),
("B004", "Lapiz", 50, "P02"),
("B005", "Libro", 50, "P02"),
("B006", "Taza", 50, "P03"),
("B007", "Teclado", 50, "P04"),
("B008", "Monitor", 50, "P04");
INSERT INTO CLIENTE VALUES("C001", "Ramiro", 19),
("C002", "Camila", 23),
("C003", "Julio", 36);
INSERT INTO REPARTIDOR VALUES("R001", "Emilio", "A"),
("R002", "Diego", "M"),
("R003", "Mario", "B");