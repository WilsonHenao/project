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
@Table(name = "Respuestas")
public class AnswerEntity implements Serializable {

    @Id
    private Long id;

    @Column(name = "Respuesta", nullable = false)
    private String answer;

    @Column(name = "Pregunta", nullable = false)
    private int question;

    @Column(name = "Id_Estudiante", nullable = false)
    private int idStudent;
}
