package com.lyg.dao;

import java.util.List;

import com.lyg.entitys.TMenu;
import com.lyg.utils.PageUtils;

public interface TMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    TMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);
    
    List<TMenu> queryAll();
    
    //测试分页
    public List<TMenu> getMenuByPage(PageUtils page);
    //查询总数
    public long getMenuCount();
    
}