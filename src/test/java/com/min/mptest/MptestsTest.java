package com.min.mptest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.min.mptest.mapper.MptestsMapper;
import com.min.mptest.pojo.Mptests;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class MptestsTest {
    @Resource
    private MptestsMapper mapper;

    //逻辑删除++自己写的sql需要手动加上删除字段
    @Test
    public void test() {
        int i = mapper.deleteById(6);
        System.out.println(i);
        this.testSel();
    }

    @Test
    public void testSel() {
        List<Mptests> mptests = mapper.selectList(null);
        mptests.forEach(System.out::println);
    }

    @Test
    public void testSels() {
        QueryWrapper<Mptests> qw=new QueryWrapper<>();
        qw.eq("deleted",1);
        List<Mptests> mptest = mapper.selectList(qw);
        mptest.forEach(System.out::println);
    }
    //自动填充
    @Test
    public void testAdd() {
        Mptests mptests=new Mptests();
        //mptests.setId(22);
        mptests.setName("test");
        mptests.setAge(23);
        mptests.setGender(1);
        int insert = mapper.insert(mptests);
        System.out.println(insert);
    }

    //自动填充
    @Test
    public void testUpd() {
        Mptests mptests=new Mptests();
        mptests.setId(17);
        mptests.setName("testUpd");
        mptests.setAge(23);
        mptests.setGender(1);
        //mptests.setUpdateTime(new Date());
        int insert = mapper.updateById(mptests);
        System.out.println(insert);
    }

    //乐观锁
    @Test
    public void testV(){
        Integer v=2;
        Mptests mptests=new Mptests();
        mptests.setId(18);
        mptests.setName("testUpd1");
        mptests.setVersion(v);
        int i = mapper.updateById(mptests);
        System.out.println(i);
    }



}
