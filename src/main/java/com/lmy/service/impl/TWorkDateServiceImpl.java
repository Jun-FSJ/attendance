package com.lmy.service.impl;

import com.google.common.collect.Lists;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmy.dto.PageResult;
import com.lmy.entity.TWorkDate;
import com.lmy.mapper.TWorkDateMapper;
import com.lmy.service.TWorkDateService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author bug榛戞礊
 * @since 2020-06-17
 */
@Service
public class TWorkDateServiceImpl extends ServiceImpl<TWorkDateMapper, TWorkDate> implements TWorkDateService {


    /**
     * 分页查询所有的工作日
     *
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<TWorkDate> findPage(Integer page, Integer size) {

        Page<TWorkDate> datePage = new Page<>(page, size);
        baseMapper.selectPage(datePage, null);
        PageResult<TWorkDate> pageResult = new PageResult<>();

        pageResult.setCurrPage(page);
        pageResult.setPageSize(size);
        pageResult.setTotalPage(datePage.getPages());
        pageResult.setTotalCount(datePage.getTotal());
        pageResult.setList(datePage.getRecords());

        return pageResult;
    }

    @Override
    public int findOne(Date tWorkDate) {

        QueryWrapper<TWorkDate> wrapper = new QueryWrapper<>();
        wrapper.eq("work_date",tWorkDate);
        TWorkDate tworkDate = baseMapper.selectOne(wrapper);
        if(tworkDate!=null){
            return 0;
        }

        TWorkDate workDate = new TWorkDate();
        workDate.setWorkDate(tWorkDate);

        baseMapper.insert(workDate);


        return 1;
    }
}
