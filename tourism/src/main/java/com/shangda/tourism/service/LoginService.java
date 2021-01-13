package com.shangda.tourism.service;

import com.shangda.tourism.dao.UserDao;
import com.shangda.tourism.model.User;
import com.shangda.tourism.util.TourismUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Resource
    private UserDao userDao;

    public Map<String, Object> login(String username, String password,
                                     HttpServletRequest request, HttpServletResponse response,
                                     Boolean remember) {
        HashMap<String, Object> map = new HashMap<>();

        //验证传入数据
        if (StringUtils.isBlank(username)) {
            map.put("code", 1);
            map.put("msg", "用户名不能为空");
            return map;
        } else if (StringUtils.isBlank(password)) {
            map.put("code", 1);
            map.put("msg", "密码不能为空");
            return map;
        }

        //验证用户信息
        User user = userDao.selectByUsername(username);
        if (user == null) {
            map.put("code", 1);
            map.put("msg", "用户名不存在");
            return map;
        }
        if (user.getStatus() != 1) {
            map.put("code", 1);
            map.put("msg", "账号未激活");
            return map;
        }
        password = TourismUtil.md5(password + user.getSalt());
        if (!user.getPassword().equals(password)) {
            map.put("code", 1);
            map.put("msg", "密码错误");
            return map;
        }
        if (remember.equals(true)) {
            Cookie cookie = new Cookie("ticket", user.getActivationCode());
            cookie.setMaxAge(3 * 24 * 60 * 60);
            response.addCookie(cookie);
        }
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        map.put("code", 0);
        map.put("msg", "登陆成功");
        return map;
    }

    public Map<String,Object> loginUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        Map<String,Object> map = new HashMap<>();
        if(user != null){
            map.put("userName",user.getName());
            map.put("userImg",user.getHeaderUrl());
        }
        return map;
    }
}
