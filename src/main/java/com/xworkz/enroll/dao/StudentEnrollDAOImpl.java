package com.xworkz.enroll.dao;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.xworkz.enroll.entity.StudentEnrollEntity;

@Repository
public class StudentEnrollDAOImpl implements StudentEnrollDAO {

	@Autowired
	SessionFactory factory;

	private static Logger logger;

	public StudentEnrollDAOImpl() {
		logger = Logger.getLogger(getClass());
	}

	@Override
	public boolean saveStudentEnrollData(StudentEnrollEntity entity) {
		logger.info("invoked saveStudentEnrollData()");
		Session session = null;
		Transaction transaction = null;
		try {
			session = factory.openSession();
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
			logger.info("Data saved successfully");
			return true;
		} catch (Exception e) {
			transaction.rollback();
			logger.info("You have exception in {} " + e.getMessage());
		} finally {
			if (Objects.nonNull(session))
				if (Objects.nonNull(session)) {
					session.close();
					logger.info("session is closed");
				} else {
					logger.info("session is not closed");
				}
		}
		return false;
	}

	public StudentEnrollEntity getByEmail(String email) {
		logger.info("invoked getByEmailId()");
		Session session = null;
		StudentEnrollEntity entity = null;
		try {
			session = factory.openSession();
			Query query = session.createNamedQuery("getbyemail");
			query.setParameter("emailId", email);
			entity = (StudentEnrollEntity) query.uniqueResult();
		} catch (Exception e) {
			logger.error("You have exception in {} " + e.getMessage(), e);

		} finally {
			if (Objects.nonNull(session))
				if (Objects.nonNull(session)) {
					session.close();
					logger.info("session is closed");
				} else {
					logger.info("session is not closed");
				}
		}
		return entity;
	}

}
