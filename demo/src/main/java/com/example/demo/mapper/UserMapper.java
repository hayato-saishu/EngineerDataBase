package com.example.demo.mapper;

import com.example.demo.model.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.Map;

@Mapper
public interface UserMapper {

    User selectUserById(int id);

    User login(Map<String, String> params);
}
