package com.volunteer.volunteerplatform.controller;

import com.volunteer.volunteerplatform.entity.User;
import com.volunteer.volunteerplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取所有用户
     */
    @GetMapping("/list")
    public Map<String, Object> list() {
        Map<String, Object> result = new HashMap<>();
        try {
            List<User> users = userService.list();
            result.put("code", 200);
            result.put("message", "success");
            result.put("data", users);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", e.getMessage());
        }
        return result;
    }

    /**
     * 根据ID查询用户
     */
    @GetMapping("/{id}")
    public Map<String, Object> getById(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            User user = userService.getById(id);
            result.put("code", 200);
            result.put("message", "success");
            result.put("data", user);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", e.getMessage());
        }
        return result;
    }

    /**
     * 新增用户
     */
    @PostMapping
    public Map<String, Object> save(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = userService.save(user);
            result.put("code", 200);
            result.put("message", success ? "保存成功" : "保存失败");
            result.put("data", success);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", e.getMessage());
        }
        return result;
    }

    /**
     * 更新用户
     */
    @PutMapping
    public Map<String, Object> update(@RequestBody User user) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = userService.updateById(user);
            result.put("code", 200);
            result.put("message", success ? "更新成功" : "更新失败");
            result.put("data", success);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", e.getMessage());
        }
        return result;
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    public Map<String, Object> delete(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            boolean success = userService.removeById(id);
            result.put("code", 200);
            result.put("message", success ? "删除成功" : "删除失败");
            result.put("data", success);
        } catch (Exception e) {
            result.put("code", 500);
            result.put("message", e.getMessage());
        }
        return result;
    }
}