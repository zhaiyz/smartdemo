package com.zhaiyz.smartdemo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.smart4j.framework.dao.DatabaseHelper;
import org.smart4j.framework.ioc.BeanHelper;
import org.smart4j.framework.test.OrderedRunner;
import org.smart4j.framework.test.annotation.TestOrder;

import com.zhaiyz.smartdemo.entity.User;
import com.zhaiyz.smartdemo.service.impl.UserServiceImpl;

@RunWith(OrderedRunner.class)
public class UserServiceTest {

	private UserService userService = BeanHelper.getBean(UserServiceImpl.class);

	@BeforeClass
	public static void init() {
		DatabaseHelper.initSQL("sql/user_init.sql");
	}

	@AfterClass
	public static void clear() {
		DatabaseHelper.initSQL("sql/user_clear.sql");
	}

	@Test
	@TestOrder(1)
	public void findUserListTest() {
		List<User> userList = userService.findUserList();
		Assert.assertNotNull(userList);
		Assert.assertEquals(3, userList.size());
	}

	@Test
	@TestOrder(2)
	public void findUserTest() {
		User user = userService.findUser(1L);
		Assert.assertNotNull(user);
		Assert.assertEquals(1L, user.getId());
	}

	@Test
	@TestOrder(3)
	public void saveUserTest() {
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		fieldMap.put("username", "user4");
		fieldMap.put("password", "password4");
		boolean result = userService.saveUser(fieldMap);
		Assert.assertTrue(result);
	}

	@Test
	@TestOrder(4)
	public void updateUserTest() {
		long id = 1;
		Map<String, Object> fieldMap = new HashMap<String, Object>();
		fieldMap.put("username", "user11");
		fieldMap.put("password", "password11");
		boolean result = userService.updateUser(id, fieldMap);
		Assert.assertTrue(result);
	}

	@Test
	@TestOrder(5)
	public void deleteUser() {
		long id = 1;
		boolean result = userService.deleteUser(id);
		Assert.assertTrue(result);
	}

}
