package com.volunteer.volunteerplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volunteer.volunteerplatform.entity.User;
import com.volunteer.volunteerplatform.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User findByUsername(String username) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, username);
        return getOne(wrapper);
    }

    @Override
    public boolean register(User user) {
        User existing = findByUsername(user.getUsername());
        if (existing != null) {
            return false;
        }
        if (user.getRole() == null) {
            user.setRole("user");
        }
        return save(user);
    }

    @Override
    public User login(String username, String password) {
        User user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}