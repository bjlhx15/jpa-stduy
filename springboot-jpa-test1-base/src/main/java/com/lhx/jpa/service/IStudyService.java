package com.lhx.jpa.service;

import java.util.List;

import com.lhx.jpa.entity.Study;

public interface IStudyService {
	List<Study> findAll();

	void saveUser(Study book);

	Study findOne(long id);

	void delete(long id);

	List<Study> findByName(String name);
}
