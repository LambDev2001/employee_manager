package com.youtube.project.manageemployee.services;

import com.youtube.project.manageemployee.entity.EmployeeEntity;
import com.youtube.project.manageemployee.model.Employee;
import com.youtube.project.manageemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeImpService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<String> addEmployee(Employee employee) throws IOException, SQLException {
        Optional<EmployeeEntity> optionalEmployee = employeeRepository.findById(employee.getId());

//        if (optionalEmployee.isPresent()) {
//            EmployeeEntity existingEmployee = optionalEmployee.get();
//
//            existingEmployee.setName(employee.getName());
//            existingEmployee.setEmail(employee.getEmail());
//            existingEmployee.setPassword(employee.getPassword());
//            existingEmployee.setAddress(employee.getAddress());
//
//            employeeRepository.save(existingEmployee);
//            return new ResponseEntity<>("Received name: " + employee.getName() + ", email: " + employee.getEmail(), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("Employee with ID " + employee.getId() + " not found", HttpStatus.NOT_FOUND);
//        }
        return  new ResponseEntity<>("Employee with ID " + employee.getId() + " not found", HttpStatus.NOT_FOUND);
    }

    @Override
    public Long addPictureEmployee(MultipartFile file) throws IOException, SQLException {
        Blob blob = new javax.sql.rowset.serial.SerialBlob(file.getBytes());
        EmployeeEntity newEmployee = new EmployeeEntity();
        newEmployee.setPicture(blob);
        EmployeeEntity savedEmployee = employeeRepository.save(newEmployee);
        return savedEmployee.getId();
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        Optional<EmployeeEntity> employeeOptional = employeeRepository.findById(id);

        return employeeOptional.map(employeeEntity -> {
            Employee employee = new Employee();
            employee.setId(employeeEntity.getId());
//            employee.setName(employeeEntity.getName());

            return employee;
        });
    }
}
