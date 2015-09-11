<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>用户列表</title>
		<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
		<script type="text/javascript" src="${BASE}/www/lib/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="${BASE}/www/lib/jquery-form/jquery.form.min.js"></script>
		<script type="text/javascript" src="${BASE}/www/js/user.js"></script>
	</head>
	<body>
		<a class="pure-button" href="${BASE}/user">Add</a>
		<table class="pure-table">
    		<thead>
        		<tr>
		            <th>主键</th>
		            <th>用户名</th>
		            <th>密码</th>
		            <th>操作</th>
        		</tr>
    		</thead>
    		<tbody>
    		<c:forEach items="${userList}" var="user" varStatus="status">
    			<c:choose>
    				<c:when test="${status.count % 2 == 0}">
    					<tr class="pure-table-odd">
    				</c:when>
    				<c:otherwise>
    					<tr>
    				</c:otherwise>
    			</c:choose>
			    <td>${user.id}</td>
			    <td>${user.username}</td>
			    <td>${user.password}</td>
			    <td>
			    	<a class="pure-button user-delete" href="${BASE}/user/${user.id}">删除</a>
			    	<a class="pure-button user-edit" href="${BASE}/user/${user.id}">编辑</a>
			   	</td>
		  	</tr>
			</c:forEach>
    	</tbody>
	</body>
</html>