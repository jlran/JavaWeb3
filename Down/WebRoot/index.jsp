<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>下载列表</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  
  <body>
  	<table>
	  	<c:forEach items="${file }" var="en">
	  		<tr>
	  			<c:url value="Demo" var="url">
	  				<c:param name="method" value="down"></c:param>
	  				<c:param name="file" value="${en }"></c:param>
	  			</c:url>
	  			<td>${en }</td><td><a href="${url }">下载</a></td>
	  		</tr>
	  	</c:forEach>
  	</table>
  </body>
</html>
