package com.min.mptest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.min.mptest.mapper.MptestMapper;
import com.min.mptest.pojo.Mptest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.*;

@SpringBootTest
public class MptestApplicationTests {

    @Resource
    private MptestMapper mapper;

    //添加
    @Test
    public void test() {
        Mptest mptest = new Mptest();
        mptest.setId(8);
        mptest.setName("zxc");
        mptest.setAge(23);
        mptest.setGender(1);
        mptest.setCreateTime(new Date());
        mptest.setRemark("test");
        mapper.insert(mptest);
    }

    //查询全部
    @Test
    public void contextLoads() {
        List<Mptest> mptests = mapper.selectList(null);
        mptests.forEach(System.out::println);
    }

    //指定id查询
    @Test
    public void test1() {
        Mptest mptest = mapper.selectById(1);
        System.out.println(mptest);
    }

    //多id查询
    @Test
    public void test2() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        List<Mptest> mptests = mapper.selectBatchIds(integers);
        mptests.forEach(System.out::println);
    }

    //map查询
    @Test
    public void test3() {
        Map<String, Object> map = new HashMap<>();
//        map.put("name","东方");
//        map.put("age",19);
        map.put("gender",1);
        List<Mptest> mptests = mapper.selectByMap(map);
        mptests.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void test4(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","方").ge("age",30);
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void test5(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("name","方").between("age",20,50).isNotNull("gender");
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void test6(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeLeft("name","方").or().le("age",30).orderByDesc("id");
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void test7(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        //queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}","2020-11-22").likeLeft("name","方");
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}","2020-11-22")
                .inSql("id","select id from mptest where name like '%方'");
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void test8(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.likeLeft("name","方").and(wq->wq.gt("age",30).or().likeRight("name","西"));
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void test9(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.nested(wq->wq.lt("age",50).or().gt("age",20)).likeLeft("name","方");
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void test10(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("age",Arrays.asList(19,29,39));
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //条件查询
    @Test
    public void test11(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.in("age",Arrays.asList(19,29,39)).last("limit 0,1");
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //指定查询列+排除列
    @Test
    public void test12(){
        QueryWrapper<Mptest> queryWrapper = new QueryWrapper<>();
        //queryWrapper.select("name","id","create_time").like("name","方");
        queryWrapper.select(Mptest.class,info->!info.getColumn().equals("create_time")).like("name","方");
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //控制参数查询
    @Test
    public void test13(){
        String name="方";
        String date="";
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.like(!"".equals(name),"name","方").like(!"".equals(date),"create_time","2020");
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //实体类查询
    @Test
    public void test14(){
        Mptest mptest=new Mptest();
        mptest.setName("zxc");
        QueryWrapper<Mptest> queryWrapper = new QueryWrapper<>(mptest);
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //返回map
    @Test
    public void test15(){
        QueryWrapper<Mptest> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age",Arrays.asList(19,29,39));
        List<Map<String, Object>> maps = mapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    //返回数量
    @Test
    public void test16(){
        QueryWrapper<Mptest> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age",Arrays.asList(19,29,39));
        Integer integer = mapper.selectCount(queryWrapper);
        System.out.println(integer);
    }

    //返回一条
    @Test
    public void test17(){
        QueryWrapper<Mptest> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age",Arrays.asList(19));
        Mptest mptest = mapper.selectOne(queryWrapper);
        System.out.println(mptest);
    }

    //lambda--防误写
    @Test
    public void test18(){
        LambdaQueryWrapper<Mptest> queryWrapper= Wrappers.<Mptest>lambdaQuery();
        queryWrapper.like(Mptest::getName,"方").lt(Mptest::getAge,40);
        List<Mptest> mptests = mapper.selectList(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //自定义方法
    @Test
    public void test19(){
        LambdaQueryWrapper<Mptest> queryWrapper= Wrappers.<Mptest>lambdaQuery();
        queryWrapper.like(Mptest::getName,"方").lt(Mptest::getAge,40);
        List<Mptest> mptests = mapper.selectAll(queryWrapper);
        mptests.forEach(System.out::println);
    }

    //分页
    @Test
    public void testPage(){
        QueryWrapper<Mptest> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","方");
        Page<Mptest> page=new Page<>(2,3);
        //不查询总记录数
        //Page<Mptest> page=new Page<>(2,3,false);
        IPage<Mptest> iPage = mapper.selectPage(page, queryWrapper);
        System.out.println("总记录"+iPage.getTotal());
        System.out.println("总页数"+iPage.getPages());
        System.out.println("当前页"+iPage.getCurrent());
        System.out.println("每页显示的数量"+iPage.getSize());
        List<Mptest> records = iPage.getRecords();
        records.forEach(System.out::println);
    }

    //更新
    @Test
    public void testUpd(){
        Mptest mptest =new Mptest();
        mptest.setId(6);
        mptest.setName("testUpd");
        int byId = mapper.updateById(mptest);
        System.out.println(byId);
    }
    //更新
    @Test
    public void testUpd1(){
        UpdateWrapper<Mptest> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",7);
        Mptest mptest =new Mptest();
        mptest.setName("testUpd1");
        int byId = mapper.update(mptest,updateWrapper);
        System.out.println(byId);
    }

    //更新
    @Test
    public void testUpd2(){
        UpdateWrapper<Mptest> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",7).set("name","testUpd2");
        int byId = mapper.update(null,updateWrapper);
        System.out.println(byId);
    }

    //删除
    @Test
    public void testDelete(){
        int i = mapper.deleteById(7);
        System.out.println(i);
    }

    //条件删除
    @Test
    public void testDelete1(){
        QueryWrapper<Mptest> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",8);
        int delete = mapper.delete(queryWrapper);
        System.out.println(delete);
    }
}
