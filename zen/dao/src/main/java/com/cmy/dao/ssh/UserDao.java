package com.cmy.dao.ssh;

import com.cmy.model.ssh.User;

import java.io.Serializable;

public interface UserDao {

	/**
	 * 保存用户
	 * @param user
	 * @return
	 */
	Serializable save(User user);
}
