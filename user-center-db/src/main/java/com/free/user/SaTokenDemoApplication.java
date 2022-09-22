package com.free.user;

import cn.dev33.satoken.SaManager;
import com.free.user.satoken.SaTokenConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Sa-Token整合SpringBoot 示例 
 * @author kong
 *
 */
//@EnableDiscoveryClient // 开启Spring Cloud的服务注册与发现
//@EnableDubbo
@SpringBootApplication
public class SaTokenDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaTokenDemoApplication.class, args);
		System.out.println("\n启动成功：Sa-Token配置如下：" + SaManager.getConfig());
	}
	
}
