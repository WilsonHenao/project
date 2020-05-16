/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.TypeOfResponseService;
import co.edu.utp.isc.gia.project.web.dto.TypeOfResponseDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author wilso
 */
@RestController
@RequestMapping("api/v1/typeOfResponse")
@CrossOrigin(origins = "*")
public class TypeOfResponseController {
    private final TypeOfResponseService typeOfResponseService;
    
    public TypeOfResponseController(TypeOfResponseService typeOfResponseService){
        this.typeOfResponseService = typeOfResponseService;
    }
    
    @GetMapping
    public ResponseEntity<?> findAll(){
        List<TypeOfResponseDto> responseDtos;
        
        try {
            responseDtos = typeOfResponseService.findAll();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.OK).body(responseDtos);
    }
    
    @PostMapping
    public ResponseEntity<?>insert(@RequestBody TypeOfResponseDto typeOfResponseEntity){
        if(typeOfResponseEntity == null){
            return ResponseEntity.badRequest().body("Dato no válido");
        }
        
        TypeOfResponseDto dto;
        try {
            dto = typeOfResponseService.save(typeOfResponseEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
}
