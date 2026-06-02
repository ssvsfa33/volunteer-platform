package com.volunteer.volunteerplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("activity")
public class Activity {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;
    private String description;
    private String location;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer maxVolunteers;
    private String status;          // ← 确保有这一行！
    private LocalDateTime createTime;
}