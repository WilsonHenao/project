/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.RoleEntity;
import co.edu.utp.isc.gia.project.data.repository.RoleRepository;
import co.edu.utp.isc.gia.project.web.dto.RoleDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

/**
 *
 * @author wilso
 */
@Service
public class RoleService {
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;
    
    public RoleService(RoleRepository roleRepository, ModelMapper modelMapper){
        this.roleRepository = roleRepository;
        this.modelMapper = modelMapper;
    }
    
    public RoleDto save(RoleDto roleEntity) throws Exception {
        RoleEntity role = modelMapper.map(roleEntity, RoleEntity.class);
        role = roleRepository.save(role);
        RoleDto resp = modelMapper.map(role, RoleDto.class);
        System.out.println(role);
        
        return resp;
    }
}
