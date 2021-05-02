package com.journaldev.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.journaldev.spring.dao.MyDairyDao;
import com.journaldev.spring.dao.PersonDAO;
import com.journaldev.spring.model.User;

@Service
public class MyDairyService {

	@Autowired
	public MyDairyDao myDairyDao;

	/*
	 * public void setMyDairyDao(MyDairyDao MyDairyDao) { this.myDairyDao =
	 * MyDairyDao; }
	 */

	@Transactional
	public boolean checkUser(User user) {
		Boolean result = false;
		try {
			List<User> list = myDairyDao.checkUser(user);
			long count = list.stream().filter(
					dbUser -> dbUser.getEmail().equals(user.getEmail()) && dbUser.getPswd().equals(user.getPswd()))
					.count();
			if (count == 1) {
				result=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Transactional
	public void createUser(User user) {
		Boolean result=false;
		try {
			myDairyDao.createUser(user);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Transactional
	public Boolean isUserExist(User user) {
		
		Boolean result = true;;
		try {
			List<User> userList =myDairyDao.isUserExist(user);
			if(userList.isEmpty()) {
				result = false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
}
