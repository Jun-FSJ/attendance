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
@ApiModel(value="TWorkDate对象", description="")
public class TWorkDate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "work_date_id", type = IdType.AUTO)
    private Integer workDateId;

    private Date workDate;


}
