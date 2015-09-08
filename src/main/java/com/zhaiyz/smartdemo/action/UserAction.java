package com.zhaiyz.smartdemo.action;

import java.util.List;
import java.util.Map;

import org.smart4j.framework.ioc.annotation.Inject;
import org.smart4j.framework.mvc.DataContext;
import org.smart4j.framework.mvc.annotation.Action;
import org.smart4j.framework.mvc.annotation.Request;
import org.smart4j.framework.mvc.bean.Params;
import org.smart4j.framework.mvc.bean.Result;
import org.smart4j.framework.mvc.bean.View;

import com.zhaiyz.smartdemo.entity.User;
import com.zhaiyz.smartdemo.service.UserService;

@Action
public class UserAction {

	@Inject
	private UserService userService;

	@Request.Get("/users")
	public View index() {
		List<User> userList = userService.findUserList();
		DataContext.Request.put("userList", userList);
		return new View("user.jsp");
	}

	@Request.Get("/user")
	public View create() {
		return new View("user_create.jsp");
	}

	public Result save(Params params) {
		Map<String, Object> fieldMap = params.getFieldMap();
		boolean result = userService.saveUser(fieldMap);
		return new Result(result);
	}

	@Request.Get("/user/{id}")
	public View edit(long id) {
		User user = userService.findUser(id);
		DataContext.Request.put("user", user);
		return new View("user_edit.jsp");
	}

	@Request.Put("/user/${id}")
	public Result update(long id, Params params) {
		Map<String, Object> fieldMap = params.getFieldMap();
		boolean result = userService.updateUser(id, fieldMap);
		return new Result(result);
	}

	@Request.Delete("/user/{id}")
	public Result delete(long id) {
		boolean result = userService.deleteUser(id);
		return new Result(result);
	}
}
