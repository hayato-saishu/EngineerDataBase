package com.example.demo.service;

import com.example.demo.dto.EngineerDetailDto;
import com.example.demo.dto.EngineerListDto;
import com.example.demo.mapper.EngineerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EngineerService {

    @Autowired
    EngineerMapper mapper;

    public List<EngineerListDto> searchEngineers(String name, String language, Integer yearsOfExperience) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("language", language);
        params.put("yearsOfExperience", yearsOfExperience);
        return mapper.searchEngineers(params);
    }

    public EngineerDetailDto getEngineerDetailById(int id) {
        return mapper.selectEngineerDetailById(id);
    }
}
