package com.lyg.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.lyg.service.IUsersService;

@Controller
public class UsersController {
	@Autowired
	private IUsersService usersService;
	
	/**
	 * 该方法定时执行，不能带返回值
	 * @return
	 */
	@Scheduled(cron = "0 16 16 * * *")
	public void deteleUser(){
		List<Object> list = usersService.selectOvertimeUser();
		List<Object> idList = new ArrayList<>();
		if(list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
				Map<String, Object> map = (Map<String, Object>) list.get(i);
				idList.add(map.get("id"));
			}
		}else{
			System.out.println("没有相关数据。。。");
		}
		
		//idList查出来数据的id都存放在这里，然后执行批量删除
		for (int i = 0; i < idList.size(); i++) {
			System.out.println(idList.get(i));
		}
		if(idList.size()>0){
			usersService.deleteUsers(idList);
			System.out.println("删除成功！！！");
		}
		
	}

}
