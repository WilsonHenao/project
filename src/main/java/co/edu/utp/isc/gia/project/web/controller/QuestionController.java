/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.QuestionService;
import co.edu.utp.isc.gia.project.web.dto.QuestionDto;
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
@RequestMapping("api/v1/question")
public class QuestionController {
    
    private final QuestionService questionService;
    
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }
    
    @PostMapping
    public ResponseEntity<?> insert(@RequestBody QuestionDto questionEntity) {
        if(questionEntity == null) {
            return ResponseEntity.badRequest().body("Dato no válido");
        }
        
        QuestionDto resp;
        try {
            resp = questionService.save(questionEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }
}
