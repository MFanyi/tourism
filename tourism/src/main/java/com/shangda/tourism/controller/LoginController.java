package com.shangda.tourism.controller;

import com.shangda.tourism.model.User;
import com.shangda.tourism.service.LoginService;
import com.shangda.tourism.util.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "user")
public class LoginController {
    @Resource
    private LoginService loginService;

    @RequestMapping(path = "login", method = RequestMethod.POST)
    public String login(String username, String password, String remember,
                        HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = loginService.login(username, password, request, response, remember);
        return JSONUtil.getJSONString(map);
    }

    @RequestMapping(path = "loginUser", method = RequestMethod.GET)
    public String loginUser(HttpServletRequest request) {
        Map<String, Object> map = loginService.loginUser(request);
        if(!map.isEmpty()){
            return JSONUtil.getJSONString(0, "获取到用户登录数据",map);
        }else {
            return JSONUtil.getJSONString(1,"没有获取到用户数据");
        }
    }

    @RequestMapping(path = "loginOut",method = RequestMethod.GET)
    public String loginOut(HttpServletRequest request){
        Map<String,Object> map = loginService.loginOut(request);
        return JSONUtil.getJSONString(map);
    }
}
