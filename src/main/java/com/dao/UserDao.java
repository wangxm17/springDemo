package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:34
 */

@Mapper
public interface UserDao {

    List<User> getAllUsers();

}
