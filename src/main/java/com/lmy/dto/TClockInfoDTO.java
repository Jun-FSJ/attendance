package com.lmy.dto;
/**
 * @Project attendance
 * @Package com.lmy.dto
 * @author Administrator
 * @date 2020/6/18 19:41
 * @version V1.0
 */

import com.lmy.entity.TClockInfo;
import lombok.Data;

/**
 * @author Administrator
 * @ClassName TClockInfoDTO
 * @Description 考勤信息返回接扣
 * @date 2020/6/18 19:41
 **/
@Data
public class TClockInfoDTO extends TClockInfo {
    // 上班打卡状态
    private String inStatus;
    // 下班打卡状态
    private String offStatus;

}
