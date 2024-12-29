package com.ust.Schoolservice.dto;

import lombok.Data;

@Data

public class Coursedto {
    public Long courseid;
    public String coursename;
    public String description;
    public String sid;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Coursedto(String sid) {
        this.sid = sid;
    }

    public Coursedto() {
    }

    public Coursedto(Long courseid, String coursename, String description) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.description = description;
    }

    public Long getCourseid() {
        return courseid;
    }

    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
