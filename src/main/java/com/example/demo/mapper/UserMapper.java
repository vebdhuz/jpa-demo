package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;

import com.example.demo.provider.UserSql;
import com.example.demo.entity.User;

import io.lettuce.core.dynamic.annotation.Param;


@Mapper
public interface UserMapper extends tk.mybatis.mapper.common.Mapper<User> {
  
  @SelectProvider(type=UserSql.class, method="getUser")
  User getUserById(@Param("id") long id);
}
