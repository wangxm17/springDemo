package com.service;

import com.domain.Example.UserExample;
import com.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:37
 */
@Service
public interface UserService {

    /**
     * 分页查询
     */
    List<User> page(UserExample example);

    /**
     * 新增
     */
    int insert(User record);

    /**
     * 删除
     */
    int deleteByPrimaryKey(String id);

    /**
     * 修改
     */
    int updateByPrimaryKey(User record);

    /**
     * id查询
     */
    User selectByPrimaryKey(String id);

}
