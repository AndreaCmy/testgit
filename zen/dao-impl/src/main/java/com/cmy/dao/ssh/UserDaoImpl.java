package com.cmy.dao.ssh;

import java.io.Serializable;

import com.cmy.dao.ssh.UserDao;
import com.cmy.model.ssh.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Serializable save(User user) {
		return sessionFactory.getCurrentSession().save(user);
	}

}
