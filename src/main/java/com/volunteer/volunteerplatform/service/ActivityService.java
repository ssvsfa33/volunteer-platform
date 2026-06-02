package com.volunteer.volunteerplatform.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.volunteer.volunteerplatform.entity.Activity;
import java.util.List;

public interface ActivityService extends IService<Activity> {
    List<Activity> findAllActivities();
    boolean joinActivity(Integer activityId, Integer volunteerId);
}