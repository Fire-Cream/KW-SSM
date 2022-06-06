package com.cream.service;

import com.cream.domain.ItemCat;

import java.util.List;

public interface ItemCatService {
    //查询所有分类
    List<ItemCat> selectAll();
}
