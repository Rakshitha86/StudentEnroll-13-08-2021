package com.xworkz.enroll.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.enroll.dao.StudentEnrollDAO;
import com.xworkz.enroll.dto.StudentLoginDTO;
import com.xworkz.enroll.entity.StudentEnrollEntity;
import com.xworkz.enroll.utility.EncryptionDecryption;

@Service
public class StudentLoginServiceImpl implements StudentLoginService {

	public static Logger logger;

	@Autowired
	private StudentEnrollDAO dao;

	@Autowired
	EncryptionDecryption helper;

	public StudentLoginServiceImpl() {
		logger = Logger.getLogger(getClass());
	}

	@Override
	public boolean validateAndLogin(StudentLoginDTO dto) {
		logger.info("inside {}");
		try {
			StudentEnrollEntity entity = dao.getByEmail(dto.getUserName());
			if (Objects.nonNull(entity)) {
//				String password = helper.decrypt(entity.getPassword());
				if (dto.getPassword().equals(entity.getPassword())) {
					logger.info("Login Successfull");
				} else {
					logger.info("Username Password mismatch");
				}
			}else {
				logger.info("User does not exist enroll to Login");
			}

		} catch (Exception e) {
			logger.error("You have exception in {} " + e.getMessage());
		}
		return false;
	}

}
