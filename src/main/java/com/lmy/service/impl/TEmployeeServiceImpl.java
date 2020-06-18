package com.lmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmy.dto.PageResult;
import com.lmy.entity.TClockInfo;
import com.lmy.entity.TEmployee;
import com.lmy.mapper.TEmployeeMapper;
import com.lmy.service.TEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.xml.transform.Templates;
import java.awt.*;
import java.util.List;

/**
 *
 * @since 2020-06-17
 */
@Slf4j
@Service
public class TEmployeeServiceImpl extends ServiceImpl<TEmployeeMapper, TEmployee> implements TEmployeeService {

    /**
     * 查询用户名和密码
     * @param username
     * @param pwd
     */
    @Override
    public TEmployee findUserAndPwd(String username, String pwd) {

        QueryWrapper<TEmployee> wrapper = new QueryWrapper<>();

        wrapper.eq("login_name",username);
        wrapper.eq("pass_word",pwd);

        TEmployee tEmployee = baseMapper.selectOne(wrapper);

        return tEmployee;
    }

    /**
     * 分页显示员工信息
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<TEmployee> findByPage(Integer page, Integer size) {
        if (page < 1){
           page = 1;
        }
        // 设置分页参数
        Page<TEmployee> pg = new Page<>(page, size);
        // 设置查询条件
        QueryWrapper<TEmployee> wrapper = new QueryWrapper<>();
        // 查询
        baseMapper.selectPage(pg, wrapper);
        // 获取分页结果并组装返回接口
        log.info("考勤分页查询开始！");
        PageResult<TEmployee> result = new PageResult<>();
        result.setCurrPage(page);
        result.setTotalCount(pg.getTotal());
        result.setPageSize(size);
        result.setTotalPage(pg.getPages());
        result.setList(pg.getRecords());
        log.info("考勤分页查询结束");
        return result;
    }

    /**
     * 添加员工
     * @param employee
     * @return
     */
    @Override
    public int addAdmin(TEmployee employee) {
        if (check(employee)) {
            return this.baseMapper.insert(employee);
        }
        return 0;
    }


    /**
     * 校验员工账号和编号是否重复
     * @param employee
     * @return
     */
    private boolean check(TEmployee employee) {
        QueryWrapper<TEmployee> wrapper = new QueryWrapper<>();

        List<TEmployee> tEmployees = this.baseMapper.selectList(wrapper);

        for (TEmployee employee1 : tEmployees) {
            if (StringUtils.equals(employee1.getEmployeeNo(), employee.getEmployeeNo()) || StringUtils.equals(employee1.getLoginName(), employee.getLoginName())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 根据id查询员工信息
     * @param employeeId
     * @return
     */
    public TEmployee showById(Integer employeeId){
        return this.baseMapper.selectById(employeeId);
    }

    /**
     * 修改员工信息
     * @param employee
     * @return
     */
    @Override
    public int updateAdmin(TEmployee employee) {
        return this.baseMapper.updateById(employee);
    }

    /**
     * 删除员工信息
     * @param employeeId
     */
    @Override
    public void deleteAdmin(Integer employeeId) {
        this.baseMapper.deleteById(employeeId);
    }
}
