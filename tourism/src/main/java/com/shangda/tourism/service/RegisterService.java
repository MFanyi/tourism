package com.shangda.tourism.service;

import com.shangda.tourism.dao.UserDao;
import com.shangda.tourism.model.User;
import com.shangda.tourism.util.MailUtil;
import com.shangda.tourism.util.TourismConstant;
import com.shangda.tourism.util.TourismUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

@Service
public class RegisterService {
    @Resource
    private UserDao userDao;

    @Resource
    private MailUtil mailUtil;

    @Resource
    private TemplateEngine templateEngine;

    @Resource
    private ExecutorService executorService;

    @Value("${tourism.path.domain}")
    private String domain;

    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();
        if (user == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        if (StringUtils.isBlank(user.getUsername())) {
            map.put("msg", "账号不能为空");
            return map;
        }
        if (StringUtils.isBlank(user.getPassword())) {
            map.put("msg", "密码不能为空");
            return map;
        }
        if (StringUtils.isBlank(user.getEmail())) {
            map.put("msg", "邮箱不能为空");
            return map;
        }
        if (StringUtils.isBlank(user.getName())) {
            map.put("msg", "姓名不能为空");
            return map;
        }
        if (StringUtils.isBlank(user.getPhone())) {
            map.put("msg", "手机号不能为空");
            return map;
        }
        User u = userDao.selectByUsername(user.getUsername());
        if (u != null) {
            map.put("msg", "该账号已存在");
            return map;
        }
        if(userDao.selectByEmail(user.getEmail()) != null){
            map.put("msg","该邮箱已注册");
            return map;
        }
        user.setSalt(TourismUtil.generateUUID().substring(0, 5));
        user.setPassword(TourismUtil.md5(user.getPassword() + user.getSalt()));
        user.setType(0);
        user.setStatus(0);
        user.setActivationCode(TourismUtil.generateUUID());
        if(user.getGender() == 1){
            user.setHeaderUrl("headimg/moren1.jpg");
        }else {
            user.setHeaderUrl("headimg/moren2.jpg");
        }
        userDao.insertUser(user);
        //激活邮件
        Context context = new Context();
        context.setVariable("name", user.getName());
        String url = domain + "/user/success.html?userId=" + user.getId() + "&code=" + user.getActivationCode();
        context.setVariable("url", url);
        String content = templateEngine.process("mail/activation", context);
        executorService.execute(() -> mailUtil.sendMail(user.getEmail(), "激活账号", content));

        return map;
    }

    public int activation(int id, String code) {
        User user = userDao.selectById(id);
        if (user.getStatus() == 1) {
            return TourismConstant.ACTIVATION_REPEAT;
        } else if (user.getActivationCode().equals(code)) {
            userDao.updateStatus(id, 1);
            return TourismConstant.ACTIVATION_SUCCESS;
        } else {
            return TourismConstant.ACTIVATION_FAILURE;
        }
    }
}
