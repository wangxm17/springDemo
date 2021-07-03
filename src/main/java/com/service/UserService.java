package com.service;

import com.domain.User;
import com.vo.ResultVo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:37
 */
@Service
public interface UserService {

    ResultVo getAllUsers();

    List<User> page();

}
