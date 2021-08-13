package com.xworkz.enroll.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class StudentLoginDTO {

	private String userName;

	private String password;

}
