create database RENTA_LIBROS_DB
go

use RENTA_LIBROS_DB
go

CREATE TABLE cliente (
    id INT PRIMARY KEY IDENTITY,
	dni char(8),
    nombre VARCHAR(100),
    email VARCHAR(100),
    telefono VARCHAR(20)
)
go

CREATE TABLE libro (
    id INT PRIMARY KEY IDENTITY,
    titulo VARCHAR(200),
    autor VARCHAR(100),
    genero VARCHAR(50),
    estado VARCHAR(20) -- 'Disponible' o 'rentado'
);
go

CREATE TABLE renta (
    id_renta INT PRIMARY KEY IDENTITY,
    id_cliente INT FOREIGN KEY REFERENCES cliente(id),
    id_libro INT FOREIGN KEY REFERENCES libro(id),
    fecha_de_renta DATETIME,
    fecha_de_devolucion DATETIME
)
go

use master
go

drop database RENTA_LIBROS_DB
go

insert into cliente(dni,nombre,email,telefono) values ('87654321','Fabian9','fabian9@gmail.com','987654329')
go

insert into libro(titulo,autor,genero,estado) values ('El principito','Antoine de Saint-Exupery','Fabula','Disponible')
go

select * from cliente
go

select * from libro
go