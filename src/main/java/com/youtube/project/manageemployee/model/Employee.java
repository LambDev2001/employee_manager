package com.youtube.project.manageemployee.model;

import com.youtube.project.manageemployee.utils.EnumGender;
import lombok.Data;

import java.util.Date;
import java.sql.Blob;

@Data
public class Employee {
    private Long id;
    private String lastName;
    private String firstName;
    private Date dateOfBirth;
    private String password;
    private String email;
    private String address;
    private Blob picture;
    private EnumGender gender;
    private String phoneNumber;
    private Date createdAt;
    private Date updatedAt;
    private Long departmentId;
}
