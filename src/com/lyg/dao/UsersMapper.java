package com.lyg.dao;

import java.util.List;

import com.lyg.entitys.Users;

public interface UsersMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Users record);

    int insertSelective(Users record);

    Users selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Users record);

    int updateByPrimaryKey(Users record);
    
    List<Object> selectOvertimeUser();
    
    int deleteUsers(List<Object> list);
}