package com.example.demotest.mapper;

import com.example.demotest.entity.Student;
import com.example.demotest.vo.VO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

List<Student> select();


   List<Student> selectif(Map map);

   List<VO>list111111();

}
