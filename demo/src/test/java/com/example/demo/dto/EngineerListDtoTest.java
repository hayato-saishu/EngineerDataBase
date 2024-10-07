package com.example.demo.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EngineerListDtoTest {

    @Test
    public void testEngineerListDto() {
        EngineerListDto dto = new EngineerListDto();
        dto.setId(1);
        dto.setName("John Doe");
        dto.setAge(30);
        dto.setLanguage("Java");
        dto.setYearsOfExperience(5);

        assertEquals(1, dto.getId());
        assertEquals("John Doe", dto.getName());
        assertEquals(30, dto.getAge());
        assertEquals("Java", dto.getLanguage());
        assertEquals(5, dto.getYearsOfExperience());
    }
}
