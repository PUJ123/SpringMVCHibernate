package com.journaldev.spring.dao;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.User;


@Repository
public class MyDairyDaoImpl implements MyDairyDao {
	
	// @Resource(name = "hibernate4AnnotatedSessionFactory")
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
    
	@Override
	public List<User>  checkUser(User user) {
		String query="SELECT * FROM USER WHERE EMAIL='"+user.getEmail()+"'";
		List<User> myUser = new ArrayList();
		try {
			// myUser = this.sessionFactory.getCurrentSession().createQuery(query).list();
			//Query query= this.sessionFactory.getCurrentSession().createQuery(query).list();
			/* Criteria crit = sessionFactory.getCurrentSession().createCriteria(User.class);
			  crit.add(Restrictions.eq("Email", user.getEmail())); //assuming Employee entity has "email" field
			  return  crit.list();*/
			
			return this.sessionFactory.getCurrentSession().createSQLQuery(query).list();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return myUser;
	}
	
	
}

