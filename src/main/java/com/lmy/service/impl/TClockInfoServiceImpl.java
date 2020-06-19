package com.lmy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lmy.dto.PageResult;
import com.lmy.dto.TClockInfoDTO;
import com.lmy.entity.TClockInfo;
import com.lmy.mapper.TClockInfoMapper;
import com.lmy.service.TClockInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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


    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<TClockInfoDTO> findByPage(Integer page, Integer size) {
        if (page < 1) {
            page = 1;
        }
        // 设置分页参数
        Page<TClockInfo> pg = new Page<>(page, size);
        // 设置查询条件
        QueryWrapper<TClockInfo> wrapper = new QueryWrapper<>();
        // 查询
        log.info("考勤分页查询开始！");
        baseMapper.selectPage(pg, wrapper);
        log.info("考勤分页查询结束");
        // 判断打卡状态
        List<TClockInfo> list = pg.getRecords();
        List<TClockInfoDTO> infoDTOS = list.stream().map(c -> {
            TClockInfoDTO dto = new TClockInfoDTO();
            // 将TClockInfo的属性复制到DTO中
            BeanUtils.copyProperties(c, dto);
            // 获取上班打卡时间
            Date inTime = c.getClockInTime();
            if (inTime == null) {
                dto.setInStatus("旷工");
            } else {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(inTime);
                // 判断上班打卡状态
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                if (hour > 0 && hour < 9) {
                    dto.setInStatus("正常");
                } else if (hour >= 9 && hour <= 11) {
                    dto.setInStatus("迟到");
                } else {
                    dto.setInStatus("旷工");
                }
            }

            // 获取下班打卡时间
            Date offTime = c.getClockOffTime();
            if (offTime == null) {
                dto.setOffStatus("旷工");
            } else {
                Calendar offCalendar = Calendar.getInstance();
                offCalendar.setTime(offTime);
                int hourOff = offCalendar.get(Calendar.HOUR_OF_DAY);
                if (hourOff >= 18) {
                    dto.setOffStatus("正常");
                } else if (hourOff > 16 && hourOff < 18 ) {
                    dto.setOffStatus("早退");
                } else {
                    dto.setOffStatus("旷工");
                }
            }

            // 判断总体旷工逻辑
            if ((inTime == null && offTime == null) ||
                    (inTime != null && offTime == null) ||
                    (inTime == null && offTime != null)) {
                // 旷工
                dto.setOffStatus("旷工");
                dto.setInStatus("旷工");
            }
            return dto;
        }).collect(Collectors.toList());


        // 获取分页结果并组装返回接口
        PageResult<TClockInfoDTO> result = new PageResult<>();
        result.setCurrPage(page);
        result.setList(infoDTOS);
        result.setPageSize(size);
        result.setTotalCount(pg.getTotal());
        result.setTotalPage(pg.getPages());
        return result;
    }


    // 新增打卡记录
    @Override
    public String insertClock(String employeeNo) {
        String msg = "";
        // 获取当前时间
        Date nowDate = new Date();
        Calendar nowCalendar = Calendar.getInstance();
        // 获取当前小时
        int hour = nowCalendar.get(Calendar.HOUR_OF_DAY);
        // 尝试获取当天是否有打卡记录
        List<TClockInfo> todayClock = baseMapper.getTodayClock(employeeNo);
        TClockInfo clockInfo = new TClockInfo();
        clockInfo.setEmployeeNo(employeeNo);
        clockInfo.setClockDate(nowDate);

        if (hour < 16) {
            // 上班打卡
            if (todayClock.size() > 0) {
                // 当天已打卡
                msg = "【打卡】 已打卡，无需重复操作";
                return msg;
            }
            clockInfo.setClockInTime(nowDate);
            log.info("【打卡】 上班打卡开始");
            baseMapper.insert(clockInfo);
            log.info("【打卡】 上班打卡成功");
            msg = "【打卡】 打卡成功";
        }

        if (hour >= 16) {
            // 下班打卡
            if (todayClock.size() > 0) {
                clockInfo.setClockOffTime(nowDate);
                log.info("【打卡】 下班打卡开始");
                QueryWrapper<TClockInfo> wrapper = new QueryWrapper<>();
                wrapper.eq("employee_no", employeeNo);
                baseMapper.update(clockInfo, wrapper);
                log.info("【打卡】 下班打卡成功");
                msg = "【打卡】 打卡成功";
            } else {
                clockInfo.setClockOffTime(nowDate);
                log.info("【打卡】 下班打卡开始");
                baseMapper.insert(clockInfo);
                log.info("【打卡】 下班打卡成功");
                msg = "【打卡】 打卡成功";
            }
            return msg;
        }
        return msg;
    }

}
