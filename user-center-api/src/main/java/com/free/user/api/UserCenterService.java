package com.free.user.api;

import cn.dev33.satoken.util.SaResult;

/**
 * 向外提供的api
 */
public interface UserCenterService {

    SaResult doLogin(String name, String pwd);

    SaResult isLogin();

    SaResult tokenInfo();

    SaResult logout();
}
