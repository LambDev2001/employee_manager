package com.youtube.project.manageemployee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private List<EmployeeEntity> employees;
}

