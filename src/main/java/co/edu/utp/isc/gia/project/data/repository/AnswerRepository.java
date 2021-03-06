/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.data.repository;

import co.edu.utp.isc.gia.project.data.entity.AnswerEntity;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wilso
 */
@Repository
public interface AnswerRepository extends CrudRepository<AnswerEntity, Long> {
    
    public Optional<AnswerEntity> findByQuestion(int idQuestion);
}
