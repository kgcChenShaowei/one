package com.team.house.service;


import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.utils.HouseCondition;
import com.team.house.utils.PageUtil;

import java.util.List;

public interface HouseService {
    //分页
    public PageInfo<House> getHouseByPage(PageUtil pageUtil);
    //添加
    public int add(House house);
    //单条回显
    public House getHouse(String id);
    //修改
    public int update(House house);
    //单条删除
    public int delete(Integer id);
    //批量删除
    public int delMoreHouse(List<Integer> ids);
    public PageInfo<House> getAllHouse(Integer uid,PageUtil pageUtil);
    public int houseIsPass(String id, Integer ispass);
    public PageInfo<House> getHouseByIsPass(PageUtil pageUtil,Integer ispass);
    public PageInfo<House> getBorswerHouse(HouseCondition condition);
}
