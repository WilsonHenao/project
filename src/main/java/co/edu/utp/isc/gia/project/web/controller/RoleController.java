/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.RoleService;
import co.edu.utp.isc.gia.project.web.dto.RoleDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilso
 */
@RestController
@RequestMapping("api/v1/role")
public class RoleController {
    private final RoleService roleService;
    
    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }
    
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody RoleDto roleEntity){
        if (roleEntity == null){
            return ResponseEntity.badRequest().body("Dato no válido");
        }
        
        RoleDto dto;
        try {
            dto = roleService.save(roleEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
