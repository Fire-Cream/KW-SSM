package com.cream.mapper;

import com.cream.domain.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ItemMapper {
    //查询热门和优惠商品
    List<Item> selectItemsByIflag(int iflag);

    //根据商品分类查询所有信息
    List<Item> selectAllByCid(int cid);

    //根据商品名查询所有信息
    List<Item> selectAllByName(String name);

    //显示商品具体信息
    Item showItem(int id);


}