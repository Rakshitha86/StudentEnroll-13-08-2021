package com.xworkz.enroll.dao;

import com.xworkz.enroll.entity.StudentEnrollEntity;

public interface StudentEnrollDAO {

	boolean saveStudentEnrollData(StudentEnrollEntity entity);
	public StudentEnrollEntity getByEmail(String email);
}
