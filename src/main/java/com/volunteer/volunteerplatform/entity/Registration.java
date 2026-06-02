package com.volunteer.volunteerplatform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("registration")
public class Registration {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer activityId;
    private Integer volunteerId;
    private String status;
}