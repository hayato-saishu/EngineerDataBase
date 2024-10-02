package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class EngineersProjectsParticipation {
    private int id;

    private int engineerId;

    private int projectId;

    private Date startDate;

    private Date endDate;
}
