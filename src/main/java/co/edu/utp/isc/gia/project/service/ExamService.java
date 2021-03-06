/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.ExamEntity;
import co.edu.utp.isc.gia.project.data.repository.ExamRepository;
import co.edu.utp.isc.gia.project.web.dto.ExamDto;
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
public class ExamService {

    private final ExamRepository examRepository;
    private final ModelMapper modelMapper;

    public ExamService(ExamRepository examRepository, ModelMapper modelMapper) {
        this.examRepository = examRepository;
        this.modelMapper = modelMapper;
    }

    public ExamDto save(ExamDto examEntity) throws Exception {
        ExamEntity exam = modelMapper.map(examEntity, ExamEntity.class);
        exam = examRepository.save(exam);
        ExamDto dto = modelMapper.map(exam, ExamDto.class);

        return dto;
    }

    public List<ExamDto> findAll() {
        Iterable<ExamEntity> list = examRepository.findAll();
        List<ExamDto> dtos = new ArrayList();
        for (ExamEntity entity : list) {
            dtos.add(modelMapper.map(entity, ExamDto.class));
        }
        return dtos;
    }
    
    public ExamDto findById(Long id) {
        Optional<ExamEntity> optional = examRepository.findById(id);
        ExamDto examDto = modelMapper.map(optional.get(), ExamDto.class);
        return examDto;
    }
}
