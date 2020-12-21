package com.min.mptest.pojo;

import com.baomidou.mybatisplus.annotation.SqlCondition;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("mptest")
public class Mptest implements Serializable {
    @TableId("id")
    private Integer id;
    @TableField("name")
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("gender")
    private Integer gender;
    @TableField("create_time")
    private Date createTime;
    @TableField(exist = false)
    private String remark;
}
