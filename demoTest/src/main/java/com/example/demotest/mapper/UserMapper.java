package com.example.demotest.mapper;

import com.example.demotest.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {


    List<User> select();

    User selectById(int id);

    int  insert(User user);

    int update(User user);

    int delete(int id);

    int insert2(User user);


    int update2(Map map);

    User select3(Map map);

    List<User>selectLike(String vlues);






}
