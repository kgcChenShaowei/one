package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.House;
import com.team.house.service.HouseService;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/index/")
public class HouseController {
    @Autowired
    private HouseService houseService;


    @RequestMapping("add")
    @ResponseBody
    public String add(House house){
        return null;
    }


    @RequestMapping("upHouse")
    @ResponseBody
    public House upHouse(String id){
        //回显
        House house = houseService.getHouse( id );
        return house;
    }
    @RequestMapping("updateHouse")
    @ResponseBody
    public String updateHouse(House house){
        //修改
        int update = houseService.update( house );
        return "{\"result\":"+update+"}";
    }
    @RequestMapping("deleteHouse")
    @ResponseBody
    public String deleteHouse(Integer id){
        //单条删除
        int delete = houseService.delete( id );
        return "{\"result\":"+delete+"}";
    }
    @RequestMapping("delMoreHouse")  //?id=1,2,3,4
    @ResponseBody
    public String delMoreHouse(String id) {//接收编号，名称
        //分割字符串
        String[] arys = id.split(",");
        //转化为List
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arys.length; i++) {
            list.add(Integer.parseInt(arys[i]));
        }
        //调用业务
        int temp = houseService.delMoreHouse(list);
        return "{\"result\":" + temp + "}";
    }

    //查询未审核的功能
    @RequestMapping("getHouseNoPass")
    @ResponseBody
    public Map<String,Object> getHouseNoPass(PageUtil page, Model model){
        //调用业务   0表示未审核
        PageInfo<House> pageInfo=houseService.getHouseByIsPass(page,0);
        //创建map
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }
    //查询审核的功能
    @RequestMapping("getHouseYesPass")
    @ResponseBody
    public Map<String,Object> getHouseYesPass(PageUtil page, Model model){
        //调用业务   0表示未审核
        PageInfo<House> pageInfo=houseService.getHouseByIsPass(page,1);
        //创建map
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("total",pageInfo.getTotal());
        map.put("rows",pageInfo.getList());
        return map;
    }

    //通过审核
    @RequestMapping("houseYes")
    @ResponseBody
    public String houseYes(String id){
        //调用业务   1表示审核
        int temp=houseService.houseIsPass(id,1);
        return "{\"result\":"+temp+"}";
    }

    //不通过审核
    @RequestMapping("houseNo")
    @ResponseBody
    public String houseNo(String id){
        //调用业务   1表示审核
        int temp=houseService.houseIsPass(id,0);
        return "{\"result\":"+temp+"}";
    }

    @RequestMapping("gethouse")
    @ResponseBody
    public Map<String,Object> getindex(PageUtil pageUtil){
        PageInfo<House> info = houseService.getHouseByPage( pageUtil );
        Map<String,Object> map=new HashMap<String,Object>(  );
        map.put( "total",info.getTotal() );
        map.put( "rows",info.getList() );
        return map;
    }
}
