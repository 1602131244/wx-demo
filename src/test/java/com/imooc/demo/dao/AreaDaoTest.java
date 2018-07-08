package com.imooc.demo.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.imooc.demo.entity.Area;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING) // 按方法名大小升序执行
public class AreaDaoTest {
    //通过spring容器注入Dao的实现类
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        // 验证预期值和实际值是否相符
        assertEquals(2, areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(1);
        assertEquals("东苑", area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        //创建一个区域对象
        Area area = new Area();
        area.setAreaName("南苑");
        //area.setCreateTime(new Date());
        area.setPriority(1);
        //将该对象实例添加入库
        int effectedNum = areaDao.insertArea(area);
        //检测影响行数
        assertEquals(1, effectedNum);
        //校验总数是否+1
        List<Area> areaList = areaDao.queryArea();
        assertEquals(3, areaList.size());
    }

    @Test
    @Ignore
    public void upateArea() {
//        Area area = new Area();
//        area.setAreaName("西苑");
//        area.setPriority(3);
//        //area.setCreateTime(new Date());
//        area.setAreaId(5);
//        int effectedNum = areaDao.updateArea(area);
//        assertEquals(1, effectedNum);
        List<Area> areaList = areaDao.queryArea();
        for (Area area : areaList) {
            if ("西苑".equals(area.getAreaName())) {
                // 对比之前的priority值
                assertEquals(1, area.getPriority().intValue());
                area.setPriority(2);
                int effectedNum = areaDao.updateArea(area);
                assertEquals(1, effectedNum);
            }
        }
    }

    @Test
    public void deleteArea() {
//        List<Area> areaList = areaDao.queryArea();
//        for (Area area : areaList) {
//            if ("西苑".equals(area.getAreaName())) {
//                int effectedNum = areaDao.deleteArea(area.getAreaId());
//                assertEquals(1, effectedNum);
//            }
//        }
//        // 重新获取一次列表，看看总数是否少1
//        areaList = areaDao.queryArea();
//        assertEquals(2, areaList.size());

        int effectedNum = areaDao.deleteArea(6);
        assertEquals(1,effectedNum);
    }
}