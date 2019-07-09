package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.utils.PageUtil;

import java.util.List;

public interface StreetService {
    //分页
    public PageInfo<Street> getStreetByPage(PageUtil pageUtil);
    public PageInfo<Street> getStreetById(Integer id, PageUtil pageUtil);
    //添加
    public int add(Street street);
    //单条回显
    public Street getStreet(Integer id);
    //修改
    public int update(Street street);
    //单条删除
    public int delete(Integer id);
    //下拉列表
    public List<Street> getList();
    //批量删除
    public int delMoreStreet(List<Integer> ids);
    public List<Street> getAllStreet(Integer id);
}
