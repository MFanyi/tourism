package com.shangda.tourism.dao;

import com.shangda.tourism.model.Area;

import java.util.List;

public interface AreaDao {
    void insertArea(Area area);

    List<Area> selectArea();

    List<Area> selectHotArea();

    Area selectThisArea(Integer id);
}
