package com.journaldev.spring.dao;


import java.util.ArrayList;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.journaldev.spring.model.Person;
import com.journaldev.spring.model.User;


@Repository
public class MyDairyDaoImpl implements MyDairyDao {

	// @Resource(name = "hibernate4AnnotatedSessionFactory")

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User>  checkUser(User user) {
		List<User> userList = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			userList = session.createQuery("from User").list();

		}catch (Exception e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public void createUser(User user) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.persist(user);


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<User> isUserExist(User user) {
		List<User> result = new ArrayList();
		try {
			/*Query query = this.sessionFactory.getCurrentSession().createQuery("from Student where name=:name");
			query.setParameter("name", "Raj");*/
			
			Criteria crit = sessionFactory.getCurrentSession()
					   .createCriteria(User.class).add(Restrictions.eq("email", user.getEmail()))
					   .add(Restrictions.eq("userName", user.getUserName()));

				 result = crit.list();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}


}

