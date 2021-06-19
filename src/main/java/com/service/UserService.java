package com.service;

import com.vo.ResultVo;
import org.springframework.stereotype.Service;

/**
 * @Author: wangxm
 * @Date: 2021/6/19 18:37
 */
@Service
public interface UserService {

    public ResultVo getAllUsers();

}
