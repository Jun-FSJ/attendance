package com.lmy.controller;


import com.lmy.dto.PageResult;
import com.lmy.entity.TClockInfo;
import com.lmy.service.TClockInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * 前端控制器
 * @since 2020-06-17
 */
@Controller
public class TClockInfoController {

    @Autowired
    private TClockInfoService tClockInfoServiceImpl;


    // 分页显示考勤表
    @RequestMapping("/showAllAttendance")
    public String showAllAttendance(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "6") Integer size,
                                    Model model) {

        PageResult<TClockInfo> tClockInfoPage = tClockInfoServiceImpl.findByPage(page, size);
        model.addAttribute("clockInfoList", tClockInfoPage.getList());
        model.addAttribute("currPage", tClockInfoPage.getCurrPage());
        model.addAttribute("totalPage", tClockInfoPage.getTotalPage());
        model.addAttribute("totalCount", tClockInfoPage.getTotalCount());
        model.addAttribute("pageSize", tClockInfoPage.getPageSize());

        return "showAllAttendance";
    }

}

