package com.lhx.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhx.jpa.entity.User;
import com.lhx.jpa.service.IUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	@Autowired
	private IUserService userService;

	@RequestMapping(value = "/add/{id}/{name}/{address}")
	public User addUser(@PathVariable int id, @PathVariable String name, @PathVariable String address) {
		User user = new User();
		user.setId(id);
		user.setName(name);
		user.setAddress(address);
		this.userService.saveUser(user);
		return user;
	}

	@RequestMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		this.userService.delete(id);
	}

	@RequestMapping(value = "/")
	public List<User> getBooks() {
		return this.userService.findAll();
	}

	@RequestMapping(value = "/{id}")
	public User getUser(@PathVariable int id) {
		User user = this.userService.findOne(id);
		return user;
	}

	@RequestMapping(value = "/search/name/{name}")
	public List<User> getBookByName(@PathVariable String name) {
		List<User> users = this.userService.findByName(name);
		return users;
	}

}
