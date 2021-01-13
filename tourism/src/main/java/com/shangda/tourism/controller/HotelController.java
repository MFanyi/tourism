package com.shangda.tourism.controller;

import com.shangda.tourism.service.HotelService;
import com.shangda.tourism.util.JSONUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
public class HotelController {
    @Resource
    private HotelService hotelService;

    @RequestMapping(path = "hotel",method = RequestMethod.GET)
    public String findAllHotels(Integer pageNum,Integer row){
        Map<String,Object> map = hotelService.findHotels(pageNum,row);
        return JSONUtil.getJSONString(0,"success",map);
    }
}
