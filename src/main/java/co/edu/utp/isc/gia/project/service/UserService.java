/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.service;

import co.edu.utp.isc.gia.project.data.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import co.edu.utp.isc.gia.project.data.repository.UserRepository;
import co.edu.utp.isc.gia.project.web.dto.UserDto;

/**
 *
 * @author wilso
 */
@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    
    public UserService(UserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
    
    public UserDto save(UserDto userEntity) throws Exception {
        
       /* if(userEntity == null){
            throw new Exception("Parámetro no válido");
        }else if(userEntity.getName() == null || userEntity.getName().isEmpty()){
            throw new Exception ("Hace falta el nombre");
        }else if(userEntity.getUsername() == null || userEntity.getUsername().isEmpty()){
            throw new Exception ("Hace falta el nombre de usuario");
        }else if(userEntity.getPassword() == null || userEntity.getPassword().isEmpty()){
            throw new Exception ("Hace falta la contraseña");
        }else if(userEntity.getRoleEntity().getRoleName() == null || userEntity.getRoleEntity().getRoleName().isEmpty()){
            throw new Exception ("Hace falta el rol (¿Profesor o estudiante?)");
        }*/
        
        UserEntity user = modelMapper.map(userEntity, UserEntity.class);
        user = userRepository.save(user);
        UserDto resp = modelMapper.map(user, UserDto.class);
        
        return resp;
    }
}
