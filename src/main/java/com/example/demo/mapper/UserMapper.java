package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.entity.User;

import io.lettuce.core.dynamic.annotation.Param;


@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
  
  @Select("select * from user where id = #{id}")
  User getUserById(@Param("id") long id);
}
