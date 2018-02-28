package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.PersonMapper;
import com.lyg.entitys.Person;
import com.lyg.service.IPersonService;
/**
 * service 的实现类
 * @author 
 *
 */
@Service
public class PersonServiceImpl implements IPersonService {
	@Autowired
	private PersonMapper personDao;

	@Override
	public List<Person> selectAllPerson(Person person) {
		return personDao.selectAllPerson(person);
	}

}
