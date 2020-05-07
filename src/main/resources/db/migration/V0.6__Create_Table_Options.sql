
CREATE TABLE Opciones(
Id int AUTO_INCREMENT,
Opcion varchar(300) not null,
Respuesta_Correcta varchar(10) not null,
Pregunta int not null,
CONSTRAINT Opciones_pk PRIMARY KEY (Id),
FOREIGN KEY (Pregunta) REFERENCES Pregunta(Id)
);

