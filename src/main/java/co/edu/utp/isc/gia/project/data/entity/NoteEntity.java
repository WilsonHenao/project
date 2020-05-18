/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.data.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author wilso
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Notas")
public class NoteEntity implements Serializable {

    @Id
    private Long id;

    @Column(name = "Id_Profesor")
    private int idTeacher;

    @Column(name = "Id_Estudiante")
    private int idStudent;

    @Column(name = "Id_Examen")
    private int idExam;

    @Column(name = "Nota_Final")
    private float finalNote;
}
