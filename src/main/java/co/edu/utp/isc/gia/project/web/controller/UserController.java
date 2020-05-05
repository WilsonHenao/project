/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.UserService;
import co.edu.utp.isc.gia.project.web.dto.UserDto;
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
@RequestMapping("api/v1/user")
public class UserController {
    
    private final UserService userService;
    
    public UserController(UserService userService){
        this.userService = userService;
    }
    
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody UserDto userEntity) {
        if (userEntity == null) {
            return ResponseEntity.badRequest().body("Datos de usuario inválidos");
        }
        
        UserDto resp;
        try {
            resp = userService.save(userEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
