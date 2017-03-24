package com.cmy.service.ssh;


import com.cmy.vo.ssh.UserVo;

import java.io.Serializable;


public interface UserService {
	/**
	 * 测试方法
	 */
	void test();

	/**
	 * 保存用户
	 * 
	 * @param user
	 * @return
	 */
	Serializable save(UserVo user);
}
