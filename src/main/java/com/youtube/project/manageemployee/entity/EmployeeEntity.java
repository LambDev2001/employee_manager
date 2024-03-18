package com.youtube.project.manageemployee.entity;

import com.youtube.project.manageemployee.utils.EnumGender;
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

    private String last_name;
    private String first_name;
    private Date date_of_birth;
    private String password;
    private String email;
    private String address;

    @Lob
    private Blob picture;

    @Enumerated(EnumType.STRING)
    private EnumGender gender;
    private String number_phone;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;

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
