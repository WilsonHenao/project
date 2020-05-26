/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.QuestionEntity;
import co.edu.utp.isc.gia.project.data.repository.QuestionRepository;
import co.edu.utp.isc.gia.project.web.dto.QuestionDto;
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
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ModelMapper modelMapper;

    public QuestionService(QuestionRepository questionRepository, ModelMapper modelMapper) {
        this.questionRepository = questionRepository;
        this.modelMapper = modelMapper;
    }

    public QuestionDto save(QuestionDto questionEntity) throws Exception {
        QuestionEntity question = modelMapper.map(questionEntity, QuestionEntity.class);
        question = questionRepository.save(question);
        QuestionDto dto = modelMapper.map(question, QuestionDto.class);

        return dto;
    }

    public List<QuestionDto> findAll() {
        Iterable<QuestionEntity> list = questionRepository.findAll();
        List<QuestionDto> dtos = new ArrayList();
        for (QuestionEntity entity : list) {
            dtos.add(modelMapper.map(entity, QuestionDto.class));
        }
        return dtos;
    }

    public QuestionDto findById(Long id) {
        Optional<QuestionEntity> optional = questionRepository.findById(id);
        QuestionDto questionDto = modelMapper.map(optional, QuestionDto.class);
        return questionDto;
    }

    public List<QuestionDto> findByExam(Integer idExam) {
        Iterable<QuestionEntity> qes = questionRepository.findByExam(idExam);
        List<QuestionDto> dtos = new ArrayList();
        for (QuestionEntity entity : qes) {
            dtos.add(modelMapper.map(entity, QuestionDto.class));
        }
        return dtos;
    }
}
