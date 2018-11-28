package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.Person;
@Repository
public interface PersonMapper {
	
	// 查询所有的数据
	List<Person> selectAllPerson(Person person);

	/**
	 * 添加
	 * @param person 对象
	 * @return
	 */
	int insertPerson(Person person);

}
