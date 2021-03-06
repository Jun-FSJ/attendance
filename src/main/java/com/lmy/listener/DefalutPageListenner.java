package com.lmy.listener;/********************************************************************
 /**
 * @Project: sroa
 * @Package com.ryan.sroa.listener
 * @author ryan
 * @date 2019/3/11 21:59
 * @Copyright: 2019 www.ryan.com Inc. All rights reserved.
 * @version V1.0
 */

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author ryan
 * @ClassName DefalutPageListenner
 * @Description 默认访问页面监听器
 * @date 2019/3/11
 */
@Component
public class DefalutPageListenner implements CommandLineRunner {
    private static String START_COMMAND = "cmd /c start http://localhost:8888/login";
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("欢迎光临考勤管理系统！");
        Runtime.getRuntime().exec(START_COMMAND);
    }
}