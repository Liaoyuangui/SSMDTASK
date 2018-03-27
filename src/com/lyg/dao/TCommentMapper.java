package com.lyg.dao;

import java.util.List;

import com.lyg.entitys.TComment;

public interface TCommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(TComment record);

    int insertSelective(TComment record);

    TComment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TComment record);

    int updateByPrimaryKey(TComment record);
    
    //根据所有的评论对象的ID查询出所有的父评论
    List<TComment> findParentCommentByItemId(String itemId);
    
    //根据父评论id查询出所有的子评论
    List<TComment> findReplyCommentByCommentId(String parentCommentId);
    
    //根据评论对象的Id查询所有评论
    List<TComment> findCommentByItemId(String itemId);
    
}