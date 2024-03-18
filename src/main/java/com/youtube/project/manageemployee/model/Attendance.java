package com.youtube.project.manageemployee.model;

import lombok.Data;

import java.util.Date;
import java.sql.Time;

@Data
public class Attendance {
    private Long id;
    private Long employeeId;
    private Date date;
    private Time timeIn;
    private Time timeOut;
}
