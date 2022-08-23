package com.free.user.db.UserService;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.extension.service.IService;
import com.free.user.db.entity.UserPo;

public interface UserService extends IService<UserPo> {


    SaResult login(String name, String pwd);

    /**
     * 注册账号
     * @param flag
     * @return
     */
    SaResult register(String flag);



}
