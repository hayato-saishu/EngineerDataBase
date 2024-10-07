package com.example.demo.service;

import com.example.demo.dto.EngineerDetailDto;
import com.example.demo.dto.EngineerListDto;
import com.example.demo.mapper.EngineerMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EngineerServiceTest {

    @InjectMocks
    EngineerService engineerService;

    @Mock
    EngineerMapper engineerMapper;

    public EngineerServiceTest() {
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

        when(engineerMapper.searchEngineers(null)).thenReturn(engineers);

        List<EngineerListDto> result = engineerService.searchEngineers(null, null, 0);

        assertEquals(2, result.size());
    }

    @Test
    public void testGetEngineerDetailById() {
        EngineerDetailDto engineerDetail = new EngineerDetailDto();
        engineerDetail.setEngineerName("John Doe");
        engineerDetail.setEngineerAge(30);
        engineerDetail.setEngineerAddress("123 Main St");
        engineerDetail.setEngineerPhoneNumber("123-456-7890");
        engineerDetail.setSkillLanguage("Java");
        engineerDetail.setSkillYearsOfExperience(5);
        engineerDetail.setProjectName("Project X");

        when(engineerMapper.selectEngineerDetailById(1)).thenReturn(engineerDetail);

        EngineerDetailDto result = engineerService.getEngineerDetailById(1);

        assertEquals("John Doe", result.getEngineerName());
        assertEquals(30, result.getEngineerAge());
    }
}
