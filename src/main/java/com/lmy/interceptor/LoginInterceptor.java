package com.lmy.interceptor;
/**
 * @Project blog
 * @Package com.lmy.interceptor
 * @author lmy
 * @date 2020/3/16 21:23
 * @version V1.0
 */


import com.lmy.entity.TEmployee;
import com.lmy.utils.CookieUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author lmy
 * @ClassName LoginInterceptor
 * @Description 登录拦截器
 * @date 2020/4/19 21:23
 **/
@Service
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        TEmployee employee = (TEmployee) request.getSession().getAttribute("employee");
        if (employee == null) {
            response.sendRedirect("/login");
            return false;
        }else {
            return true;
        }

    }
}
