package com.xworkz.enroll.service;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.xworkz.enroll.dao.StudentEnrollDAO;
import com.xworkz.enroll.dto.StudentEnrollDTO;
import com.xworkz.enroll.entity.StudentEnrollEntity;
import com.xworkz.enroll.utility.EncryptionDecryption;
import com.xworkz.enroll.utility.MailSender;
import com.xworkz.enroll.utility.RandomPasswordGenerator;

@Service
public class StudentEnrollServiceImpl implements StudentEnrollService {

	@Autowired
	private StudentEnrollDAO dao;

	@Autowired
	private EncryptionDecryption helper;

	@Autowired
	MailSender mailSender;

	private static Logger logger;

	public StudentEnrollServiceImpl() {
		logger = Logger.getLogger(getClass());
	}

	@Override
	public boolean validateAndSave(StudentEnrollDTO dto) {
		logger.info("invoked validateAndSave()");
		StudentEnrollEntity entity = new StudentEnrollEntity();
		String generateRandomPassword = RandomPasswordGenerator.generateRandomPassword(6);
		entity.setPassword(helper.encrypt(generateRandomPassword));// with encryption
//				entity.setPassword(generateRandomPassword);//without Encryption
		BeanUtils.copyProperties(dto, entity);
		boolean result = this.dao.saveStudentEnrollData(entity);
		if (result) {
			logger.info("Sending a mail");
			String text = "Enrollment successfull by " + entity.getName() + " your password is "
					+ generateRandomPassword;
			mailSender.sendMail(entity.getMail(), "Enrollment message through Java Mail Sender", text);
			logger.info("mail sent successfully");
			return true;
		} else {
			logger.info("There is some problem while sendinbg mail, please try again");
			return false;
		}
	}
}
