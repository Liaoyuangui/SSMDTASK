package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.TMenuMapper;
import com.lyg.entitys.TMenu;
import com.lyg.service.ITmenuService;

@Service
public class ITmenuServiceImpl implements ITmenuService {

	@Autowired
	private TMenuMapper  tmenudao;
	@Override
	public List<TMenu> queryAll() {
		return tmenudao.queryAll();
	}

}
