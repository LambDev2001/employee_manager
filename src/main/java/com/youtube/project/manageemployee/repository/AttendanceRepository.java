package com.youtube.project.manageemployee.repository;

import com.youtube.project.manageemployee.entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity, Long> {
}
