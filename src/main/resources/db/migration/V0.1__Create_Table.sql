
CREATE TABLE Rol (
Id int AUTO_INCREMENT,
Nombre_Rol varchar(100) not null,
CONSTRAINT Rol_pk PRIMARY KEY (Id)
);

CREATE TABLE Usuario (
Id int AUTO_INCREMENT,
Nombre varchar(50) not null,
Nombre_Usuario varchar(50) not null,
Clave varchar(50) not null,
Rol_Usuario varchar(100) not null,
CONSTRAINT Usuario_pk PRIMARY KEY (Id),
FOREIGN KEY (Rol_Usuario) REFERENCES Rol(Nombre_Rol)
);
