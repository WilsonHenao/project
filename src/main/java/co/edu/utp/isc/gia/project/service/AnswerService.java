/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.AnswerEntity;
import co.edu.utp.isc.gia.project.data.repository.AnswerRepository;
import co.edu.utp.isc.gia.project.web.dto.AnswerDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilso
 */
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;
    private final ModelMapper modelMapper;
    
    public AnswerService(AnswerRepository answerRepository, ModelMapper modelMapper){
        this.answerRepository = answerRepository;
        this.modelMapper = modelMapper;
    }
    
    public AnswerDto save(AnswerDto answerEntity) throws Exception {
        AnswerEntity answer = modelMapper.map(answerEntity, AnswerEntity.class);
        answer = answerRepository.save(answer);
        AnswerDto dto = modelMapper.map(answer, AnswerDto.class);
        
        return dto;
    }
    
    public List<AnswerDto> findAll() {
        Iterable<AnswerEntity> list = answerRepository.findAll();
        List<AnswerDto> dtos = new ArrayList();
        for (AnswerEntity entity : list) {
            dtos.add(modelMapper.map(entity, AnswerDto.class));
        }
        return dtos;
    }
    
    public AnswerDto findByQuestion(Integer idQuestion) {
        Optional<AnswerEntity> optional = answerRepository.findByQuestion(idQuestion);
        AnswerDto answerDto = modelMapper.map(optional.get(), AnswerDto.class);
        return answerDto;
    }
}
