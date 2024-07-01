create database RENTA_LIBROS_DB
go

use RENTA_LIBROS_DB
go

CREATE TABLE cliente (
    id INT PRIMARY KEY IDENTITY,
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
    lanzamiento DATETIME,
    estado VARCHAR(20) -- 'Disponible' o 'rentado'
);
go

CREATE TABLE renta (
    id_renta INT PRIMARY KEY IDENTITY,
    id_cliente INT FOREIGN KEY REFERENCES cliente(id),
    id_libro INT FOREIGN KEY REFERENCES libro(id),
    fecha_de_renta DATETIME,
    fecha_de_devolucion DATETIME,
    fecha_de_devolucion_Real DATETIME,
    tarifa_renta DECIMAL
)
go

use master
go

drop database RENTA_LIBROS_DB
go

insert into cliente(nombre,email,telefono) values ('Fabian','fabian@gmail.com','987654321')