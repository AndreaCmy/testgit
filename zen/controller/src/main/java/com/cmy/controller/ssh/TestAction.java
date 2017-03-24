package com.cmy.controller.ssh;

import java.util.UUID;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.springframework.beans.factory.annotation.Autowired;

import com.cmy.vo.ssh.UserVo;
import com.cmy.service.ssh.UserService;
import com.opensymphony.xwork2.ActionSupport; 
import org.apache.struts2.convention.annotation.Result; 
//@Action(value = "strust2Test")
// 使用convention-plugin插件提供的@Action注解将一个普通java类标注为一个可以处理用户请求的Action，Action的名字为struts2Test
//每一个方法可以作为一个action访问，  使用actionName!functionName.action
//如果在方法上面单独设置了action，就不需要在class上面设置action了
@Namespace("/")
// 使用convention-plugin插件提供的@Namespace注解为这个Action指定一个命名空间
public class TestAction extends ActionSupport {

	private String username;
	private String userpass;

	/**
	 * 注入userService
	 */
	@Autowired
	private UserService userService;

	/**
	 * http://localhost:8080/web/test.action MethodName: test
	 * Description:
	 * 
	 */
	public void test() {
		System.out.println("进入TestAction");
		userService.test();
	}

	/**
	 * http://localhost:8080/web/saveUser.action
	 */
	@Action(value = "/saveUser", 
			results = { @Result(name = SUCCESS, location = "/welcome.jsp"),  
                        @Result(name = "failure", location = "/error.jsp") })
	public String saveUser() {
		UserVo user = new UserVo();
		user.setId(UUID.randomUUID().toString());
		user.setName(username);
		user.setPassword(userpass);
		userService.save(user);
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
}
