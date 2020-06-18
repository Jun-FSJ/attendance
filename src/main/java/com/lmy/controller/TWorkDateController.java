package com.lmy.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmy.dto.PageResult;
import com.lmy.entity.TWorkDate;
import com.lmy.service.TWorkDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 前端控制器
 *
 * @since 2020-06-17
 */
@Controller
public class TWorkDateController {


    @Autowired
    private TWorkDateService workDateService;

    /**
     * 分页查询所有工作日
     *
     * @param page
     * @param size
     * @param model
     * @return
     */
    @RequestMapping("/selectWorkDay")
    public String selectWorkDay(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                @RequestParam(value = "size", defaultValue = "6") Integer size,
                                Model model) {

        PageResult<TWorkDate> workDateList = workDateService.findPage(page, size);

        model.addAttribute("workDateList", workDateList.getList());
        model.addAttribute("currPage", workDateList.getCurrPage());
        model.addAttribute("pageSize", workDateList.getPageSize());
        model.addAttribute("totalCount", workDateList.getTotalCount());
        model.addAttribute("totalPage", workDateList.getTotalPage());

        return "workDay";

    }

    /**
     * 删除工作日
     * @param workDateId
     * @return
     */
    @RequestMapping("deleteWokeDay")
    public String deleteWorkDay(Integer workDateId) {
        workDateService.removeById(workDateId);
        return "redirect:selectWorkDay";
    }

    /**
     * 跳转到添加页面
     * @return
     */
    @GetMapping("toAddWokeDay")
    public String toAddWokeDay(){
        return "addWorkDay";
    }

    /**
     * 新增工作日
     * @return
     */
    @PostMapping("addWokeDay")
    public String addWokeDay(Date workDate) {


        int i = workDateService.findOne(workDate);

        if (i == 0) {
            return "redirect:/toAddWokeDay";
        }
        return "redirect:selectWorkDay";
    }

}

