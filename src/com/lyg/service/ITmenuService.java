package com.lyg.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lyg.entitys.TMenu;

@Service
public interface ITmenuService {
	
	 public List<TMenu> queryAll();

}
