package com.free.user.db.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import com.free.user.db.entity.UserPo;

@Mapper
public interface UserDao extends BaseMapper<UserPo> {
}
