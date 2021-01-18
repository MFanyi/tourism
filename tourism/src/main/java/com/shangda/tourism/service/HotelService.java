package com.shangda.tourism.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shangda.tourism.dao.HotelDao;
import com.shangda.tourism.model.Area;
import com.shangda.tourism.model.Hotel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {
    @Resource
    private HotelDao hotelDao;

    public Map<String,Object> findHotels(Integer pageNum,Integer row){
        Map<String,Object> map = new HashMap<>();
        PageHelper.startPage(pageNum, row);
        List<Hotel> list = hotelDao.selectHotel();
        PageInfo<Hotel> pageInfo = new PageInfo<>(list);
        map.put("hotels",pageInfo);
        return map;
    }

    public Map<String,Object> findHotHotels(){
        Map<String,Object> map = new HashMap<>();
        List<Hotel> hotels = hotelDao.selectHotHotel();
        map.put("hotHotels",hotels);
        return map;
    }
}
