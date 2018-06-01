package com.lhx.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lhx.jpa.entity.Study;
import com.lhx.jpa.service.IStudyService;

@RestController
@RequestMapping(value = "/studys")
public class SrudyController {
	@Autowired
	private IStudyService service;

	@RequestMapping(value = "/add/{id}/{name}/{age}")
	public Study addEntity(@PathVariable int id, @PathVariable String name, @PathVariable String age) {
		Study entity = new Study();
		entity.setId(id);
		entity.setUserName(name);
		entity.setAge(age);
		this.service.saveUser(entity);
		return entity;
	}

	@RequestMapping(value = "/delete/{id}")
	public void deleteBook(@PathVariable int id) {
		this.service.delete(id);
	}

	@RequestMapping(value = "/")
	public List<Study> getBooks() {
		return this.service.findAll();
	}

	@RequestMapping(value = "/{id}")
	public Study getUser(@PathVariable int id) {
		Study user = this.service.findOne(id);
		return user;
	}

	@RequestMapping(value = "/search/name/{name}")
	public List<Study> getBookByName(@PathVariable String name) {
		List<Study> users = this.service.findByName(name);
		return users;
	}

}
