<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery1.42.min.js"></script>
<title>分页测试</title>
<style>
  #menu{
    border: 1px solid;
    width: 400px;
    text-align: center;
    margin: 0 auto;  
  } 
  .tableHead{
    color: red;
    background: #2b1e1e;
  }
  button{
  border: 0px;
    background: blue;
    color: white;
    width: 60px;
    height: 25px;
  }
  #page{
    margin-top: 10px;
  }
  #inputPage{
    width: 40px;
    height: 21px;
    border: 1px solid #6b5b5b;
  }
  a{
    font-size: 15px;
    color: #4c3d3d;
    background: white;
  }
  .ys{
    color: #8e3306;
  }
</style>
</head>
<body>

  <div id="data">
  <table id='menu' border='1'></table>
  </div>
  <div id="page">
    <button onclick="dopages('first')">首页</button>
    <button onclick="dopages('pre')">上一页</button>
    <button onclick="dopages('next')">下一页</button>
    <button onclick="dopages('last')">末页</button>
    <input type="text" id="inputPage" >
    <button onclick="dopages('go')">跳转</button>
    <a>当前第<span class='ys' id="currentPage"></span>页/总共
           <span class='ys' id="totalPage"></span>页</a>
  </div>

<script type="text/javascript">
  
  $(function(){
	 dopages(1);
  });
  
  function setData(data){
	 var td = "<tr>"+
      "<td colspan='2'>菜单</td>"+
	  " </tr>"+
	  " <tr class='tableHead'>"+
	  "   <td>菜单编号</td>"+
	  "   <td>菜单名称</td>"+
	  " </tr>";
	 $.each(data,function(index,item){
		 td += "<tr><td>"+((currentPage-1)*pageSize+(index+1))+"</td><td>"+item.name+"</td><tr>"
	 });
	 $("#menu").html(td);
  }
  function getData(currentPage){
	  var data = {"pageNow":currentPage}
	  $.ajax({
		  url:"../pagetest/testPage.do",
		  data:data,
		  success:function(res){
			 currentPage = res.pageNow;
			 totalPage = res.totalPageCount;
			 pageSize = res.pageSize;
			 $("#currentPage").text(currentPage);
			 $("#totalPage").text(totalPage);
			 setData(res.dataList);
		  }
	  });
  }

</script>
 <script type="text/javascript">
        var currentPage = 1;
	    var totalPage = 1;
	    var pageSize = 1;
	    function dopages(op){
	    	if(op=='first'){
	    		currentPage=1;
	    	}
	    	if(op=='pre'){
	    		currentPage=currentPage-1;
	    		if(currentPage<=1){
	    			currentPage=1;
	    		}
	    	}
	    	if(op=='next'){
	    		currentPage=currentPage+1;
	    		if(currentPage>totalPage){
	    			currentPage=totalPage;
	    		}
	    	}
	    	if(op=='last'){
	    		currentPage=totalPage;
	    	}
	    	if(op=='go'){
	    		currentPage=document.getElementById("inputPage").value;
	    		var parrern=/^[0-9]+$/;
	    		var reg=currentPage.match(parrern);
	    		if(reg==null){
	    			alert("页数请输入数字");
	    			//清空输入框
	    			document.getElementById("inputPage").value="";
	    			//获取焦点
	    			document.getElementById("inputPage").focus();
	    			return;
	    		}
	    		if(currentPage>=totalPage){
	    			currentPage=totalPage;
	    		}
	    		if(currentPage<1){
	    			currentPage=1;
	    		}
	    	}
	    	
	    	getData(currentPage);
	    
	    }
	 
  </script>

</body>
</html>