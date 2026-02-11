create database if not exists goblindb;

use goblindb;

drop table if exists userdata;

CREATE TABLE `userdata` (
   `id` int NOT NULL AUTO_INCREMENT,
   `Nombre` varchar(25) NOT NULL,
   `Email` varchar(40) NOT NULL,
   `Password` varchar(100) NOT NULL,
   PRIMARY KEY (`id`)
 ); 

drop table if exists estadisticas;

CREATE TABLE `estadisticas` (
   `id` int NOT NULL AUTO_INCREMENT,
   `Pasos` int NOT NULL,
   `Muertes` int NOT NULL,
   `EnemigosDerrotados` int NOT NULL,
   PRIMARY KEY (`id`)
 ); 
 
 insert into estadisticas (pasos, muertes, enemigosderrotados) values (0,0,0);