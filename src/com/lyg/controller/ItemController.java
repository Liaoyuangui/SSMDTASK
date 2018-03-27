package com.lyg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.TItem;
import com.lyg.service.ITItemService;

@Controller
@RequestMapping("item")
public class ItemController {
	@Autowired
	private ITItemService itemService;
	
	@ResponseBody
	@RequestMapping("queryAllItem.do")
	public List<TItem> queryAllItem(){
		List<TItem> list = new ArrayList<>();
		list = itemService.queryAllItem();
		return list;
	}

}
