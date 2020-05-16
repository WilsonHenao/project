/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.project.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 *
 * @author wilso
 */
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ExamDto {
    private Long id;
    private String introduction;
    private int maximumNote;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getMaximumNote() {
        return maximumNote;
    }

    public void setMaximumNote(int maximumNote) {
        this.maximumNote = maximumNote;
    }
}
