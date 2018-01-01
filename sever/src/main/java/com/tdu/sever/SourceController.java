package com.tdu.sever;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

/**
 * TODO: detail description
 *
 * @author tangdu
 * @version $: SourceController.java, v 0.1 2018年01月2018/1/1日 下午4:45 tangdu Exp $
 * @name TODO: SourceController
 */
@Controller
public class SourceController {

//    @RequestMapping("/index")
//    @ResponseBody
//    public String login(){
//        return "index";
//    }

    @RequestMapping("/me")
    @ResponseBody
    public Principal login(Principal principal){
        return principal;
    }
}
