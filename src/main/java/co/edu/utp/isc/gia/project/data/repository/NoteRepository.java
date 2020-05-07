/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.data.repository;

import co.edu.utp.isc.gia.project.data.entity.NoteEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wilso
 */
@Repository
public interface NoteRepository extends CrudRepository<NoteEntity, Long> {
    
}
