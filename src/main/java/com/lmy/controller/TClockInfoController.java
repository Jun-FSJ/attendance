package com.lmy.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.lmy.dto.PageResult;
import com.lmy.dto.TClockInfoDTO;
import com.lmy.entity.TClockInfo;
import com.lmy.entity.TEmployee;
import com.lmy.service.TClockInfoService;
import com.lmy.utils.CookieUtils;
import com.lmy.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Type;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * 前端控制器
 * @since 2020-06-17
 */
@Slf4j
@Controller
public class TClockInfoController {

    @Autowired
    private TClockInfoService tClockInfoServiceImpl;


    /**
     * 分页显示考勤表
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping("/showAllAttendance")
    public String showAllAttendance(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "6") Integer size,
                                    Model model) {

        PageResult<TClockInfoDTO> tClockInfoPage = tClockInfoServiceImpl.findByPage(page, size);
        model.addAttribute("clockInfoList", tClockInfoPage.getList());
        model.addAttribute("currPage", tClockInfoPage.getCurrPage());
        model.addAttribute("totalPage", tClockInfoPage.getTotalPage());
        model.addAttribute("totalCount", tClockInfoPage.getTotalCount());
        model.addAttribute("pageSize", tClockInfoPage.getPageSize());

        return "showAllAttendance";
    }

    /**
     * 上班打卡
     * @param model
     * @return
     */
    @RequestMapping("/clock")
    public String inclock(Model model, HttpServletRequest request) {
        String msg = "";
        String token = CookieUtils.getCookieValue(request, "TOKEN");
        TEmployee employee = (TEmployee) request.getSession().getAttribute("employee");
        if (token == null || employee == null) {
            log.error("【打卡】 获取不到用户信息");
            msg = "获取不到员工信息";
            return "redirect:/login";
        }
        msg = tClockInfoServiceImpl.insertClock(employee.getEmployeeNo());
        model.addAttribute("msg", msg);
        return "index";
    }


}

