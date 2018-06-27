<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="jstl-c" prefix="c"%>
<!--输出,条件,迭代标签库-->
<%@ taglib uri="jstl-fmt" prefix="fmt"%>
<!--数据格式化标签库-->
<%@ taglib uri="jstl-fn" prefix="fn"%>
<!--常用函数标签库-->
<%@ page isELIgnored="false"%>
<!--支持EL表达式，不设的话，EL表达式不会解析-->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>


<div id ="test"></div>

<table border="1">
  <thead>
    <tr>
      <th>Month</th>
      <th>Savings</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>January</td>
      <td>$100</td>
    </tr>
    <tr>
      <td>February</td>
      <td>$80</td>
    </tr>
  </tbody>
  <tfoot>
    <tr>
      <td>Sum</td>
      <td>$180</td>
    </tr>
  </tfoot>
</table>

              
          


<script src="${pageContext.request.contextPath}/loginFiles/js/jquery.min.js"></script>
<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script>
$(document).ready(function(){
  
  htmlobj=$.ajax({url:"properties",async:false});
  
  $("#test").html(htmlobj.responseText);
  
});
</script>

</body>
</html>