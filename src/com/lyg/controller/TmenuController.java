package com.lyg.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.TMenu;
import com.lyg.service.ITmenuService;
import com.lyg.utils.Tree;

@Controller
@RequestMapping("t_menu")
public class TmenuController {
	
	@Autowired
	public ITmenuService tmenuService;
	
	@ResponseBody
	@RequestMapping(value = "getMenu.do",produces="text/html;charset=UTF-8;")
	public String getMenu(HttpServletResponse response) throws UnsupportedEncodingException{
		List<TMenu> queryAll = tmenuService.queryAll();
		System.out.println(queryAll.size());
		Tree tree = new Tree(queryAll);
		String buildTree = tree.buildTree();
		System.out.println(buildTree);
		return buildTree;
	}
	

}
