/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;


import co.edu.utp.isc.gia.project.data.entity.ExamEntity;
import co.edu.utp.isc.gia.project.data.repository.ExamRepository;
import co.edu.utp.isc.gia.project.web.dto.ExamDto;
import java.util.List;
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
    
    public ExamService(ExamRepository examRepository, ModelMapper modelMapper){
        this.examRepository = examRepository;
        this.modelMapper = modelMapper;
    }
    
    public ExamDto save(ExamDto examEntity) throws Exception {
        ExamEntity exam = modelMapper.map(examEntity, ExamEntity.class);
        exam = examRepository.save(exam);
        ExamDto dto = modelMapper.map(exam, ExamDto.class);
        
        return dto;
    }
}
