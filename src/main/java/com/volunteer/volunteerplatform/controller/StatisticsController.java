package com.volunteer.volunteerplatform.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    /**
     * 获取数据概览（模拟数据）
     */
    @GetMapping("/overview")
    public Map<String, Object> getOverview() {
        Map<String, Object> data = new HashMap<>();
        data.put("code", 200);

        Map<String, Object> result = new HashMap<>();
        result.put("userCount", 128);
        result.put("activityCount", 24);
        result.put("totalParticipants", 456);
        result.put("adminCount", 5);
        result.put("serviceHours", 912);

        data.put("data", result);
        return data;
    }

    /**
     * 获取用户增长趋势
     */
    @GetMapping("/userTrend")
    public Map<String, Object> getUserTrend() {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);

        List<Map<String, Object>> trend = new ArrayList<>();
        String[] days = {"周一", "周二", "周三", "周四", "周五", "周六", "周日"};
        int[] counts = {3, 5, 2, 8, 6, 12, 9};

        for (int i = 0; i < 7; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("day", days[i]);
            item.put("count", counts[i]);
            trend.add(item);
        }

        response.put("data", trend);
        return response;
    }

    /**
     * 获取活动类型分布
     */
    @GetMapping("/activityType")
    public Map<String, Object> getActivityType() {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);

        List<Map<String, Object>> types = new ArrayList<>();
        types.add(createItem("未开始", 8));
        types.add(createItem("进行中", 12));
        types.add(createItem("已结束", 4));

        response.put("data", types);
        return response;
    }

    /**
     * 获取月度活动统计
     */
    @GetMapping("/monthlyActivity")
    public Map<String, Object> getMonthlyActivity() {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);

        List<Map<String, Object>> monthly = new ArrayList<>();
        String[] months = {"1月", "2月", "3月", "4月", "5月", "6月"};
        int[] values = {3, 5, 8, 6, 10, 7};

        for (int i = 0; i < 6; i++) {
            Map<String, Object> item = new HashMap<>();
            item.put("month", months[i]);
            item.put("count", values[i]);
            monthly.add(item);
        }

        response.put("data", monthly);
        return response;
    }

    private Map<String, Object> createItem(String name, int value) {
        Map<String, Object> item = new HashMap<>();
        item.put("name", name);
        item.put("value", value);
        return item;
    }
}