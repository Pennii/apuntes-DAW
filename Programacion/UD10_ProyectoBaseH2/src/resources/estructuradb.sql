CREATE TABLE IF NOT EXISTS PRODUCTO(
    ID BIGINT NOT NULL PRIMARY KEY auto_increment,
    BARCODE VARCHAR(24) NOT NULL,
    NOMBRE VARCHAR(200) NOT NULL,
    PRECIO DOUBLE NOT NULL
);                    

CREATE TABLE IF NOT EXISTS TICKET (
    ID BIGINT NOT NULL PRIMARY KEY auto_increment,
    FECHA DATE NOT NULL,
    HORA TIME NOT NULL,
    TICKETCERRADO BOOLEAN NOT NULL  
);

CREATE TABLE IF NOT EXISTS LINEATICKET(
    ID BIGINT NOT NULL PRIMARY KEY auto_increment,
    CANTIDAD INTEGER NOT NULL,
    PRECIOVENTA DOUBLE NOT NULL,
    PRODUCTO_ID BIGINT,
    TICKET_ID BIGINT,
    FOREIGN KEY(PRODUCTO_ID) REFERENCES PRODUCTO(ID) ON UPDATE CASCADE ON DELETE CASCADE,
    FOREIGN KEY(TICKET_ID) REFERENCES TICKET(ID) ON UPDATE CASCADE ON DELETE CASCADE    
);   


MERGE INTO PRODUCTO(ID, BARCODE, NOMBRE, PRECIO) VALUES
(1, '01584881370340', 'Producto 1', 13.7447817594662),
(2, '11584881370372', 'Producto 2', 15.504554622987609),
(3, '21584881370373', 'Producto 3', 13.894065124488646),
(4, '31584881370374', 'Producto 4', 11.88227167001587),
(5, '41584881370375', 'Producto 5', 19.712651122160853),
(6, '51584881370377', 'Producto 6', 13.908057022812256),
(7, '61584881370377', 'Producto 7', 13.269162198915039),
(8, '71584881370378', 'Producto 8', 11.361505074956748),
(9, '81584881370379', 'Producto 9', 16.370210279999082),
(10, '91584881370380', 'Producto 10', 18.38855699920139);    
    
         