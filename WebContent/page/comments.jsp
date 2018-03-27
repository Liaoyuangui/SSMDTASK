<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>评论</title>
<script type="text/javascript" src="../js/jquery1.42.min.js"></script>
<style>
  #t_item a{
    cursor: pointer;
    margin-left: 3px;
    color: #0976e6;
    margin-right: 3px;
  }
  .comment{
    color: #e80606;
  }
  .repName{
    color: #6205f7;
  }
  .plName{
    color: #4c7104;
  }
  .hf{
    position: fixed;
    bottom: 0px;
    border: 1px solid;
    display: none;
  }
  .show{display: block;}
</style>
</head>
<body>
   <div>
          当前登录：<input type="radio" value="1" name="user" checked="checked">宫本
    <input type="radio" value="2" name="user">小乔
    <input type="radio" value="3" name="user">雪女 
   </div><br>心情内容：
   <div id="t_item"> </div>
  
   <!-- 回复评论  -->
   <div id="hf" class="hf">
     <textarea rows="10" cols="50" id="hfContent"></textarea><br>
     <input type="button" id="hfpl" value="提交评论">
   </div>
   <!-- 
   <a id="cxpl">查看评论</a>
   <div id="comment">
     
   </div>
    -->
</body>

<script type="text/javascript">
  //查看评论
  $("#cxpl").click(function(){
	  var data = {"itemId":"1"}
	  $.ajax({
		  url:"../comment/comment.do",
		  data:data,
		  success:function(res){
			 $.each(res,function(index,item){
				 $("#comment").append("<div>"+item.customer.nickName+":"+item.content+"</div>");
				 $.each(item.replyComment,function(index,items){
					 $("#comment").append("<div>["+items.replyCustomer.nickName+"]回复了["+items.customer.nickName+"]:"+items.content+"</div>");
				 });
			 });
		  }
	  });
  });

</script>
<script type="text/javascript">
 //查询所有心情或文章
  $(function(){
	  $.ajax({
		  url:"../item/queryAllItem.do",
		  type:"post",
		  success:function(res){
			 $.each(res,function(index,item){
				 $("#t_item").append("<div class='t_item'>"+
				    "<div>"+(index+1)+"."+item.name+"</div>"+
				    "<div><a>评论</a>|<a onclick='cxpl("+item.id+")'>查看评论</a></div>"+
				    "<div class='comment' id='comment"+item.id+"'></div>"+
				    "<div><textarea id='text"+item.id+"'></textarea><br><input type='button' value='提交评论' onclick='tjpl("+item.id+")'></div>"+
				 "</div>");
			 });
		  }
	  });
   });
  
  //查询评论
  function cxpl(id){
	  var data = {"itemId":id}
	  var _content = "#comment"+id;
	  $.ajax({
		  url:"../comment/comment.do",
		  data:data,
		  success:function(res){
			 $(_content).html('');
			 $.each(res,function(index,item){
				 $(_content).append("<div><a class='repName'>"+item.customer.nickName+"</a>:"+item.content+"  &nbsp;&nbsp;&nbsp;<a onclick='hf("+item.id+","+item.contentId+")'>回复</a></div>");
				 $.each(item.replyComment,function(index,items){
					 $(_content).append("<div><a class='repName'>["+items.replyCustomer.nickName+"]</a>回复了<a class='plName'>["+items.customer.nickName+"]</a>:"+items.content+"&nbsp;&nbsp;&nbsp;<a onclick='hf("+items.id+","+items.contentId+")'>回复</a></div>");
				 });
			 });
		  }
	  });
  }
  //获取当前登录的用户的id
  var obj = document.getElementsByName("user");
  var uId=1;  //当前在线的用户
  for(var i=0;i<obj.length;i++){
	obj[i].onchange=function(){
		if(this.checked){
		  uId = this.value;
		}
	}
  }
  //提交评论
  function tjpl(item_id){
	  var _t_id = "#text"+item_id;
	  var text = $(_t_id).val();
	  var data = {"cId":item_id,"uId":uId,"content":text}
	  $.ajax({
		 url:"../comment/insertComment.do", 
		 data:data,
		 success:function(res){
			 if(res>0){
				 alert("评论成功！")
			 }
		 }
	  });
  }
  //回复
  function hf(pId,cId){
	 $("#hf").addClass("show")//为ID为hf的对象追加样式hf
	 $("#hfpl").click(function(){
		 var texts = $("#hfContent").val();
		 var data = {"cId":cId,"uId":uId,"content":texts,"pId":pId}
		 $.ajax({
			 url:"../comment/insertComment.do", 
			 data:data,
			 success:function(res){
				 if(res>0){
					 alert("评论成功！")
					 $("#hf").removeClass("show");//移除样式。
				 }
			 }
		  });
	 });
  }
 
</script>
</html>