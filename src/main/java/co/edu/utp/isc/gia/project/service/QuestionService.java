/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.QuestionEntity;
import co.edu.utp.isc.gia.project.data.repository.QuestionRepository;
import co.edu.utp.isc.gia.project.web.dto.QuestionDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilso
 */
@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;
    
    public QuestionService(QuestionRepository questionRepository, ModelMapper modelMapper){
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }
    
    public QuestionDto save(QuestionDto questionEntity) throws Exception {
        QuestionEntity question = modelMapper.map(questionEntity, QuestionEntity.class);
        question = questionRepository.save(question);
        QuestionDto resp = modelMapper.map(question, QuestionDto.class);
        
        return resp;
    }
}
