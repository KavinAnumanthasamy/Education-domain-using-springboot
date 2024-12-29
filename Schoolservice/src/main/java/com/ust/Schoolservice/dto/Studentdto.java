package com.ust.Schoolservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Studentdto {
    public long id;
    @NotBlank(message= "Name cannot be empty")
    public String name;
    @Email(message="email should be valid ")
    @NotBlank(message="email cannot be empty")
    public String email;
    public String sid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public Studentdto() {
    }

    public Studentdto(long id, String name, String email, String sid) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.sid = sid;
    }
}
