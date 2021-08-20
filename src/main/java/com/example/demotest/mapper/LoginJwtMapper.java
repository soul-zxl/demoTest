package com.example.demotest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demotest.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginJwtMapper extends BaseMapper<User> {

}
