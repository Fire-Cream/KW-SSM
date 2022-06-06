package com.cream.mapper;

import com.cream.domain.ItemCat;
import java.util.List;

public interface ItemCatMapper {
    //查询所有分类
    List<ItemCat> selectAll();
}
