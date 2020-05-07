
CREATE TABLE Respuestas(
Id int AUTO_INCREMENT,
Respuesta varchar(300) not null,
Pregunta int not null,
Id_Estudiante int not null,
CONSTRAINT Respuestas_pk PRIMARY KEY (Id),
FOREIGN KEY (Pregunta) REFERENCES Pregunta(Id),
FOREIGN KEY (Id_Estudiante) REFERENCES Usuario(Id)
);

