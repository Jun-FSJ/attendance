package com.lmy.dto;
/**
 * @Project attendance
 * @Package com.lmy.dto
 * @author Administrator
 * @date 2020/6/18 8:30
 * @version V1.0
 */

import lombok.Data;

import java.util.List;

/**
 * @author Administrator
 * @ClassName PageResult
 * @Description 分页返回接口
 * @date 2020/6/18 8:30
 **/
@Data
public class PageResult<E> {
    // 当前页数
    private Integer currPage;
    // 总页数
    private Long totalPage;
    // 总条数
    private Long totalCount;
    // 每页显示条数
    private Integer pageSize;
    // 当前页数据
    private List<E> list;

}
