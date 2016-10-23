<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.github.jlran.a_life.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    监听器测试！
    <%
    	//request.setAttribute("jlran", "jlran");
    	//request.removeAttribute("jlran");
    	
    	//session.invalidate();
    	//session.setAttribute("jlran", "joran");
    	//session.setMaxInactiveInterval(10);
    	//session.removeAttribute("jlran");
    	session.setAttribute("demo", new Demo05());
    	session.removeAttribute("demo");
     %>
  </body>
</html>
