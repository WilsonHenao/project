/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.OptionsService;
import co.edu.utp.isc.gia.project.web.dto.OptionsDto;
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
@RequestMapping("api/v1/option")
public class OptionsController {
    
    private final OptionsService optionsService;
    
    public OptionsController(OptionsService optionsService){
        this.optionsService = optionsService;
    }
    
    @PostMapping
    public ResponseEntity<?>insert(@RequestBody OptionsDto optionsEntity) {
        if(optionsEntity == null) {
            return ResponseEntity.badRequest().body("Datos no válidos");
        }
        
        OptionsDto resp;
        try {
            resp = optionsService.save(optionsEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
