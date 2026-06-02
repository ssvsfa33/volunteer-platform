package com.volunteer.volunteerplatform.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volunteer.volunteerplatform.entity.Activity;
import com.volunteer.volunteerplatform.entity.Registration;
import com.volunteer.volunteerplatform.mapper.ActivityMapper;
import com.volunteer.volunteerplatform.mapper.RegistrationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl extends ServiceImpl<ActivityMapper, Activity> implements ActivityService {

    @Autowired
    private RegistrationMapper registrationMapper;

    @Override
    public List<Activity> findAllActivities() {
        return list();
    }

    @Override
    public boolean joinActivity(Integer activityId, Integer volunteerId) {
        Registration registration = new Registration();
        registration.setActivityId(activityId);
        registration.setVolunteerId(volunteerId);
        registration.setStatus("已报名");
        registrationMapper.insert(registration);
        return true;
    }
}