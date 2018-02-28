package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.UsersMapper;
import com.lyg.service.IUsersService;
@Service
public class UsersServiceImpl implements IUsersService{
	@Autowired
	private UsersMapper userDao;

	@Override
	public List<Object> selectOvertimeUser() {
		return userDao.selectOvertimeUser();
	}

	@Override
	public int deleteUsers(List<Object> list) {
		return userDao.deleteUsers(list);
	}

}
