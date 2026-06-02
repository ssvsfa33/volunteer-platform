package com.volunteer.volunteerplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volunteer.volunteerplatform.entity.Volunteer;
import com.volunteer.volunteerplatform.mapper.VolunteerMapper;
import org.springframework.stereotype.Service;

@Service
public class VolunteerServiceImpl extends ServiceImpl<VolunteerMapper, Volunteer> implements VolunteerService {

    @Override
    public Volunteer findByUserId(Integer userId) {
        LambdaQueryWrapper<Volunteer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Volunteer::getUserId, userId);
        return getOne(wrapper);
    }

    @Override
    public Volunteer createVolunteer(Integer userId) {
        Volunteer volunteer = new Volunteer();
        volunteer.setUserId(userId);
        volunteer.setSkills("");
        volunteer.setTotalHours(0);
        save(volunteer);
        return volunteer;
    }
}