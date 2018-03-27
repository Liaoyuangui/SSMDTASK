package com.lyg.dao;

import java.util.List;

import com.lyg.entitys.TItem;

public interface TItemMapper {
    int deleteByPrimaryKey(String id);

    int insert(TItem record);

    int insertSelective(TItem record);

    TItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TItem record);

    int updateByPrimaryKey(TItem record);
    
    //获取所以的
    List<TItem> queryAllItem();
}