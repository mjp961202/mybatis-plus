package com.min.mptest.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        if (metaObject.hasSetter("createTime"))
            this.setFieldValByName("createTime",new Date(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        if (getFieldValByName("updateTime", metaObject) == null)
            this.setFieldValByName("updateTime",new Date(),metaObject);
    }
}
