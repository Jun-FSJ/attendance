package com.lmy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *  前端控制器
 * @since 2020-06-17
 */
@Controller
public class TEmployeeController {

    @RequestMapping("/employeeInfo")
    public String showEmployeeInfo() {
        return "employeeInfo";
    }

}

