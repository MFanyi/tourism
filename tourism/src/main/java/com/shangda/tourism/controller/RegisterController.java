package com.shangda.tourism.controller;

import com.shangda.tourism.model.User;
import com.shangda.tourism.service.RegisterService;
import com.shangda.tourism.util.JSONUtil;
import com.shangda.tourism.util.TourismConstant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping(path = "user")
public class RegisterController implements TourismConstant {
    @Resource
    private RegisterService userService;

    @RequestMapping(path = "register", method = RequestMethod.POST)
    public String register(User user) {
        Map<String, Object> map = userService.register(user);
        if (map == null || map.isEmpty()) {
            return JSONUtil.getJSONString(0, "注册成功,我们已经向您的邮箱发送了一封邮件，请尽快激活");
        } else {
            return JSONUtil.getJSONString(1, (String) map.get("msg"));
        }
    }

    @RequestMapping(path = "activation", method = RequestMethod.GET)
    public String activation(int userId, String code) {
        int result = userService.activation(userId, code);
        if (result == ACTIVATION_REPEAT) {
            return JSONUtil.getJSONString(1, "重复激活");
        } else if (result == ACTIVATION_SUCCESS) {
            return JSONUtil.getJSONString(0, "激活成功");
        } else {
            return JSONUtil.getJSONString(1, "激活失败");
        }
    }
}
