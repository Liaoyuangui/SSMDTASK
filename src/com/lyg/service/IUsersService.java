package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface IUsersService {
	/**
	 * 查询最近一个星期以前的数据
	 * @return
	 */
	public List<Object> selectOvertimeUser();
	/**
	 * 批量删除
	 * @param list 集合的id
	 * @return
	 */
	public int deleteUsers(List<Object> list);

}
