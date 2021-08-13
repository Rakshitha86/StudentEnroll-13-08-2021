package com.xworkz.enroll.service;

import com.xworkz.enroll.dto.StudentEnrollDTO;

public interface StudentEnrollService {
	
	boolean validateAndSave(StudentEnrollDTO dto);
}
