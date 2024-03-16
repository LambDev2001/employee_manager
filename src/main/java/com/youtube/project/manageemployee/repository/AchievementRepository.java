package com.youtube.project.manageemployee.repository;

import com.youtube.project.manageemployee.entity.AchievementsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AchievementRepository extends JpaRepository<AchievementsEntity, Long> {

    @Query("select a from AchievementsEntity a where a.employee.id = :employeeId")
    List<AchievementsEntity> findByEmployeeId(@Param("employeeId") Long employeeId);
}
