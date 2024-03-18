package com.youtube.project.manageemployee.services;

import com.youtube.project.manageemployee.entity.DepartmentEntity;
import com.youtube.project.manageemployee.model.Department;

import java.util.List;

public interface DepartmentImpService {
    DepartmentEntity addDepartment(String name);

    List<DepartmentEntity> getAllDepartments();

    DepartmentEntity updateDepartment(Long id, Department department);

    void deleteDepartment(Long id);
}
