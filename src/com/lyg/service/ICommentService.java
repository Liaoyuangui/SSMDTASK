package com.lyg.service;

import java.util.List;

import com.lyg.entitys.TComment;

public interface ICommentService {
	
	 public List<TComment> findCommentByItemId(String itemId);
	 
	 public void buildReplyComment(TComment comment, List<TComment> replys); 
	 
	 //插入
	 public int insertComment(TComment com);

}
