
CREATE TABLE Pregunta(
Id int AUTO_INCREMENT,
Descripcion varchar(300) not null,
Imagen varbinary,
Valoracion int not null,
Tipo_de_Respuesta int not null,
Examen int not null,
CONSTRAINT Pregunta_pk PRIMARY KEY (Id),
FOREIGN KEY (Tipo_de_Respuesta) REFERENCES Tipo_de_Respuesta(Id),
FOREIGN KEY (Examen) REFERENCES Examen(Id)
);

