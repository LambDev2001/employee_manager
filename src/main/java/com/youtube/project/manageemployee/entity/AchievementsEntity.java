package com.youtube.project.manageemployee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Date;

@Entity
@Data
public class AchievementsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private EmployeeEntity employee;

    @Lob
    private Blob picture;
    private Date received_date;
}
