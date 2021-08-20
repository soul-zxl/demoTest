package com.example.demotest.mapper;

import com.example.demotest.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {

List<Student> select();


}
