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
@Table(name = "Usuario")
public class UserEntity implements Serializable {

    @Id
    private Long id;

    @Column(name = "Nombre", nullable = false)
    private String name;

    @Column(name = "Nombre_Usuario", nullable = false)
    private String username;

    @Column(name = "Clave", nullable = false)
    private String password;

    @Column(name = "Rol_Usuario", nullable = false)
    private int roleUser;
}
