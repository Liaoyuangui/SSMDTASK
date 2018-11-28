package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.Person;

/**
 * service 层
 * @author
 *
 */
@Service
public interface IPersonService {
	/**
	 * 查询所以的
	 * @param person 条件
	 * @return 
	 */
	public List<Person> selectAllPerson(Person person);

	/**
	 * 添加
	 * @param person
	 * @return
	 */
	int insertPerson(Person person);
}
