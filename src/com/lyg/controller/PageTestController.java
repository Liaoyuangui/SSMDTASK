package com.lyg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.service.IPageTestService;
import com.lyg.utils.PageUtils;

@Controller
@RequestMapping("pagetest")
public class PageTestController {
	@Autowired
	private IPageTestService pageService;
	
	@ResponseBody
	@RequestMapping("testPage.do")
	public PageUtils testPage(String pageNow){
		PageUtils page = new PageUtils();
		if(pageNow != null && "".equals(pageNow.trim())){
			page.setPageNow(Integer.parseInt(pageNow));
		}else{
			page.setPageNow(1);
		}
		PageUtils testPage = pageService.testPage(page);
		return testPage;
	}
}
