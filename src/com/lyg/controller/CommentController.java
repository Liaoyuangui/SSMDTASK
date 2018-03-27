package com.lyg.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lyg.entitys.TComment;
import com.lyg.service.ICommentService;

@Controller
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
	private ICommentService commentService;
	
    @RequestMapping(value = "/test")
    public String test(ModelMap model) {
        model.put("key", "hello qq-comment");
        return "test";
    }
    
    @RequestMapping(value = "/test1")
    @ResponseBody
    public String test1() {
        return "test";
    }
    
    @RequestMapping("comment.do")
    @ResponseBody
    public List<TComment> comment(String itemId, ModelMap model) {
        List<TComment> itemComments = commentService.findCommentByItemId(itemId);
        model.put("itemComments", itemComments);
       // return "page/comment";
        return itemComments;
    }
   
    @RequestMapping(value="/getcomment.do")
    public String getcomment(String itemId, ModelMap model) {
        List<TComment> itemComments = commentService.findCommentByItemId(itemId);
        model.put("itemComments", itemComments);
        return "page/comment";
    }
    
    @RequestMapping("insertComment.do")
    @ResponseBody
    public int insertComment(String uId,String pId,String content,String cId) throws UnsupportedEncodingException{
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    	SimpleDateFormat sdf1 = new SimpleDateFormat("hh:mm:ss");
    	TComment comment = new TComment();
    	comment.setCommentDate(sdf.format(new Date()));
    	comment.setCommentTime(sdf1.format(new Date()));
    	comment.setState(0);
    	comment.setContentId(cId);
    	comment.setCustomerId(uId);
    	content = new String(content.getBytes("ISO8859-1"), "UTF-8");  
    	comment.setType(1);
    	if(pId==null){
    		pId = "0";
    	}
    	comment.setParentCommentId(pId); //父ID
    	comment.setContent(content);
    	int res = commentService.insertComment(comment);
    	return res;
    }
    

}
