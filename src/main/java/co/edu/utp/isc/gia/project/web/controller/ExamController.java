/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.ExamService;
import co.edu.utp.isc.gia.project.web.dto.ExamDto;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@CrossOrigin(origins = "*")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody ExamDto examDto) {
        if (examDto != null) {
        } else {
            return ResponseEntity.badRequest().body("Dato no válido");
        }

        ExamDto exam;
        try {
            exam = examService.save(examDto);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(exam);
    }

    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<ExamDto> examDtos;

        try {
            examDtos = examService.findAll();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(examDtos);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        ExamDto examDto;

        try {
            examDto = examService.findById(id);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(examDto);
    }
}
