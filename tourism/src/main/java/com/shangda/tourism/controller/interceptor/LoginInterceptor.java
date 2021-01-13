package com.shangda.tourism.controller.interceptor;

import com.shangda.tourism.dao.UserDao;
import com.shangda.tourism.model.User;
import com.shangda.tourism.util.CookieUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String code = CookieUtil.getCookie(request, "ticket");
        if (code != null) {
            User user = userDao.selectByCode(code);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
        }
        return true;
    }
}
