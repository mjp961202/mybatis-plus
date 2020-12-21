package com.min.mptest.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.min.mptest.pojo.Mptest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MptestMapper extends BaseMapper<Mptest> {

    List<Mptest> selectAll(@Param(Constants.WRAPPER) Wrapper<Mptest> wrapper);
}
