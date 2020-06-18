package com.lmy.service;

import com.lmy.dto.PageResult;
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

    /**
     * 分页显示员工信息
     * @param page
     * @param size
     * @return
     */
    PageResult<TEmployee> findByPage(Integer page, Integer size);

    /**
     * 添加员工
     * @param employee
     * @return
     */
    int addAdmin(TEmployee employee);

    /**
     * 根据id查询员工信息
     * @param employeeId
     * @return
     */
    TEmployee showById(Integer employeeId);

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    int updateAdmin(TEmployee employee);

    /**
     * 删除员工信息
     * @param employeeId
     */
    void deleteAdmin(Integer employeeId);
}
