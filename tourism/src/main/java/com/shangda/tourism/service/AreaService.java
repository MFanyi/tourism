package com.shangda.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangda.tourism.dao.AreaDao;
import com.shangda.tourism.model.Area;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaService {
    @Resource
    private AreaDao areaDao;

    public Map<String, Object> findAreaPage(Integer pageNum, Integer row) {
        Map<String, Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, row);
        List<Area> list = areaDao.selectArea();
        PageInfo<Area> pageInfo = new PageInfo<>(list);
        map.put("areaPage", pageInfo);
        return map;
    }

    public Map<String, Object> findHotArea() {
        Map<String, Object> map = new HashMap<>();
        List<Area> list = areaDao.selectHotArea();
        map.put("hotArea", list);
        return map;
    }

}
