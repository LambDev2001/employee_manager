package com.youtube.project.manageemployee.controller;

import com.youtube.project.manageemployee.model.Employee;
import com.youtube.project.manageemployee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    // employee = {id, name, password, address}
    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        try {
            return employeeService.addEmployee(employee);
        } catch (IOException | SQLException e){
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/imageEmployee")
    public ResponseEntity<Long> uploadMultipartFile(@RequestParam("file") MultipartFile file) throws SQLException, IOException {
        Long idEmployee = employeeService.addPictureEmployee(file);
        return new ResponseEntity<>(idEmployee, HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

}
