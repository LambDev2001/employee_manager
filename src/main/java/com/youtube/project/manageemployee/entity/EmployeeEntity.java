package com.youtube.project.manageemployee.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Lob
    private Blob picture;

    private String email;
    private String address;
    private String password;

    @OneToMany(mappedBy = "employee")
    private List<AchievementsEntity> achievements;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_at")
    private Date update_at;

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.update_at = new Date();
    }
}
