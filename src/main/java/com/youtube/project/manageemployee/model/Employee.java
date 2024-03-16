package com.youtube.project.manageemployee.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;

@Data
public class Employee {
    private Long id;
    private String name;
    private Blob picture;
    private MultipartFile multiPicture;
    private String email;
    private String address;
    private String password;
}
