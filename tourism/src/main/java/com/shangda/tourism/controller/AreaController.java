package com.shangda.tourism.controller;

import com.shangda.tourism.service.AreaService;
import com.shangda.tourism.util.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class AreaController {
    @Resource
    private AreaService areaService;

    @RequestMapping(path = "area", method = RequestMethod.GET)
    public String areaAll(Integer pageNum, Integer row) {
        Map<String, Object> map = areaService.findAreaPage(pageNum, row);
        return JSONUtil.getJSONString(0, "success", map);
    }

    @RequestMapping(path = "hotArea", method = RequestMethod.GET)
    public String hotArea() {
        Map<String, Object> map = areaService.findHotArea();
        return JSONUtil.getJSONString(0, "success", map);
    }
}
