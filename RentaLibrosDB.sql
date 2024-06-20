create database RentaLibrosDB
go

CREATE TABLE clientes (
    IDCli INT PRIMARY KEY IDENTITY,
    NombreCli NVARCHAR(100),
    EmailCli NVARCHAR(100),
    TelefonoCli NVARCHAR(20)
)
go

CREATE TABLE libros (
    IDLib INT PRIMARY KEY IDENTITY,
    TituloLib NVARCHAR(255),
    AutorLib NVARCHAR(100),
    GeneroLib NVARCHAR(50),
    LanzamientoLib INT,
    EstadoLib NVARCHAR(20) -- 'Disponible' o 'rentado'
);
go

CREATE TABLE rentas (
    IDRenta INT PRIMARY KEY IDENTITY,
    IDCli INT FOREIGN KEY REFERENCES clientes(IDCli),
    IDLib INT FOREIGN KEY REFERENCES libros(IDLib),
    FechaDeRenta DATETIME,
    FechaDeDevolucion DATETIME,
    FechaDevolucionReal DATETIME,
    TarifaRenta DECIMAL
)
go