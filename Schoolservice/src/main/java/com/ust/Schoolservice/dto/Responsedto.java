package com.ust.Schoolservice.dto;

import lombok.Data;
import reactor.core.publisher.Flux;

import java.util.List;

@Data
public class Responsedto {
    private Studentdto studentdto;
    private List<Coursedto> coursedto;

    public Studentdto getStudentdto() {
        return studentdto;
    }

    public void setStudentdto(Studentdto studentdto) {
        this.studentdto = studentdto;
    }

    public List<Coursedto> getCoursedto() {
        return coursedto;
    }
    public void setCoursedto(List<Coursedto> coursedto) {
        this.coursedto = coursedto;
    }

    public Responsedto(Studentdto studentdto, List<Coursedto> coursedto) {
        this.studentdto = studentdto;
        this.coursedto = coursedto;
    }

    public Responsedto() {
    }

}


