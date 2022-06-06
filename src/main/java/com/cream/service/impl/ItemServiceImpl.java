package com.cream.service.impl;

import com.cream.domain.Item;
import com.cream.mapper.ItemMapper;
import com.cream.service.ItemService;
import com.github.pagehelper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    //注入mapper
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> selectItemsByIflag(int iflag) {
        return itemMapper.selectItemsByIflag(iflag);
    }

    @Override
    public PageInfo<Item> queryPageByCid(int cid, int pageNum, int pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //根据分类id查询所有商品
        List<Item> items = itemMapper.selectAllByCid(cid);
        PageInfo<Item> pageInfo = new PageInfo<>(items);
        return pageInfo;
    }

    @Override
    public PageInfo<Item> selectByName(String name, int pageNum, int pageSize) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);
        //根据分类id查询所有商品
        List<Item> items = itemMapper.selectAllByName("%"+name+"%");
        PageInfo<Item> pageInfo = new PageInfo<>(items);
        return pageInfo;
    }

    @Override
    public Item showItem(int id) {
        return itemMapper.showItem(id);
    }
}
