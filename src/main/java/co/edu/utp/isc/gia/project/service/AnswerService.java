/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.AnswerEntity;
import co.edu.utp.isc.gia.project.data.repository.AnswerRepository;
import co.edu.utp.isc.gia.project.web.dto.AnswerDto;
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
        AnswerDto resp = modelMapper.map(answer, AnswerDto.class);
        
        return resp;
    }
}
