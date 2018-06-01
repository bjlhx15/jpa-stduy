package com.lhx.jpa.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lhx.jpa.entity.User;
import com.lhx.jpa.repository.UserJpaRepository;
import com.lhx.jpa.repository.UserRepository;
import com.lhx.jpa.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserJpaRepository userJpaRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return this.userJpaRepository.findAll();
	}

	@Override
	public List<User> findByName(String name) {
		List<User> userList1 = this.userRepository.findByName1(name);
		List<User> userList2 = this.userRepository.findByName2(name);
		List<User> userList3 = this.userRepository.findByNameAndAddress(name, "3");
		System.out.println("userList1:" + userList1);
		System.out.println("userList2:" + userList2);
		System.out.println("userList3:" + userList3);
		return this.userRepository.findByName(name);
	}

	@Override
	public void saveUser(User book) {
		this.userJpaRepository.save(book);
	}

	@Override
	@Cacheable("users")
	public User findOne(long id) {
		System.out.println("Cached Pages");
		return this.userJpaRepository.findOne(id);
	}

	@Override
	public void delete(long id) {
		this.userJpaRepository.delete(id);
	}
}
