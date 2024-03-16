package com.youtube.project.manageemployee.model;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;
import java.util.Date;

@Data
public class Achievement {
    private Long id;
    private Long id_employee;
    private String name;
    private MultipartFile picture;
    private Date received_date;
}
