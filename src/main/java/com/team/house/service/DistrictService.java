package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.utils.PageUtil;

import java.util.List;

public interface DistrictService {
    //分页
    public PageInfo<District> getDistrictByPage(PageUtil pageUtil);
    //添加
    public int add(District district);
    //单条回显
    public District getDistrict(Integer id);
    //修改
    public int update(District district);
    //下拉列表
    public List<District> getList();
    //单条删除
    public int delete(Integer id);
    //批量删除
    public int delMoreDistrict(List<Integer> ids);
}
