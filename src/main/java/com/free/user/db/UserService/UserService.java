package com.free.user.db.UserService;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.free.user.db.entity.UserPo;

public interface UserService extends IService<UserPo> {


    /**
     * 登陆用户，如果用户不存在直接用name注册，带有默认密码
     * @param name
     * @param pwd
     * @return
     */
    SaResult login(String name, String pwd);

    /**
     * 注册账号
     * @param flag
     * @return
     */
    SaResult register(String flag);



}
