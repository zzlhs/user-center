package com.free.user.test;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.free.user.db.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录测试 
 * @author kong
 *
 */
@RestController
@RequestMapping("/acc/")
public class LoginController {

	@Autowired
	private UserService userService;

	// 测试登录  ---- http://localhost:8081/acc/doLogin?name=zhang&pwd=123456
	@RequestMapping("doLogin")
	public SaResult doLogin(String name, String pwd) {
		// 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
		return userService.login(name,pwd);
	}

	// 查询登录状态  ---- http://localhost:8081/acc/isLogin
	@RequestMapping("isLogin")
	public SaResult isLogin() {
		return SaResult.ok("是否登录：" + StpUtil.isLogin());
	}

	// 查询 Token 信息  ---- http://localhost:8081/acc/tokenInfo
	@RequestMapping("tokenInfo")
	public SaResult tokenInfo() {
		return SaResult.data(StpUtil.getTokenInfo());
	}
	
	// 测试注销  ---- http://localhost:8081/acc/logout
	@RequestMapping("logout")
	public SaResult logout() {
		StpUtil.logout();
		return SaResult.ok();
	}

	@RequestMapping("register")
	public SaResult register(String name) {
		return userService.register(name);
	}
	
}
