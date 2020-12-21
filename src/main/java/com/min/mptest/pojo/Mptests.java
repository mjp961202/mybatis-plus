package com.min.mptest.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
public class Mptests {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField("age")
    private Integer age;
    @TableField("gender")
    private Integer gender;
    @TableField(value = "deleted", select = false)
    @TableLogic
    private Integer deleted;
    @Version
    private Integer version;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
