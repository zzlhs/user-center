package com.free.user.db.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.free.base.entity.BasePo;
import lombok.Data;


@Data
@TableName("com/free/user")
public class UserPo extends BasePo {

    private String headerUrl;

    private String nickName;

    private String name;

    private String pwd;

    private String mobileNumber;

    private String idCard;

    private Integer age;

    private Integer sex;

    private String weChatId;

    private String emailStr;

}
