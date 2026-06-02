package com.volunteer.volunteerplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.volunteer.volunteerplatform.entity.Volunteer;

public interface VolunteerService extends IService<Volunteer> {
    Volunteer findByUserId(Integer userId);
    Volunteer createVolunteer(Integer userId);
}