package com.youtube.project.manageemployee.services;

import com.youtube.project.manageemployee.entity.DepartmentEntity;
import com.youtube.project.manageemployee.model.Department;
import com.youtube.project.manageemployee.repository.DepartmentRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements DepartmentImpService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentEntity addDepartment(String departmentName) {
        Optional<DepartmentEntity> existingDepartmentOptional = departmentRepository.findDepartmentByName(departmentName);

        if (existingDepartmentOptional.isPresent()) {
            throw new EntityExistsException("This department already exiting by name: " + departmentName);
        } else {
            DepartmentEntity newDepartment = new DepartmentEntity();
            newDepartment.setDepartmentName(departmentName);

            departmentRepository.save(newDepartment);
            return newDepartment;
        }
    }

    @Override
    public List<DepartmentEntity> getAllDepartments() {
        List<DepartmentEntity> departments = departmentRepository.findAll();
        return departments;
    }

    @Override
    public DepartmentEntity updateDepartment(Long id, Department department) {
        Optional<DepartmentEntity> existingDepartmentOptional = departmentRepository.findById(id);

        if (!existingDepartmentOptional.isPresent()) {
            throw new EntityNotFoundException("Department with ID " + id + " not found");
        }

        DepartmentEntity existingDepartment = existingDepartmentOptional.get();
        existingDepartment.setDepartmentName(department.getDepartmentName());

        DepartmentEntity updatedDepartment = departmentRepository.save(existingDepartment);
        return updatedDepartment;

    }

    @Override
    public void deleteDepartment(Long id) {
        Optional<DepartmentEntity> exitingDepartment = departmentRepository.findById(id);
        if (!exitingDepartment.isPresent()) {
            throw new EntityNotFoundException("Department with ID " + id + " not found");
        }
            departmentRepository.deleteById(id);

    }
}
