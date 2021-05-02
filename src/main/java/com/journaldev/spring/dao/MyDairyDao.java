package com.journaldev.spring.dao;

import java.util.List;

import com.journaldev.spring.model.User;

public interface MyDairyDao {

	public List checkUser(User user);

	public void createUser(User user);

	public List<User>  isUserExist(User user);

}
