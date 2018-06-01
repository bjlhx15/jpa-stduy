package com.lhx.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhx.jpa.entity.Study;
import com.lhx.jpa.repository.StudyJpaRepository;
import com.lhx.jpa.service.IStudyService;

@Service
@Transactional
public class StudyServiceImpl implements IStudyService {
	@Autowired
	private StudyJpaRepository studyJpaRepository;

	@Override
	public List<Study> findAll() {
		return this.studyJpaRepository.findAll();
	}

	@Override
	public void saveUser(Study book) {
		this.studyJpaRepository.save(book);

	}

	@Override
	public Study findOne(long id) {
		return this.studyJpaRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		this.studyJpaRepository.delete(id);

	}

	@Override
	public List<Study> findByName(String name) {
		return null;
	}

}
