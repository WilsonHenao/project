/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.TypeOfResponseEntity;
import co.edu.utp.isc.gia.project.data.repository.TypeOfResponseRepository;
import co.edu.utp.isc.gia.project.web.dto.TypeOfResponseDto;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilso
 */
@Service
public class TypeOfResponseService {
    private final TypeOfResponseRepository typeOfResponseRepository;
    private final ModelMapper modelMapper;
    
    public TypeOfResponseService(TypeOfResponseRepository typeOfResponseRepository, ModelMapper modelMapper){
        this.typeOfResponseRepository = typeOfResponseRepository;
        this.modelMapper = modelMapper;
    }
    
    public TypeOfResponseDto save(TypeOfResponseDto typeOfResponseEntity) throws Exception{
        TypeOfResponseEntity typeOfResponse = modelMapper.map(typeOfResponseEntity, TypeOfResponseEntity.class);
        typeOfResponse = typeOfResponseRepository.save(typeOfResponse);
        TypeOfResponseDto dto = modelMapper.map(typeOfResponse, TypeOfResponseDto.class);
        
        return dto;
    }
    
    public List<TypeOfResponseDto> findAll(){
        Iterable<TypeOfResponseEntity> list = typeOfResponseRepository.findAll();
        List<TypeOfResponseDto> dtos = new ArrayList();
        for(TypeOfResponseEntity entity : list) {
            dtos.add(modelMapper.map(entity, TypeOfResponseDto.class));
        }
        return dtos;
    }
    
}
