<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="jstl-c" prefix="c" %>  <!--输出,条件,迭代标签库-->
<%@ taglib uri="jstl-fmt" prefix="fmt" %>  <!--数据格式化标签库-->
<%@ taglib uri="jstl-fn" prefix="fn" %>  <!--常用函数标签库-->
<%@ page isELIgnored="false"%> <!--支持EL表达式，不设的话，EL表达式不会解析-->
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>GraduationProject</title>
  <link rel="stylesheet" href="layui/css/layui.css">
  <link rel="stylesheet" href="loginFiles/index/index.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header" style="margin-top:-1px">
  
    <!-- logo -->
    <div class="layui-logo" id="logo">
    		<a onclick="javascript:refresh();return false;" href="#";>
    		  <img src="loginFiles/img/logo5.png"/>
    		</a>
    </div>
    <!-- up -->
    <ul class="layui-nav layui-layout-left">
    	<li class="layui-nav-item">
    	     <div id="currentTime">
        			<div> SystemCurrentTime </div>
        			<div> <h id="ctime"></h></div>
    	     </div>
    	</li>
    	<li class="layui-nav-item">
				   <div id="memory">
    	     	   <div> Used Memory </div>
    	     	   <div><h><%=(Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())/1024/1024%> MB </h></div>
           </div> 	
    	</li>
    	<li class="layui-nav-item">
				   <div id="memory">
    	     	  <div> Current Heap </div>
    	     	  <div><h><%=(Runtime.getRuntime().totalMemory())/1024/1024%> MB  </h></div>
           </div> 	
    	</li>
    	<li class="layui-nav-item">
				   <div id="memory">
    	     	  <div> Max Heap</div>
    	     	  <div><h><%=(Runtime.getRuntime().maxMemory())/1024/1024%> MB </h></div>
           </div> 	
    	</li>
    </ul>
    
    
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">
          <img src="loginFiles/img/logo.jpg" class="layui-nav-img">
            <%= (String)request.getAttribute("userInfo") %>
            <!--<c:out value="  admin"></c:out> -->
        </a>
      </li>
      
      <li class="layui-nav-item">
         <a id="logout" href="javascript:;">
             <i class="larry-icon larry-exit"></i>退出
         </a>
      </li>
    </ul>
  </div>
  
  <!-- left -->
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree" lay-shrink="all" lay-filter="test">
      
           
        <!--  layui-nav-itemed默认打开   -->
        <li class="layui-nav-item ">
          <a  href="javascript:;">Console</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:loadFun()";>一</a></dd>
            <dd><a onclick="javascript:loadFun2();return false;" href="#";>二</a></dd>
            <dd><a href="javascript:;">三</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">Jobs</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">create new job</a></dd>
            <dd><a href="javascript:;">pending jobs</a></dd>
            <dd><a href="javascript:;">completed jobs</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
        	<a href="javascript:;">Profiles</a>
        	<dl class="layui-nav-child">
            <dd><a href="javascript:;">new profile</a></dd>
            <dd><a href="javascript:;">edit it</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:loadFun4();">Logs</a>
        </li>
        <li class="layui-nav-item"><a href="javascript:loadFun3()">Help</a></li>
      </ul>
    </div>
  </div>
  
  
  
  <div class="layui-body" id="content">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
    		<c:import url="jsp/indexTT.jsp"></c:import>
    </div>
  </div>
  
  <div class="layui-footer" style="text-align:center;">
    <!-- 底部固定区域 -->
    © elizabeth.com
  </div>
</div>
<script src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script src="${pageContext.request.contextPath}/loginFiles/js/jquery.min.js"></script>
<script>
//JavaScript代码区域
layui.config({
			base : '/GraduationProject/layui/lay/modules/'
		});
layui.use(['element','jquery', 'larry', 'form', 'common' ], function(){
  var       $ = layui.jquery, 
              larry = layui.larry(), 
               form = layui.form, 
            element = layui.element,
             common = layui.common;
             
        element.init();
        //初始函数     
				$(function(){
						var int=self.setInterval("clock()",1000);
				});
				$('#logout').on('click', function() {
          logout();
        })
				
        
        function logout(){
          var url = '${pageContext.request.contextPath}/logout';
          common.logOut('退出登陆提示！', '你真的确定要退出系统吗？', url);
        }
});//layui end

				// 点击图标刷新页面
        function refresh(){
        	window.location.reload();
        }
        // 自动更新时间
        function clock(){
                 var t=new Date().toLocaleString();
                 document.getElementById('ctime').innerHTML=t;
        }

				//菜单栏1
				function loadFun(){
				  $('#content').load('jsp/ContentJsp.jsp'); 
				};
				//菜单栏2
				function loadFun2(){
				  $('#content').load('jsp/rule.jsp'); 
				};
				//Help
				function loadFun3(){
					$('#content').load('jsp/indexT.jsp');
				};
				//logs
				function loadFun4(){
					$('#content').load('jsp/webSocket.jsp');
				}

</script>
</body>
</html>