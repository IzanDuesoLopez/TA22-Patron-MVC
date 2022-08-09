drop database if exists C4_UD22_03;
create database C4_UD22_03;
use C4_UD22_03;

CREATE TABLE cientificos (
	dni varchar(8) NOT NULL,
	nomApels varchar(255) DEFAULT NULL,
	PRIMARY KEY (dni)
);

CREATE TABLE proyectos (
	id char(4) NOT NULL,
	nombre varchar(255) DEFAULT NULL,
    horas int DEFAULT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE asignados_a (
	idAuto int NOT NULL auto_increment,
	cientifico varchar(8) NOT NULL,
    proyecto char(4) NOT NULL,
	PRIMARY KEY (idAuto),
    CONSTRAINT asignados_a_fk_1 FOREIGN KEY (cientifico) REFERENCES cientificos (dni)
    on delete cascade on update cascade,
    CONSTRAINT asignados_a_fk_2 FOREIGN KEY (proyecto) REFERENCES proyectos (id)
    on delete cascade on update cascade
);

insert into cientificos(dni, nomApels) values 
	("1234234A", "Joel Romero"),
    ("8765876B", "Izan Dueso");
    
insert into proyectos(id, nombre, horas) values 
	("AB01", "Proyecto 1", 350),
    ("AB02", "Proyecto 2", 400);
    
insert into asignados_a(cientifico, proyecto) values 
	("1234234A", "AB01"),
    ("8765876B", "AB02");