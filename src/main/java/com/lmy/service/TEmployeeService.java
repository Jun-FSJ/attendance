package com.lmy.service;

import com.lmy.entity.TEmployee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @since 2020-06-17
 */
public interface TEmployeeService extends IService<TEmployee> {

    /**
     * 查询用户名和密码
     * @param username
     * @param pwd
     */
    TEmployee findUserAndPwd(String username,String pwd);

}
