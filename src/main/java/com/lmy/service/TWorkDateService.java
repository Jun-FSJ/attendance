package com.lmy.service;

import com.lmy.dto.PageResult;
import com.lmy.entity.TWorkDate;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * @since 2020-06-17
 */
public interface TWorkDateService extends IService<TWorkDate> {

    PageResult<TWorkDate> findPage(Integer page, Integer size);

    int findOne(Date tWorkDate);
}
