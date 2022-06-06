package com.cream.service;

import com.cream.domain.Item;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ItemService {
    //查询热门和优惠商品
    List<Item> selectItemsByIflag(int iflag);

    //根据商品id分页查询
    PageInfo<Item> queryPageByCid(int cid, int pageNum, int pageSize);

    //根据商品名分页查询
    PageInfo<Item> selectByName(String name, int pageNum, int pageSize);

    //显示商品具体信息
    Item showItem(int id);


}
