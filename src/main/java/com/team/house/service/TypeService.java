package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.utils.PageUtil;

import java.util.List;

public interface TypeService {
    //分页
    public PageInfo<Type> getTypeByPage(PageUtil pageUtil);
    //添加
    public int add(Type type);
    //单条回显
    public Type getType(Integer id);
    //修改
    public int update(Type type);
    //下拉列表
    public List<Type> getList();
    //单条删除
    public int delete(Integer id);
    //批量删除
    public int delMoreType(List<Integer> ids);
}
