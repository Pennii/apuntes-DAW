ALTER SESSION SET NLS_DATE_FORMAT='DD/MM/YYYY';

create table clinica (
    codigo char(6),
    nombre varchar2(35),
    direccion varchar2(50),
    localidad varchar2(35),
    provincia varchar2(20),
    primary key (codigo)
);

create table paciente (
	NSS char(12),
    DNI char(9) unique,
    nombre varchar2(30),
    apellidos varchar2(50),
    sexo char(1) check (sexo in ('M','F')),
    fechaNac date,
    historial varchar2(450),
    primary key (NSS)
);

create table medico (
	numcolegiado char(9),
    nombre varchar2(30),
    apellidos varchar2(50),
    especialidad varchar2(20),
    fechaAlta Date,
    idclinica char(6),	
    primary key (numcolegiado),
    constraint fk_med_idc foreign key (idclinica) references clinica(codigo) 
    on delete cascade
);

create table consultas (
	idmedico char(9),
    idpaciente char(12),
    fechaConsulta date,
    importe number(5,2),  	
    primary key(idmedico,idpaciente,fechaConsulta),
    constraint fk_con_idm foreign key (idmedico) references medico(numcolegiado)
    on delete cascade,
    constraint fk_con_idp foreign key (idpaciente) references paciente(nss)
    on delete cascade
);
	
INSERT INTO clinica VALUES('000001','Cl�nica del Carmen','Avda Italia 22','Huelva','Huelva');
INSERT INTO clinica VALUES('000002','Cl�nica Plaza de las Monjas','Plaza de las Monjas 2','Huelva','Huelva');
INSERT INTO clinica VALUES('000003','Grupo Pedi�trico Uncibay','Calle Molina Lario 7, 2�','M�laga','M�laga');
INSERT INTO clinica VALUES('000004','Policl�nica San Juan','Avda del Mediterr�neo 20','Alhaur�n de la Torre','M�laga');
INSERT INTO clinica VALUES('000005','Cl�nica HLA Santa Isabel','Calle Luis Montoto 100','Sevilla','Sevilla');
INSERT INTO clinica VALUES('000006','Centro m�dico Semud','Calle Ponce de Le�n 1','Utrera','Sevilla');
INSERT INTO clinica VALUES('000007','Policl�nica �beda','Calle Explanada 23 Bajo','�beda','Ja�n');
INSERT INTO clinica VALUES('000008','Policl�nica Santa Mar�a','Calle Santa Mar�a Soledad 13','C�diz','C�diz');
INSERT INTO clinica VALUES('000009','Policl�nica Los Millares','Carrera del Duende 16','Almer�a','Almer�a');
INSERT INTO clinica VALUES('000010','Cl�nica El Brillante','Avda Brillante 64','C�rdoba','C�rdoba');
INSERT INTO clinica VALUES('000011','Vithas Rinc�n de la Victoria','Avda de la Torre 15','Rinc�n de la Victoria','M�laga');
INSERT INTO clinica VALUES('000012','Centro M�dico Vithas Limonar','Calle La Era 6','M�laga','M�laga');


INSERT INTO paciente VALUES('048234231013','12322341E','Juan','Gonz�lez Fern�ndez','M','24/03/1986',NULL);
INSERT INTO paciente VALUES('285543156276','67863423Z','Ram�n','Rodr�guez N��ez','M','02/09/1999',NULL);
INSERT INTO paciente VALUES('296755433362','02384234P','Mar�a','Mart�n S�nchez','F','24/11/1970',NULL);
INSERT INTO paciente VALUES('184376546134','98712234Y','Laura','Guti�rrez Albiol','F','04/06/2001',NULL);
INSERT INTO paciente VALUES('117775436758','64528976S','Inma','Dom�nguez Cerrato','F','03/03/1993',NULL);
INSERT INTO paciente VALUES('238712259124','34500232W','Jose','Torres Lopez','M','24/03/1980',NULL);
INSERT INTO paciente VALUES('147655600078','56434010Z','Luis','Miguel Casado','M','01/08/1998',NULL);
INSERT INTO paciente VALUES('215438967278','70725455H','Francisco','Heiver Jhons','M','25/05/2021',NULL);
INSERT INTO paciente VALUES('219127751986','34678891C','Salvador','Rubiales Perez','M','02/08/2015',NULL);
INSERT INTO paciente VALUES('296001902000','80092300K','Ascensi�n','Rodr�guez Ruiz','F','24/06/2020',NULL);

INSERT INTO medico VALUES('414117320','Fernando','Garc�a P�rez-Sevillano','Endocrinolog�a','15/03/2000','000001');
INSERT INTO medico VALUES('212305458','Bel�n','Hinojosa Jara','Alergolog�a','05/05/1998','000001');
INSERT INTO medico VALUES('414112680','Rafael Fernando','Romero Garrido','Cardiolog�a','01/08/2001','000002');
INSERT INTO medico VALUES('414115731','Pablo','Herrera Mart�n','Aparato Digestivo','07/07/2015','000002');
INSERT INTO medico VALUES('292904902','Manuel Ram�n','Baca Cots','Pediatr�a','03/09/2018','000003');
INSERT INTO medico VALUES('292908760','Manuel','Rueda Ortiz','Otorrinolaringolo','17/04/1999','000004');
INSERT INTO medico VALUES('414112290','Matilde','Zamorano del R�o','Ginecolog�a','03/04/2002','000005');
INSERT INTO medico VALUES('414106178','Rafael Carlos','L�pez Jim�nez','Oftalmolog�a','07/11/1999','000006');
INSERT INTO medico VALUES('414105898','Miguel','Fashho Bayouk','Dermatolog�a','29/10/2003','000006');
INSERT INTO medico VALUES('232303028','Pedro','Fuentes Pe�as','Medicina General','26/02/2010','000007');
INSERT INTO medico VALUES('111105075','Mar�a del Rosario de F�tima','Ram�rez Chamorro','Urolog�a','13/07/2011','000008');
INSERT INTO medico VALUES('040403859','Mar�a Luisa','Morales Mart�nez','Nutrici�n','31/12/1995','000009');
INSERT INTO medico VALUES('141404656','Miguel �ngel','Mart�n P�rez','Neumolog�a','20/06/1999','000010');
INSERT INTO medico VALUES('211108485','Antonio Enrique','G�mez Menchero','Cardiolog�a','09/10/2005','000001');
INSERT INTO medico VALUES('414117017','�lvaro','Arce Le�n','Cardiolog�a','29/09/2008','000001');
INSERT INTO medico VALUES('292911024','Ester','Romero Escribano','Traumatolog�a','15/09/2004','000004');
INSERT INTO medico VALUES('141403602','Antonio','Pineda Sicilia','Traumatolog�a','18/07/2001','000010');
INSERT INTO medico VALUES('412104405','Francisco Jos�','Lara Pulido','Traumatolog�a','19/03/2017','000001');
INSERT INTO medico VALUES('212102841','Luisa','Mira Toscano','Pediatr�a','19/03/2000','000001');
INSERT INTO medico VALUES('294118197','Rub�n Jes�s','Gil Cardona','Pediatr�a','07/05/2001','000011');
INSERT INTO medico VALUES('292910421','Pablo','Cabezudo Garc�a','Neurolog�a','07/05/2000','000012');

INSERT INTO consultas VALUES('414112680','048234231013','15/03/2020',45);
INSERT INTO consultas VALUES('414117017','238712259124','14/02/2023',110);
INSERT INTO consultas VALUES('211108485','215438967278','03/05/2020',95);
INSERT INTO consultas VALUES('292904902','296001902000','11/02/2023',80);
INSERT INTO consultas VALUES('292904902','296001902000','01/12/2022',70);
INSERT INTO consultas VALUES('292904902','296001902000','08/03/2023',80);
INSERT INTO consultas VALUES('212102841','219127751986','17/05/2020',35);
INSERT INTO consultas VALUES('294118197','215438967278','01/08/2021',35);
INSERT INTO consultas VALUES('412104405','048234231013','13/06/2022',40);
INSERT INTO consultas VALUES('141403602','147655600078','11/11/2021',45);
INSERT INTO consultas VALUES('292911024','117775436758','02/06/2022',55);
INSERT INTO consultas VALUES('212305458','048234231013','15/12/2021',65);
INSERT INTO consultas VALUES('111105075','285543156276','19/04/2023',60);
INSERT INTO consultas VALUES('292908760','296001902000','19/04/2021',100);
INSERT INTO consultas VALUES('292908760','296001902000','30/06/2021',100);
INSERT INTO consultas VALUES('292908760','296001902000','18/05/2022',120);
INSERT INTO consultas VALUES('292910421','296001902000','23/05/2020',80);
INSERT INTO consultas VALUES('292910421','296001902000','10/04/2021',85);
INSERT INTO consultas VALUES('292910421','296001902000','01/04/2022',90);
INSERT INTO consultas VALUES('292910421','296001902000','11/06/2022',90);
INSERT INTO consultas VALUES('292910421','296001902000','30/03/2023',95);
INSERT INTO consultas VALUES('414117320','296755433362','15/01/1998',95);
INSERT INTO consultas VALUES('414117320','296755433362','15/06/1998',95);
INSERT INTO consultas VALUES('414117320','296755433362','01/02/1999',100);
INSERT INTO consultas VALUES('414117320','296755433362','01/07/1999',100);
INSERT INTO consultas VALUES('414117320','296755433362','15/01/2000',120);
INSERT INTO consultas VALUES('414117320','296755433362','30/05/2000',120);
INSERT INTO consultas VALUES('414117320','296755433362','15/09/2000',120);
INSERT INTO consultas VALUES('414117320','296755433362','10/03/2001',150);
INSERT INTO consultas VALUES('414117320','296755433362','20/09/2001',150);
INSERT INTO consultas VALUES('414117320','296755433362','14/02/2002',170);
INSERT INTO consultas VALUES('414117320','296755433362','22/07/2002',170);
INSERT INTO consultas VALUES('414117320','296755433362','11/05/2005',200);
INSERT INTO consultas VALUES('414117320','296755433362','15/06/2005',200);
INSERT INTO consultas VALUES('414117320','296755433362','01/07/2005',200);
INSERT INTO consultas VALUES('414117320','296755433362','15/07/2006',220);
INSERT INTO consultas VALUES('414117320','296755433362','30/06/2007',225);
INSERT INTO consultas VALUES('414117320','296755433362','01/05/2008',230);
INSERT INTO consultas VALUES('414117320','296755433362','22/05/2009',235);
INSERT INTO consultas VALUES('414117320','184376546134','10/01/2023',250);























































