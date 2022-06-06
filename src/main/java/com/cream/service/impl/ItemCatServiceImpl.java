package com.cream.service.impl;

import com.cream.domain.ItemCat;
import com.cream.mapper.ItemCatMapper;
import com.cream.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ItemCatServiceImpl implements ItemCatService {
    //注入mapper
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Override
    public List<ItemCat> selectAll() {
        return itemCatMapper.selectAll();
    }
}
