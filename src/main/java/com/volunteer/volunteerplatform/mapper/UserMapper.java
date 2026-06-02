package com.volunteer.volunteerplatform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.volunteer.volunteerplatform.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}