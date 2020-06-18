package com.lmy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmy.entity.TEmployee;
import com.lmy.service.TEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Shinelon
 */
@Controller
public class TLoginAndOutCintroller {


    @Autowired
    private TEmployeeService tEmployeeService;


    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }


    @PostMapping("/loginshow")
    public String Login(String adminNumber,
                        String adminPwd,
                        HttpServletResponse response,
                        HttpServletRequest request) throws IOException, ServletException {
        TEmployee userAndPwd = tEmployeeService.findUserAndPwd(adminNumber, adminPwd);

        if (userAndPwd != null) {
            request.getSession().setAttribute("employee", userAndPwd);
            return "index";
        }

        request.setAttribute("error", "用户名或密码错误");
        return "login";

    }
}
