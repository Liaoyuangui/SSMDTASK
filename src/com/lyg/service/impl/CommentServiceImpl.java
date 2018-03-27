package com.lyg.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.dao.TCommentMapper;
import com.lyg.dao.TCustomerMapper;
import com.lyg.entitys.TComment;
import com.lyg.entitys.TCustomer;
import com.lyg.service.ICommentService;

@Service
public class CommentServiceImpl implements ICommentService {
	@Autowired
	private TCommentMapper  commentDao;
	@Autowired 
	private TCustomerMapper  cusDao;

	/**
	 * 查找评论
	 */
	@Override
	public List<TComment> findCommentByItemId(String itemId) {
		 List<TComment> comments = commentDao.findParentCommentByItemId(itemId);
	        for (TComment comment : comments) {
	            List<TComment> replys = new ArrayList<TComment>(); // 实例化回复的集合
	            comment.setReplyComment(replys); // 设置评论的回复集合
	            String customerId = comment.getCustomerId(); // 获取评论的人的Id
	            TCustomer customer = cusDao.selectByPrimaryKey(customerId); // 通过评论人的Id获取评论人的信息
	            comment.setCustomer(customer); // 设置评论的人的信息
	            buildReplyComment(comment, replys); // 构建评论与回复信息
	        }
	        return comments;
	}

	/**
	 * 构建评论与回复评论的关系
	 */
	@Override
	public void buildReplyComment(TComment comment, List<TComment> replys) {
		List<TComment> replyComments = commentDao.findReplyCommentByCommentId(comment.getId()); // 获取评论的所有回复
        replys.addAll(replyComments); // 把所有的回复添加到评论实例化的回复集合中
        for (TComment c : replyComments) { // 遍历回复中的回复
            String customerId = c.getCustomerId(); // 获取回复人的id
            TCustomer replyCustomer = cusDao.selectByPrimaryKey(customerId);  // 获取回复人信息
            TCustomer customer = cusDao.selectByPrimaryKey(comment.getCustomerId()); // 获取评论人的信息
            c.setCustomer(customer); // 设置评论人的信息
            c.setReplyCustomer(replyCustomer); // 设置回复人的信息
            buildReplyComment(c, replys); // 递归调用
        }
	}

	@Override
	public int insertComment(TComment com) {
		int res = commentDao.insertSelective(com);
		return res;
	}

}
