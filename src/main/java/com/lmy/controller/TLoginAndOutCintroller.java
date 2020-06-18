package com.lmy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lmy.entity.TEmployee;
import com.lmy.service.TEmployeeService;
import com.lmy.utils.CookieUtils;
import com.lmy.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @author Shinelon
 */
@Controller
public class TLoginAndOutCintroller {


    @Autowired
    private TEmployeeService tEmployeeService;

    /**
     * 显示主页面
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    /**
     * 显示登录功能
     * @return
     */
    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    /**
     * 登录校验
     * @param adminNumber
     * @param adminPwd
     * @param response
     * @param request
     * @return
     * @throws IOException
     * @throws ServletException
     */
    @PostMapping("/loginshow")
    public String login(String adminNumber,
                        String adminPwd,
                        HttpServletResponse response,
                        HttpServletRequest request) throws IOException, ServletException {
        TEmployee userAndPwd = tEmployeeService.findUserAndPwd(adminNumber, adminPwd);
        userAndPwd.setPassWord(null);
        if (userAndPwd != null) {
            request.getSession().setAttribute("employee", userAndPwd);
            String token = UUID.randomUUID().toString();
            CookieUtils.newBuilder(response).build("TOKEN", JsonUtils.toString(userAndPwd));
            return "redirect:/";
        }

        request.setAttribute("error", "用户名或密码错误");
        return "login";

    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest request, HttpServletResponse response) {
        request.getSession().removeAttribute("employee");
        // 清除Cookie
        Cookie cookie = new Cookie("TOKEN","");
        cookie.setMaxAge(0); //设置立即删除
        response.addCookie(cookie);
        return "redirect:/login";
    }

}
