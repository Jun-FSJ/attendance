package com.lmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmy.dto.PageResult;
import com.lmy.entity.TClockInfo;
import com.lmy.mapper.TClockInfoMapper;
import com.lmy.service.TClockInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bug榛戞礊
 * @since 2020-06-17
 */
@Slf4j
@Service
public class TClockInfoServiceImpl extends ServiceImpl<TClockInfoMapper, TClockInfo> implements TClockInfoService {

    @Override
    public PageResult<TClockInfo> findByPage(Integer page, Integer size) {
        if (page < 1) {
            page = 1;
        }
        // 设置分页参数
        Page<TClockInfo> pg = new Page<>(page, size);
        // 设置查询天剑
        QueryWrapper<TClockInfo> wrapper = new QueryWrapper<>();
        // 查询
        baseMapper.selectPage(pg, wrapper);
        // 获取分页结果并组装返回接口
        log.info("考勤分页查询开始！");
        PageResult<TClockInfo> result = new PageResult<>();
        result.setCurrPage(page);
        result.setList(pg.getRecords());
        result.setPageSize(size);
        result.setTotalCount(pg.getTotal());
        result.setTotalPage(pg.getPages());
        log.info("考勤分页查询结束");
        return result;
    }
}
