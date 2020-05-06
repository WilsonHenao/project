/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.ExamService;
import co.edu.utp.isc.gia.project.web.dto.ExamDto;
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
@RequestMapping("api/v1/exam")
public class ExamController {
    private final ExamService examService;
    
    public ExamController(ExamService examService){
        this.examService = examService;
    }
    
    @PostMapping
    public ResponseEntity<?>insert(@RequestBody ExamDto examEntity){
        if(examEntity == null){
            return ResponseEntity.badRequest().body("Dato no válido");
        }
        
        ExamDto resp;
        try {
            resp = examService.save(examEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
