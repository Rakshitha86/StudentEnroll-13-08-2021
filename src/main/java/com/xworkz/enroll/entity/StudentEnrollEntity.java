package com.xworkz.enroll.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "details")
@NamedQuery(name = "getbyemail", query = "from StudentEnrollEntity as se where se.mail=:emailId")
public class StudentEnrollEntity implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "MAIL")
	private String mail;
	
	@Column(name = "PASSWORD")
	private String password;
}
