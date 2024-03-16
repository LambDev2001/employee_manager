package com.youtube.project.manageemployee.services;

import com.youtube.project.manageemployee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

public interface EmployeeImplementService  {
    ResponseEntity<String> addEmployee(Employee employee) throws IOException, SQLException;

    Optional<Employee> getEmployeeById(Long id);

    Long addPictureEmployee(MultipartFile file) throws IOException, SQLException;
}
