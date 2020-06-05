/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.NoteEntity;
import co.edu.utp.isc.gia.project.data.repository.NoteRepository;
import co.edu.utp.isc.gia.project.web.dto.NoteDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilso
 */
@Service
public class NoteService {
    private final NoteRepository noteRepository;
    private final ModelMapper modelMapper;
    
    public NoteService(NoteRepository noteRepository, ModelMapper modelMapper){
        this.noteRepository = noteRepository;
        this.modelMapper = modelMapper;
    }
    
    public NoteDto save(NoteDto noteEntity) throws Exception {
        NoteEntity note = modelMapper.map(noteEntity, NoteEntity.class);
        note = noteRepository.save(note);
        NoteDto dto = modelMapper.map(note, NoteDto.class);
        
        return dto;
    }
    
    public List<NoteDto> findAll() {
        Iterable<NoteEntity> list = noteRepository.findAll();
        List<NoteDto> dtos = new ArrayList();
        for (NoteEntity entity : list) {
            dtos.add(modelMapper.map(entity, NoteDto.class));
        }
        return dtos;
    }
}
