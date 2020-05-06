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
public class QuestionDto {
    private String description;
    private byte[] image;
    private int assessment;
    private int typeOfResponse;
    private int exam;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getAssessment() {
        return assessment;
    }

    public void setAssessment(int assessment) {
        this.assessment = assessment;
    }

    public int getTypeOfResponse() {
        return typeOfResponse;
    }

    public void setTypeOfResponse(int typeOfResponse) {
        this.typeOfResponse = typeOfResponse;
    }

    public int getExam() {
        return exam;
    }

    public void setExam(int exam) {
        this.exam = exam;
    }
}
