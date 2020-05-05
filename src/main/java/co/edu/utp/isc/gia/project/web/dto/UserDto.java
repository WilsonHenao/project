/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.dto;

import co.edu.utp.isc.gia.project.data.entity.RoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;

/**
 *
 * @author wilso
 */
@AllArgsConstructor
@Builder
public class UserDto {
    private String name;
    private String username;
    private String password;
    private RoleEntity roleEntity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleUser) {
        this.roleEntity = roleEntity;
    }
}
