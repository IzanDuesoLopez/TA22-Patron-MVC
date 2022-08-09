drop database if exists C4_UD22_01;
create database C4_UD22_01;
use C4_UD22_01;

CREATE TABLE clientes (
	id int(11) NOT NULL AUTO_INCREMENT,
	nombre varchar(250) DEFAULT NULL,
	apellido varchar(250) DEFAULT NULL,
	direccion varchar(250) DEFAULT NULL,
	dni int(11) DEFAULT NULL,
	fecha date DEFAULT NULL,
	PRIMARY KEY (id)
);

insert into clientes(nombre, apellido, direccion, dni, fecha) values 
	("Joel", "Romero", "C/Calle", 12345678, "2022-10-08"),
    ("Izan", "Dueso", "C/Calle 2", 87654321, "2022-11-08");