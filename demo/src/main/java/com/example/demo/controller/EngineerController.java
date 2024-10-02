package com.example.demo.controller;

import com.example.demo.dto.EngineerDetailDto;
import com.example.demo.dto.EngineerListDto;
import com.example.demo.service.EngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EngineerController {

    @Autowired
    EngineerService service;

    @GetMapping("/engineer/search")
    public ResponseEntity<List<EngineerListDto>> searchEngineers(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String language,
            @RequestParam(required = false) int yearsOfExperience) {

        List<EngineerListDto> engineers = service.searchEngineers(name, language, yearsOfExperience);
        return ResponseEntity.ok(engineers);
    }

    @GetMapping("/engineer/detail/{id}")
    public EngineerDetailDto getEngineerById(@PathVariable int id) {
        return service.getEngineerDetailById(id);
    }

}
