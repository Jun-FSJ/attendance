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

/**
 *
 * @since 2020-06-17
 */
@Slf4j
@Service
public class TEmployeeServiceImpl extends ServiceImpl<TEmployeeMapper, TEmployee> implements TEmployeeService {

    @Override
    public TEmployee findUserAndPwd(String username, String pwd) {

        QueryWrapper<TEmployee> wrapper = new QueryWrapper<>();

        wrapper.eq("login_name",username);
        wrapper.eq("pass_word",pwd);

        TEmployee tEmployee = baseMapper.selectOne(wrapper);

        return tEmployee;
    }

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

}
