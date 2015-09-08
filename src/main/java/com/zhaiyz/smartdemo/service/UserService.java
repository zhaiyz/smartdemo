package com.zhaiyz.smartdemo.service;

import java.util.List;
import java.util.Map;

import com.zhaiyz.smartdemo.entity.User;

public interface UserService {

	List<User> findUserList();

	User findUser(long id);

	boolean saveUser(Map<String, Object> fieldMap);

	boolean updateUser(long id, Map<String, Object> fieldMap);

	boolean deleteUser(long id);
}
