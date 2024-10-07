package com.example.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineerDetailDtoTest {

    @Test
    public void testEngineerDetailDto() {
        EngineerDetailDto dto = new EngineerDetailDto();
        dto.setEngineerName("John Doe");
        dto.setEngineerAge(30);
        dto.setEngineerAddress("123 Main St");
        dto.setEngineerPhoneNumber("123-456-7890");
        dto.setSkillLanguage("Java");
        dto.setSkillYearsOfExperience(5);
        dto.setProjectName("Project X");

        assertEquals("John Doe", dto.getEngineerName());
        assertEquals(30, dto.getEngineerAge());
        assertEquals("123 Main St", dto.getEngineerAddress());
        assertEquals("123-456-7890", dto.getEngineerPhoneNumber());
        assertEquals("Java", dto.getSkillLanguage());
        assertEquals(5, dto.getSkillYearsOfExperience());
        assertEquals("Project X", dto.getProjectName());
    }
}
