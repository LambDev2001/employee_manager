package com.youtube.project.manageemployee.controller;

import com.youtube.project.manageemployee.model.Achievement;
import com.youtube.project.manageemployee.services.AchievementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AchievementController {
    @Autowired
    public AchievementService achievementService;

    @PostMapping("/achievement")
    public ResponseEntity<String> addAchievement(@RequestBody Achievement achievement) {
            return achievementService.addAchievement(achievement);
    }

    @PostMapping("/addPictureAchievement")
    public ResponseEntity<Long> addPictureAchievement(@RequestParam MultipartFile file) throws SQLException, IOException {
        Long idPicture = achievementService.addPictureAchievement(file);
        return new ResponseEntity<>(idPicture, HttpStatus.OK);
    }

    @GetMapping("/achievement/{id}")
    public List<Achievement> getEmployeeAchievements(@PathVariable Long id){
       return achievementService.getAchievementByEmployeeId(id);
    }

}
