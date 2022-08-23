package com.free.user.db.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.free.user.db.entity.UserPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserPo> {
}
