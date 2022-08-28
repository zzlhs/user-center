package com.free.user.dubbo;

import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import com.free.user.api.UserCenterService;
import com.free.user.db.UserService.UserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
public class UserCenterServiceImpl implements UserCenterService {

    @Autowired
    private UserService userService;

    @Override
    public SaResult doLogin(String name, String pwd) {
        return userService.login(name, pwd);
    }

    @Override
    public SaResult isLogin() {
        return SaResult.ok("是否登录：" + StpUtil.isLogin());
    }

    @Override
    public SaResult tokenInfo() {
        return SaResult.data(StpUtil.getTokenInfo());
    }

    @Override
    public SaResult logout() {
        StpUtil.logout();
        return SaResult.ok();
    }
}
