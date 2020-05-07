
CREATE TABLE Notas(
Id int AUTO_INCREMENT,
Id_Profesor int,
Id_Estudiante int,
Id_Examen int,
Nota_Final float,
CONSTRAINT Nota_pk PRIMARY KEY (Id),
FOREIGN KEY (Id_Profesor) REFERENCES Usuario(Id),
FOREIGN KEY (Id_Estudiante) REFERENCES Usuario(Id),
FOREIGN KEY (Id_Examen) REFERENCES Examen(Id)
);

