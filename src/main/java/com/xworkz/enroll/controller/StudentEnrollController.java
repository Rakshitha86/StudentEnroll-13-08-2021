package com.xworkz.enroll.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.enroll.dto.StudentEnrollDTO;
import com.xworkz.enroll.service.StudentEnrollService;


@Controller
@RequestMapping("/")
public class StudentEnrollController {

	private static Logger logger;

	@Autowired
	private StudentEnrollService service;

	public StudentEnrollController() {
		logger = Logger.getLogger(getClass());
	}

	@RequestMapping(value="/enroll.do",method=RequestMethod.GET)
	public String onEnroll(@ModelAttribute StudentEnrollDTO dto, Model model) {
		logger.info("invoked onEnroll()");
		logger.info(dto);
		boolean result = this.service.validateAndSave(dto);
		if (result) {
			model.addAttribute("message", "Enrollment Successfull");
			return "EnrollSuccess";
		} else {
			model.addAttribute("message", "Enrollment not Successfull");
			return "EnrollSuccess";
		}

	}
}
