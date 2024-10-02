package com.example.demo.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EngineerDetailDto {
    private String engineerName;

    private int engineerAge;

    private String engineerAddress;

    private String engineerPhoneNumber;

    private String skillLanguage;

    private int skillYearsOfExperience;

    private String projectName;

    private Date projectStartDate;

    private Date projectEndDate;
}
