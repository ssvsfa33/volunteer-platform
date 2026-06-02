package com.volunteer.volunteerplatform.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.volunteer.volunteerplatform.entity.Registration;
import com.volunteer.volunteerplatform.mapper.RegistrationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements RegistrationService {

    @Override
    public List<Registration> findByVolunteerId(Integer volunteerId) {
        LambdaQueryWrapper<Registration> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Registration::getVolunteerId, volunteerId);
        return list(wrapper);
    }

    @Override
    public boolean cancelRegistration(Integer registrationId) {
        Registration registration = getById(registrationId);
        if (registration != null) {
            registration.setStatus("已取消");
            return updateById(registration);
        }
        return false;
    }
}