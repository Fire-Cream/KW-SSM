package com.cream.controller;

import com.cream.domain.Item;
import com.cream.service.ItemService;
import com.ramostear.captcha.HappyCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class IndexController {
    //注入service
    @Autowired
    private ItemService itemService;
    //显示首页
    @RequestMapping("/")
    public String index(Model model){
        //得到热门商品和优惠商品
        List<Item> rm_items = itemService.selectItemsByIflag(1);
        List<Item> yh_items = itemService.selectItemsByIflag(2);
        model.addAttribute("rm_items", rm_items);
        model.addAttribute("yh_items", yh_items);
        return "index";
    }

    @RequestMapping("HappyCaptcha")
    public void happyCaptcha(HttpServletRequest request, HttpServletResponse response){
        HappyCaptcha.require(request, response).length(4).build().finish();
    }

    //跳转页面方法
    @RequestMapping("/{page}")
    public String show(@PathVariable String page){
        return page;
    }
}
