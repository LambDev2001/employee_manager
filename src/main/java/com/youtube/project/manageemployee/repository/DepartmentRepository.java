package com.youtube.project.manageemployee.repository;

import com.youtube.project.manageemployee.entity.DepartmentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
    @Query("SELECT d FROM DepartmentEntity d WHERE d.departmentName = :name")
    Optional<DepartmentEntity> findDepartmentByName(@Param("name") String name);

}
