package com.lmy.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @since 2020-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TClockInfo对象", description="")
public class TClockInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "clock_id", type = IdType.AUTO)
    private Integer clockId;

    private String employeeNo;

    private Date clockInTime;

    private Date clockOffTime;

    private Date clockDate;


}
