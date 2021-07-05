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
    List<User> page(UserExample userExample);

    /**
     * 新增
     */
    int insert(User user);

    /**
     * 删除
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 修改
     */
    int updateByPrimaryKey(User record);

    /**
     * id查询
     */
    User selectByPrimaryKey(Integer id);

}
