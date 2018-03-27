package com.lyg.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.TMenu;
import com.lyg.service.ITmenuService;
import com.lyg.unitl.Tree;

@Controller
@RequestMapping("t_menu")
public class TmenuController {
	
	@Autowired
	public ITmenuService tmenuService;
	
	@ResponseBody
	@RequestMapping("getMenu.do")
	public String getMenu(HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		List<TMenu> queryAll = tmenuService.queryAll();
		System.out.println(queryAll.size());
		Tree tree = new Tree(queryAll);
		String buildTree = tree.buildTree();
		System.out.println(buildTree);
		return buildTree;
	}
	

}