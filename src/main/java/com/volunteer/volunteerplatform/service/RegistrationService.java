package com.volunteer.volunteerplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.volunteer.volunteerplatform.entity.Registration;
import java.util.List;

public interface RegistrationService extends IService<Registration> {
    List<Registration> findByVolunteerId(Integer volunteerId);
    boolean cancelRegistration(Integer registrationId);
}