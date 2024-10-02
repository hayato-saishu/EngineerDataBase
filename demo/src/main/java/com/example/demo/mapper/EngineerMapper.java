package com.example.demo.mapper;

import com.example.demo.dto.EngineerDetailDto;
import com.example.demo.dto.EngineerListDto;
import com.example.demo.model.Engineer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EngineerMapper {

    List<Engineer> searchEngineers(Map<String, Object> params);

    EngineerDetailDto selectEngineerDetailById(int id);
}
