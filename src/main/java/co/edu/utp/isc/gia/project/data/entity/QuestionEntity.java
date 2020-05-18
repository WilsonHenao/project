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
@Table(name = "Pregunta")
public class QuestionEntity implements Serializable {

    @Id
    private Long id;

    @Column(name = "Descripcion", nullable = false)
    private String description;

    @Column(name = "Imagen")
    private byte[] image;

    @Column(name = "Valoracion", nullable = false)
    private int assessment;

    @Column(name = "Tipo_de_Respuesta", nullable = false)
    private int typeOfResponse;
    
    @Column(name = "Respuesta_Correcta", nullable = false)
    private String correctAnswer;

    @Column(name = "Examen", nullable = false)
    private int exam;
}
