package com.volunteer.volunteerplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("volunteer")
public class Volunteer {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String skills;
    private Integer totalHours;
}