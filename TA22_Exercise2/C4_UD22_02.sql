drop database if exists C4_UD22_02;
create database C4_UD22_02;
use C4_UD22_02;

CREATE TABLE clientes (
	id int(11) NOT NULL AUTO_INCREMENT,
	nombre varchar(250) DEFAULT NULL,
	apellido varchar(250) DEFAULT NULL,
	direccion varchar(250) DEFAULT NULL,
	dni int(11) DEFAULT NULL,
	fecha date DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE videos (
	id int(11) NOT NULL AUTO_INCREMENT,
	title varchar(250) DEFAULT NULL,
	director varchar(250) DEFAULT NULL,
	cli_id int(11) DEFAULT NULL,
	PRIMARY KEY (id),
	CONSTRAINT videos_fK FOREIGN KEY (cli_id) REFERENCES clientes (id)
    on delete cascade on update cascade
);

insert into clientes(nombre, apellido, direccion, dni, fecha) values 
	("Joel", "Romero", "C/Calle", 12345678, "2022-10-08"),
    ("Izan", "Dueso", "C/Calle 2", 87654321, "2022-11-08");
    
insert into videos(title, director, cli_id) values 
	("Peli 1", "Director 1", 1),
    ("Peli 2", "Director 1", 2);
    
select * from  clientes;