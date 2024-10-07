package com.example.demo.controller;

import com.example.demo.dto.EngineerDetailDto;
import com.example.demo.dto.EngineerListDto;
import com.example.demo.service.EngineerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EngineerControllerTest {

    @InjectMocks
    EngineerController engineerController;

    @Mock
    EngineerService engineerService;

    public EngineerControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSearchEngineers() {
        EngineerListDto engineer1 = new EngineerListDto();
        engineer1.setId(1);
        engineer1.setName("John Doe");
        engineer1.setAge(30);
        engineer1.setLanguage("Java");
        engineer1.setYearsOfExperience(5);

        EngineerListDto engineer2 = new EngineerListDto();
        engineer2.setId(2);
        engineer2.setName("Jane Smith");
        engineer2.setAge(28);
        engineer2.setLanguage("Python");
        engineer2.setYearsOfExperience(3);

        List<EngineerListDto> engineers = Arrays.asList(engineer1, engineer2);

        when(engineerService.searchEngineers("John", "Java", 5)).thenReturn(engineers);

        ResponseEntity<List<EngineerListDto>> response = engineerController.searchEngineers("John", "Java", 5);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(2, Objects.requireNonNull(response.getBody()).size());
    }

    @Test
    public void testGetEngineerById() {
        EngineerDetailDto engineerDetail = new EngineerDetailDto();
        engineerDetail.setEngineerName("John Doe");
        engineerDetail.setEngineerAge(30);
        engineerDetail.setEngineerAddress("123 Main St");
        engineerDetail.setEngineerPhoneNumber("123-456-7890");
        engineerDetail.setSkillLanguage("Java");
        engineerDetail.setSkillYearsOfExperience(5);
        engineerDetail.setProjectName("Project X");
        engineerDetail.setProjectStartDate(new Date());
        engineerDetail.setProjectEndDate(new Date());

        when(engineerService.getEngineerDetailById(1)).thenReturn(engineerDetail);

        EngineerDetailDto response = engineerController.getEngineerById(1);

        assertEquals("John Doe", response.getEngineerName());
        assertEquals(30, response.getEngineerAge());
    }
}
