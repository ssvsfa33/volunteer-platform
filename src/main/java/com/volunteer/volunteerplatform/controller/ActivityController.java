package com.volunteer.volunteerplatform.controller;

import com.volunteer.volunteerplatform.entity.Activity;
import com.volunteer.volunteerplatform.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/activity")
@CrossOrigin
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        List<Activity> activities = activityService.findAllActivities();
        result.put("data", activities);
        return result;
    }

    @PostMapping("/add")
    public Map<String, Object> add(@RequestBody Activity activity) {
        Map<String, Object> result = new HashMap<>();
        activity.setStatus("招募中");
        activityService.save(activity);
        result.put("success", true);
        result.put("message", "添加成功");
        return result;
    }

    @PostMapping("/join")
    public Map<String, Object> join(@RequestBody Map<String, Integer> params) {
        Map<String, Object> result = new HashMap<>();
        Integer activityId = params.get("activityId");
        Integer volunteerId = params.get("volunteerId");
        boolean success = activityService.joinActivity(activityId, volunteerId);
        result.put("success", success);
        result.put("message", success ? "报名成功" : "报名失败");
        return result;
    }

    @GetMapping("/{id}")
    public Map<String, Object> getDetail(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        Activity activity = activityService.getById(id);
        result.put("data", activity);
        return result;
    }
}