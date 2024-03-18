package com.youtube.project.manageemployee.services;

import com.youtube.project.manageemployee.entity.AchievementsEntity;
import com.youtube.project.manageemployee.model.Achievement;
import com.youtube.project.manageemployee.repository.AchievementRepository;
import com.youtube.project.manageemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AchievementService implements AchievementImpService {
    @Autowired
    public AchievementRepository achievementRepository;

    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<AchievementsEntity> findByEmployeeId(Long id) {
        return achievementRepository.findByEmployeeId(id);
    }

    @Override
    public ResponseEntity<String> addAchievement(Achievement achievement) {
        Optional<AchievementsEntity> optionalAchievement = achievementRepository.findById(achievement.getId());
        if (optionalAchievement.isPresent()) {
            AchievementsEntity exitAchievement = optionalAchievement.get();

            exitAchievement.setName(achievement.getName());

//            EmployeeEntity employee = employeeRepository.findById(achievement.getId_employee()).orElse(null);
//            if (employee == null) {
//                return new ResponseEntity<>("Employee not fount", HttpStatus.NOT_FOUND);
//            }

//            exitAchievement.setEmployee(employee);

            achievementRepository.save(exitAchievement);
            return new ResponseEntity<>("Add achievement successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Achievement with id: " + achievement.getId() + " not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Long addPictureAchievement(MultipartFile file) throws IOException, SQLException {
        AchievementsEntity newAchievement = new AchievementsEntity();

        Blob blobPicture = new javax.sql.rowset.serial.SerialBlob(file.getBytes());
        newAchievement.setPicture(blobPicture);
        AchievementsEntity achievement = achievementRepository.save(newAchievement);
        return achievement.getId();
    }

    @Override
    public List<Achievement> getAchievementByEmployeeId(Long id) {
        System.out.println("id:" + id);
        List<AchievementsEntity> achievements = achievementRepository.findByEmployeeId(id);

        return achievements.stream()
                .map(achievementEntity -> {
                    Achievement achievement = new Achievement();
                    achievement.setId(achievementEntity.getId());
                    achievement.setName(achievementEntity.getName());
                    return achievement;
                })
                .collect(Collectors.toList());
    }

}
