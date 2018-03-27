package com.lyg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.TItemMapper;
import com.lyg.entitys.TItem;
import com.lyg.service.ITItemService;

@Service
public class TItemServiceImpl implements ITItemService {

	@Autowired
	private TItemMapper itmeDao;
	@Override
	public List<TItem> queryAllItem() {
		return itmeDao.queryAllItem();
	}

}
