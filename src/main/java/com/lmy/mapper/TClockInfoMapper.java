package com.lmy.mapper;

import com.lmy.entity.TClockInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @since 2020-06-17
 */
public interface TClockInfoMapper extends BaseMapper<TClockInfo> {

    @Select("select * from t_clock_info where clock_date >= date(now()) and clock_date < DATE_ADD(date(now()),INTERVAL 1 DAY) and employee_no = #{employeeNo}")
    List<TClockInfo> getTodayClock(@Param("employeeNo") String employeeNo);

}
