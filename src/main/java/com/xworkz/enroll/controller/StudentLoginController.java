package com.xworkz.enroll.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.enroll.dto.StudentLoginDTO;
import com.xworkz.enroll.service.StudentLoginService;
@Controller
@RequestMapping("/")
public class StudentLoginController {

	public static Logger logger;

	@Autowired
	private StudentLoginService service;

	public StudentLoginController() {
		logger = Logger.getLogger(getClass());
	}

	
	@RequestMapping(value="/login.do",method=RequestMethod.GET)
	
	public String login(@ModelAttribute StudentLoginDTO dto, Model model) {
	logger.info("invoked onEnroll()");
	logger.info(dto);
	boolean  result = this.service.validateAndLogin(dto);
	if(result) {
		model.addAttribute("message1","Login Successfull");
		model.addAttribute("username",dto.getUserName());
		return "Home";
	} else {
		model.addAttribute("message1", "Login not Successfull");
		return "Home";
	}
	}
//	@PostMapping("/login.do")
//	public ModelAndView login(StudentLoginDTO dto) {
//		ModelAndView modelAndView = new ModelAndView("Home");
//		String  msg = service.validateAndLogin(dto);
//		if(msg.equals("success")) {
//			modelAndView.setViewName("Home");
//			modelAndView.addObject("message1", "Login Successfull");
//			modelAndView.addObject("username",dto.getUserName());
//			
//		}else if(msg.equals("invalid username and password")) {
//			modelAndView.addObject("message1", "invalid username and password");
//		}else if(msg.equals("username not exist")) {
//			modelAndView.addObject("message1", "username not exist");
//		}
//		return modelAndView;
//	}
}
