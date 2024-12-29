package com.ust.CourseService.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Course {
    @Id

    public Long courseid;
    public String coursename;
    public String description;
    public String sid;

    public Course() {
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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Course(Long courseid, String coursename, String description, String sid) {
        this.courseid = courseid;
        this.coursename = coursename;
        this.description = description;
        this.sid = sid;
    }
}
