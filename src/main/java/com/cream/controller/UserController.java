package com.cream.controller;

import com.cream.domain.User;
import com.cream.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ramostear.captcha.HappyCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    //注入service
    @Autowired
    private UserService userService;

    //登录方法
    @RequestMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收用户名，密码，验证码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String captcha = request.getParameter("captcha");

        //校验验证码
        boolean rs = HappyCaptcha.verification(request, captcha, true);

        //验证码验证失败
        if (!rs) {
            request.setAttribute("error", "验证码输入错误！！！");
            return "login";
        }
        //验证码验证通过，开始登录
        User user = userService.loginUser(username, password);
        //根据用户是否登录成功 选择是 重定向 还是 转发
        if (user != null) {
            //登录成功 将用户对象保存在sessio域中 跟踪用户登录状态
            request.getSession().setAttribute("user", user);
            //在servlet动态获取虚拟路径
            response.sendRedirect(request.getContextPath() + "/");
            return null;
        } else {
            //登录失败
            request.setAttribute("error", "用户名或密码错误！！！");
            return "login";
        }
    }

    //注册
    @RequestMapping("/register")
    public String register(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //接收用户的注册信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");

        //创建User对象储存注册的用户信息
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setName(name);
        user.setTelephone(tel);

        //创建UserService 进行注册操作
        userService.registerUser(user);
        response.sendRedirect(request.getContextPath() + "/login");
        return null;
    }

    //退出
    @RequestMapping("/exit")
    public String exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //销毁session
        request.getSession().invalidate();
        //跳转到登录页面
        response.sendRedirect(request.getContextPath() + "/");
        return null;
    }

    //ajax验证用户名是否存在
    @RequestMapping("checkUser")
    @ResponseBody
    public Map<String, String> checkUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //解决乱码
        response.setContentType("application/json;charset=utf-8");

        String username = request.getParameter("username");
        User user = userService.existUser(username);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, String> map = new HashMap<>();
        if (user != null) {
            map.put("code", "0");
            map.put("rs", "用户名已被使用");
        } else {
            map.put("code", "1");
            map.put("rs", "用户名可以使用");
        }
        //objectMapper.writeValue(response.getWriter(), map);
        return map;
    }

}
