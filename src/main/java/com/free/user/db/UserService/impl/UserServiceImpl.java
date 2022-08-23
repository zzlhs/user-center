package com.free.user.db.UserService.impl;

import cn.dev33.satoken.util.SaResult;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.free.base.entity.RequestDomain;
import com.free.base.util.UserHolder;
import com.free.user.db.UserService.UserService;
import com.free.user.db.dao.UserDao;
import com.free.user.db.entity.UserPo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserPo> implements UserService {


    public static final String DEFAULT_PWD = "123456";

    @Override
    public SaResult login(String name, String pwd) {
        UserPo userPo = getOne(new QueryWrapper<UserPo>().lambda()
                .eq(UserPo::getName, name));
        if(Objects.isNull(userPo)){
            return SaResult.error( "不存在此用户，请先注册！");
        }else{
            if(userPo.getPwd().equals(pwd)){
                return SaResult.ok( "登录成功！");
            }else{
                return SaResult.error( "登录失败,密码错误！");
            }
        }
    }

    @Override
    public SaResult register(String flag) {
        if(Objects.nonNull(flag) && flag.trim().length() > 0){
            UserPo userPoExisted = getOne(new QueryWrapper<UserPo>().lambda()
                    .eq(UserPo::getName, flag));
            if(Objects.nonNull(userPoExisted)){
                return SaResult.error( "您已注册，直接登陆！");
            }
            UserPo userPo = new UserPo();
            userPo.setId(getId());
            userPo.setName(flag);
            userPo.setNickName(flag);

            RequestDomain requestDomain = new RequestDomain();
            requestDomain.setCurrTime(new Date());
            requestDomain.setUserId("2");
            UserHolder.set(requestDomain);
            userPo.setInsertInfo();
            save(userPo);
        }else {
            return SaResult.error( "注册失败,密码不能为空！");
        }
        return SaResult.ok( "登录成功！");
    }

    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replace("_", ""));

        System.out.println(UUID.randomUUID().toString().replace("_", "").substring(0,32).length());

    }

    private String getId(){
        return UUID.randomUUID().toString().replace("_", "").substring(0, 32);
    }
}
