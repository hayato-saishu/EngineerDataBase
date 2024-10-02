package com.example.demo.mapper;

import com.example.demo.dto.EngineerDetailDto;
import com.example.demo.dto.EngineerListDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

@Mapper
public interface EngineerMapper {

    List<EngineerListDto> searchEngineers(Map<String, Object> params);

    EngineerDetailDto selectEngineerDetailById(int id);
}
