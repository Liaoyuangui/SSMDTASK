package com.lyg.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.entitys.Person;
@Repository
public interface PersonMapper {
	
	// 查询所有的数据
	List<Person> selectAllPerson(Person person);

}
