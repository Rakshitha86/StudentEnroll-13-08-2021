package com.xworkz.enroll.service;

import com.xworkz.enroll.dto.StudentLoginDTO;

public interface StudentLoginService {

	public boolean validateAndLogin(StudentLoginDTO dto);
	
}
