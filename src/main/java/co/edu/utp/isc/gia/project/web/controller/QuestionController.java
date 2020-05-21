/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.QuestionService;
import co.edu.utp.isc.gia.project.web.dto.QuestionDto;
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
@RequestMapping("api/v1/question")
@CrossOrigin(origins = "*")
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
        
        QuestionDto dto;
        try {
            dto = questionService.save(questionEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<QuestionDto> questionDtos;

        try {
            questionDtos = questionService.findAll();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(questionDtos);
    }
    
    @GetMapping()
    public ResponseEntity<?> findById(Long id) {
        List<QuestionDto> questionDtos;

        try {
            questionDtos = questionService.findById(id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(questionDtos);
    }
}
