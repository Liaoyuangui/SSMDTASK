<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="../js/jquery1.42.min.js"></script>
<title>分页测试</title>
</head>
<body>

  <table id='menu'>
   <tr>
     <td>菜单编号</td>
     <td>菜单名称</td>
   </tr>
  </table>

<script type="text/javascript">
  
  $(function(){
	  var data = {"pageNow":1}
	  $.ajax({
		  url:"../pagetest/testPage.do",
		  data:data,
		  success:function(res){
			  console.log(res)
			 $.each(res.dataList,function(index,item){
				console.log(item)
			 });
		  }
	  });
  });

</script>

</body>
</html>