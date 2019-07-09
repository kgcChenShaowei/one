package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.service.UsersService;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index/")
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("getUsers")
    @ResponseBody
    public Map<String,Object> getUsers(PageUtil pageUtil){
        PageInfo<Users> info = usersService.getUsersByPage( pageUtil );
        Map<String,Object> map=new HashMap<String,Object>(  );
        map.put( "total",info.getTotal() );
        map.put( "rows",info.getList() );
        return map;
    }
    @RequestMapping("addUsers")
    @ResponseBody
    public String addUsers(Users users){
        //添加
        int add = usersService.add( users );
        return "{\"result\":"+add+"}";
    }
    @RequestMapping("upUsers")
    @ResponseBody
    public Users upUsers(Integer id){
        //回显
        Users users = usersService.getUsers( id );
        return users;
    }
    @RequestMapping("updateUsers")
    @ResponseBody
    public String updateUsers(Users users){
        //修改
        int user = usersService.update( users );
        return "{\"result\":"+user+"}";
    }
    @RequestMapping("getUsers2")
    @ResponseBody
    public List<Users> getUsers2(){
        //下拉列表
        List<Users> list = usersService.getList();
        return list;
    }

    @RequestMapping("deleteUsers")
    @ResponseBody
    public String deleteUsers(Integer id){
        //单条删除
        int delete = usersService.delete( id );
        return "{\"result\":"+delete+"}";
    }
    @RequestMapping("delMoreUsers")  //?id=1,2,3,4
    @ResponseBody
    public String delMoreType(String id) {//接收编号，名称
        //分割字符串
        String[] arys = id.split(",");
        //转化为List
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arys.length; i++) {
            list.add(Integer.parseInt(arys[i]));
        }
        //调用业务
        int temp = usersService.delMoreUsers(list);
        return "{\"result\":" + temp + "}";
    }
}

