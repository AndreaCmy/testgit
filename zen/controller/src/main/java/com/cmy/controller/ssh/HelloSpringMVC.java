package com.cmy.controller.ssh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.misc.Contended;

/**
 * Created by mengyingc on 2017/3/23.
 */
@Controller
public class HelloSpringMVC {

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello spring mvc");
        return "success";

    }
}
