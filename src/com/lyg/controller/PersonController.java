package com.lyg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.Person;
import com.lyg.service.IPersonService;

/**
 * 控制层
 * @author 
 *
 */
@Controller
@RequestMapping("person")
public class PersonController {
	@Autowired
	private IPersonService personService;
	
	@ResponseBody
	@RequestMapping("selectAllPerson.do")
	public List<Person> selectAllPerson(Person person){
		return personService.selectAllPerson(person);
	}

}
