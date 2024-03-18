package com.youtube.project.manageemployee.model;

import lombok.Data;

import java.util.Date;
import java.sql.Blob;

@Data
public class Achievement {
    private Long id;
    private String name;
    private Long employeeId;
    private Blob picture;
    private Date receivedDate;
}
