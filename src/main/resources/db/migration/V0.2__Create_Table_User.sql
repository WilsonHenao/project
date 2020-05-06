
CREATE TABLE Usuario (
Id int AUTO_INCREMENT,
Nombre varchar(50) not null,
Nombre_Usuario varchar(50) not null,
Clave varchar(50) not null,
Rol_Usuario int not null,
CONSTRAINT Usuario_pk PRIMARY KEY (Id),
FOREIGN KEY (Rol_Usuario) REFERENCES Rol(Id)
);
