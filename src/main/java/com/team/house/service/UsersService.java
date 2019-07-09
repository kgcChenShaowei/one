package com.team.house.service;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.utils.PageUtil;

import java.util.List;

public interface UsersService {
    //分页
    public PageInfo<Users> getUsersByPage(PageUtil pageUtil);
    //添加
    public int add(Users users);
    //单条回显
    public Users getUsers(Integer id);
    //修改
    public int update(Users users);
    //下拉列表
    public List<Users> getList();
    //单条删除
    public int delete(Integer id);
    //批量删除
    public int delMoreUsers(List<Integer> ids);

    int checkUserName(String name);

    Users login(String name, String password);
}
