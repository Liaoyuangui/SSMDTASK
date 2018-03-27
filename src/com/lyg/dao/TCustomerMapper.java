package com.lyg.dao;

import com.lyg.entitys.TCustomer;

public interface TCustomerMapper {
    int deleteByPrimaryKey(String id);

    int insert(TCustomer record);

    int insertSelective(TCustomer record);

    TCustomer selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TCustomer record);

    int updateByPrimaryKey(TCustomer record);
}