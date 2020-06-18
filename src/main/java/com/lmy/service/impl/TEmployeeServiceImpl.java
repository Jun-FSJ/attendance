package com.lmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.util.StringUtil;
import com.lmy.entity.TEmployee;
import com.lmy.mapper.TEmployeeMapper;
import com.lmy.service.TEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @since 2020-06-17
 */
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
}
