/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.OptionsEntity;
import co.edu.utp.isc.gia.project.data.repository.OptionsRepository;
import co.edu.utp.isc.gia.project.web.dto.OptionsDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilso
 */
@Service
public class OptionsService {
    private final OptionsRepository optionsRepository;
    private final ModelMapper modelMapper;
    
    public OptionsService(OptionsRepository optionsRepository, ModelMapper modelMapper){
        this.optionsRepository = optionsRepository;
        this.modelMapper = modelMapper;
    }
    
    public OptionsDto save(OptionsDto optionsEntity) throws Exception {
        OptionsEntity option = modelMapper.map(optionsEntity, OptionsEntity.class);
        option = optionsRepository.save(option);
        OptionsDto dto = modelMapper.map(option, OptionsDto.class);
        
        return dto;
    }
}
