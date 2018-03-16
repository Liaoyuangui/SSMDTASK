<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
</head>
<body>
<input type="button" value="点击查看菜单" id="menu">
<div id="t_menu">
  
</div>
</body>

<script type="text/javascript">
  $("#menu").click(function(){
		 $.ajax({
			url:"t_menu/getMenu.do",
			type:"post",
			contentType: "application/html; charset=utf-8",
			success:function(res){
				console.log(res);
				$("#t_menu").html(res);
			}
		 });
  });

</script>
</html>