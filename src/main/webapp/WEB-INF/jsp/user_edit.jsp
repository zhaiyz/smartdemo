<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="BASE" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>编辑用户</title>
		<link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.6.0/pure-min.css">
		<script type="text/javascript" src="${BASE}/www/lib/jquery/jquery.min.js"></script>
		<script type="text/javascript" src="${BASE}/www/lib/jquery-form/jquery.form.min.js"></script>
		<script type="text/javascript" src="${BASE}/www/js/user.js"></script>
	</head>
	<body>
		<a class="pure-button" href="${BASE}/users">List</a>
		<form id="user_edit_form" class="pure-form pure-form-aligned">
			<input id="id" type="hidden" name="id" value=${user.id} />
		    <fieldset>
		        <div class="pure-control-group">
		            <label for="username">用户名</label>
		            <input id="username" type="text" name="username" value="${user.username }" placeholder="用户名">
		        </div>
		
		        <div class="pure-control-group">
		            <label for="password">密码</label>
		            <input id="password" type="password" name="password" value="${user.password }" placeholder="密码">
		        </div>
		
		        <div class="pure-controls">
		            <button type="submit" class="pure-button pure-button-primary">修改</button>
		        </div>
		    </fieldset>
		</form>
	</body>
</html>