package com.example.demo.provider;

import org.apache.ibatis.jdbc.SQL;

import io.lettuce.core.dynamic.annotation.Param;

public class UserSql {
  public String getUser(@Param("id") long id) {
    System.out.printf("id:%d\n", id);
    return new SQL() {
      {
        SELECT("user_name,age");
        FROM("user");
        WHERE("id=#{id}");
      }
    }.toString();
  }
}
