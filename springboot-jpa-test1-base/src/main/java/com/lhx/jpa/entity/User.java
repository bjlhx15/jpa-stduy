package com.lhx.jpa.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@NamedQuery(name = "User.findByName", query = "select name,address from User u where u.name=?1")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	long id;
	@Column(name = "name")
	String name;
	@Column(name = "address")
	String address;
	@Transient
	@Temporal(TemporalType.DATE)
	Date birth;
	@Lob
	@Basic(fetch = FetchType.LAZY)
	private String info;

	@Enumerated(EnumType.STRING)
	@Column(length = 5, nullable = false)
	private Gender getGender;

	public Gender getGetGender() {
		return this.getGender;
	}

	public Date getBirth() {
		return this.birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
