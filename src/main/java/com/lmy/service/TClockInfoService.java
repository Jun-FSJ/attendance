package com.lmy.service;

import com.lmy.dto.PageResult;
import com.lmy.dto.TClockInfoDTO;
import com.lmy.entity.TClockInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @since 2020-06-17
 */
public interface TClockInfoService extends IService<TClockInfo> {

    PageResult<TClockInfoDTO> findByPage(Integer page, Integer size);

    String insertClock(String employeeNo);
}
