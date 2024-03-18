package com.youtube.project.manageemployee.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Salary {
    private Long id;
    private Long employeeId;
    private BigDecimal salaryAmount;
    private Date startDate;
    private Date endDate;
}
