package com.cream.controller;

import com.cream.domain.ItemCat;
import com.cream.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/cat")
public class ItemCatController {
    //注入service
    @Autowired
    private ItemCatService itemCatService;
    //显示所有分类信息
    @RequestMapping("/list")
    //如果返回的是字符串 注解将字符串 相应到浏览器
    //如果返回的是集合对象 会将他们转换成json
    @ResponseBody
    public List<ItemCat> list(HttpServletRequest request) {
        List<ItemCat> itemCats = itemCatService.selectAll();
        request.getSession().setAttribute("itemCats",itemCats);
        return itemCats;
    }
}
