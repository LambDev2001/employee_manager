package com.youtube.project.manageemployee.services;

import com.youtube.project.manageemployee.entity.AchievementsEntity;
import com.youtube.project.manageemployee.model.Achievement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface AchievementImplementService {
    List<AchievementsEntity> findByEmployeeId(Long id);

    ResponseEntity<String> addAchievement(Achievement achievement);

    List<Achievement> getAchievementByEmployeeId(Long id);

    Long addPictureAchievement(MultipartFile file) throws IOException, SQLException;
}
