package com.lmy.controller;


import com.lmy.dto.PageResult;
import com.lmy.entity.TClockInfo;
import com.lmy.entity.TEmployee;
import com.lmy.service.TEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *  前端控制器
 * @since 2020-06-17
 */
@Controller
public class TEmployeeController {

    @Autowired
    private TEmployeeService tEmployeeServiceImpl;

    @RequestMapping("/employeeInfo")
    public String showEmployeeInfo() {
        return "employeeInfo";
    }


    @RequestMapping("/showEmployee")
    public String showAllAttendance(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "size", defaultValue = "6") Integer size,
                                    Model model) {

        PageResult<TEmployee> tClockInfoPage = tEmployeeServiceImpl.findByPage(page, size);
        model.addAttribute("EmployeeInfoList", tClockInfoPage.getList());
        model.addAttribute("currPage", tClockInfoPage.getCurrPage());
        model.addAttribute("totalPage", tClockInfoPage.getTotalPage());
        model.addAttribute("totalCount", tClockInfoPage.getTotalCount());
        model.addAttribute("pageSize", tClockInfoPage.getPageSize());

        return "showEmployee";
    }
}

