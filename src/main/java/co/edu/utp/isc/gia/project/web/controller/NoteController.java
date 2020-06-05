/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.controller;

import co.edu.utp.isc.gia.project.service.NoteService;
import co.edu.utp.isc.gia.project.web.dto.NoteDto;
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
@RequestMapping("api/v1/note")
@CrossOrigin(origins = "*")
public class NoteController {
    private final NoteService noteService;
    
    public NoteController(NoteService noteService){
        this.noteService = noteService;
    }
    
    @PostMapping
    public ResponseEntity<?>insert(@RequestBody NoteDto noteEntity){
        if(noteEntity == null){
            return ResponseEntity.badRequest().body("Dato no válido");
        }
        
        NoteDto note;
        try {
            note = noteService.save(noteEntity);
        } catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
        
        return ResponseEntity.status(HttpStatus.CREATED).body(note);
    }
    
    @GetMapping("/all")
    public ResponseEntity<?> findAll() {
        List<NoteDto> noteDtos;

        try {
            noteDtos = noteService.findAll();
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }

        return ResponseEntity.status(HttpStatus.OK).body(noteDtos);
    }

}
