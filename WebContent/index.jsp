<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>ssm 框架整合测试</title>
<script type="text/javascript" src="js/jquery1.42.min.js"></script>
</head>
<style>
   .btnBox{width: 150px;margin: 10px auto;}
</style>
<body>
  <div class="btnBox">
     <input id="query" type="button" class="btn" value="点击查询数据">
  </div><hr>
  <div>
     <table id="myTable" align="center" border="1">
         <tr>
           <td>编号</td>
           <td>姓名</td>
           <td>性别</td>
           <td>年龄</td>
         </tr>
     </table>
  </div>
</body>
<script type="text/javascript">
  $("#query").click(function(){
	     var str = "";
		 $.ajax({
			url:"person/selectAllPerson.do",
			type:"post",
			success:function(res){
				$.each(res,function(index,item){
					str += "<tr>"
					      +"<td>"+item.id+"</td>"
					      +"<td>"+item.name+"</td>"
					      +"<td>"+item.sex+"</td>"
					      +"<td>"+item.age+"</td>"
					     +"</tr>";
				});
				$("#myTable").append(str);
			}
		 });
  });

</script>
</html>