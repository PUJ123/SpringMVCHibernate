package com.journaldev.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.journaldev.spring.model.User;
import com.journaldev.spring.service.MyDairyService;
import com.journaldev.spring.service.PersonService;


@Controller
/*@RequestMapping(value = "/myDairy")*/
public class MyDairyController {

	@Autowired
	public MyDairyService myDairyService;
	
	/*@Autowired(required=true)
	@Qualifier(value="myDairyService")
	public void setMyDairyService(MyDairyService ms){
		this.myDairyService = ms;
	}*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String defaultPage(ModelMap map) {
		return "hello";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String myDairyLoginController(ModelMap map) {
		return "myDairy/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value = "user") User user,BindingResult result) {
		System.out.println("i am wokring");
		boolean check = myDairyService.checkUser(user);
		
		if(check) {
			return "myDairy/welcome";
		}
		return "redirect:/login";
	}

}
