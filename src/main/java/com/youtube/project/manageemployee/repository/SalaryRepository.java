package com.youtube.project.manageemployee.repository;

import com.youtube.project.manageemployee.entity.SalaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryRepository extends JpaRepository<SalaryEntity, Long> {
}
