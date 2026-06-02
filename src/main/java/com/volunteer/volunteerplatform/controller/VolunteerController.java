package com.volunteer.volunteerplatform.controller;

import com.volunteer.volunteerplatform.entity.Volunteer;
import com.volunteer.volunteerplatform.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/volunteer")
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    // 获取志愿者列表
    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        List<Volunteer> list = volunteerService.list();
        result.put("data", list);
        return result;
    }

    // 添加志愿者
    @PostMapping("/save")
    public Map<String, Object> save(@RequestBody Volunteer volunteer) {
        Map<String, Object> result = new HashMap<>();
        volunteerService.save(volunteer);
        result.put("success", true);
        result.put("message", "添加成功");
        return result;
    }

    // 更新志愿者信息
    @PutMapping("/update")
    public Map<String, Object> update(@RequestBody Volunteer volunteer) {
        Map<String, Object> result = new HashMap<>();
        volunteerService.saveOrUpdate(volunteer);
        result.put("success", true);
        result.put("message", "更新成功");
        return result;
    }

    // 删除志愿者
    @DeleteMapping("/delete/{id}")
    public Map<String, Object> delete(@PathVariable Integer id) {
        Map<String, Object> result = new HashMap<>();
        volunteerService.removeById(id);
        result.put("success", true);
        result.put("message", "删除成功");
        return result;
    }
}