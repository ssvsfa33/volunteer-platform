package com.volunteer.volunteerplatform.controller;

import com.volunteer.volunteerplatform.entity.Registration;
import com.volunteer.volunteerplatform.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    // 获取报名列表
    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        List<Registration> list = registrationService.list();  // MyBatis Plus 方法
        result.put("data", list);
        return result;
    }

    // 用户报名活动
    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody Registration registration) {
        Map<String, Object> result = new HashMap<>();
        registrationService.save(registration);  // MyBatis Plus 方法
        result.put("success", true);
        result.put("message", "报名成功");
        return result;
    }

    // 审核报名
    @PutMapping("/audit")
    public Map<String, Object> audit(@RequestBody Registration registration) {
        Map<String, Object> result = new HashMap<>();
        registrationService.saveOrUpdate(registration);  // MyBatis Plus 方法
        result.put("success", true);
        result.put("message", "审核成功");
        return result;
    }

    // 删除报名
    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        registrationService.removeById(id);  // MyBatis Plus 方法
        result.put("success", true);
        result.put("message", "删除成功");
        return result;
    }
}