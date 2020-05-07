/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.AnswerService;
import co.edu.utp.isc.gia.project.web.dto.AnswerDto;
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
@RequestMapping("api/v1/answer")
public class AnswerController {
    private final AnswerService answerService;
    
    public AnswerController(AnswerService answerService){
        this.answerService = answerService;
    }
    
    @PostMapping
    public ResponseEntity<?>insert(@RequestBody AnswerDto answerEntity){
        if(answerEntity == null){
            return ResponseEntity.badRequest().body("Dato no válido");
        }
        
        AnswerDto answer;
        try {
            answer = answerService.save(answerEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(answer);
    }
}
