<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-11-27 0027
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>导入excel</title>
    <style>
        .excel-box{
            width: 500px;
            height: 150px;
            border: 1px solid #decff3;
            padding-top: 60px;
        }
        .excel-form span{
            color: #5d5768;
        }
        .file{
            background: #90966a;
            color: #f1f9d4;
            font-size: 14px;
            height: 30px;
            width: 180px;
        }
        .btn-save{
            width: 60px;
            height: 30px;
            border: 1px;
            background: #3156f5;
            color: white;
        }
        .msg{
            color: red;
        }

    </style>
</head>
<body>
<div class="excel-box">

    <form action="../excel/importEcxel.do" method="post" enctype="multipart/form-data" class="excel-form">
        <span>选择文件：</span><input type="file" name="file" class="file"/>
        <input id="submit_form" type="submit" class="btn-save" value="提交"/>
        <p class="msg" id="msg"></p>
    </form>

</div>
<script>
    var code = "${code}";
    if(code == "0000"){
        document.getElementById("msg").innerHTML="上传成功";
    }else if(code == "4000"){
        console.log("${msg}");
        document.getElementById("msg").innerHTML="${msg}";
    }else{
        document.getElementById("msg").innerHTML="";
    }

</script>
</body>
</html>
