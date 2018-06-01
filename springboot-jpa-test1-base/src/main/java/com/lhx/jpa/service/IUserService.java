package com.lhx.jpa.service;

import java.util.List;

import com.lhx.jpa.entity.User;

public interface IUserService {
	List<User> findAll();

	void saveUser(User book);

	User findOne(long id);

	void delete(long id);

	List<User> findByName(String name);
}
