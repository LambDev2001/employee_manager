package com.youtube.project.manageemployee.controller;

import com.youtube.project.manageemployee.entity.DepartmentEntity;
import com.youtube.project.manageemployee.model.Department;
import com.youtube.project.manageemployee.services.DepartmentImpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class DepartmentController {
    @Autowired
    private DepartmentImpService departmentImpService;

    @PostMapping("/department")
    public DepartmentEntity addDepartment(@RequestBody Department department){
        DepartmentEntity newDepartment = departmentImpService.addDepartment(department.getDepartmentName());
        return newDepartment;
    }

    @GetMapping("/departments")
    public List<DepartmentEntity> getAllDepartments(){
        List<DepartmentEntity> departments = departmentImpService.getAllDepartments();
        return departments;
    }

    @PutMapping("/department/{id}")
    public DepartmentEntity updateDepartment(@PathVariable Long id, @RequestBody Department department){
        DepartmentEntity newDepartment = departmentImpService.updateDepartment(id, department);
        return newDepartment;
    }

    @DeleteMapping("/department/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long id){
        departmentImpService.deleteDepartment(id);
        return new ResponseEntity<>("Department deleted successfully", HttpStatus.OK);
    }
}
