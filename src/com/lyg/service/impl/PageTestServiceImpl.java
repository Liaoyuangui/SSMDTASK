package com.lyg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.TMenuMapper;
import com.lyg.entitys.TMenu;
import com.lyg.service.IPageTestService;
import com.lyg.utils.PageUtils;
@Service
public class PageTestServiceImpl implements IPageTestService {
    
	@Autowired
	private TMenuMapper menuDao;
	@Override
	public PageUtils testPage(PageUtils pages) {
		List<TMenu> data = new ArrayList<>();
		PageUtils dataList = null;
		//查询总数
		int totalCount = (int) menuDao.getMenuCount();
		
		//如果没有传当前页，就查询首页，否则按传入的页数查询
		if(pages.getPageNow() != 1){
			dataList = new PageUtils(totalCount, pages.getPageNow());
			data = menuDao.getMenuByPage(dataList);
			dataList.setDataList(data);
		}else{
			dataList = new PageUtils(totalCount, 1);
			data = menuDao.getMenuByPage(dataList);
			dataList.setDataList(data);
		}
		return dataList;
	}

}
