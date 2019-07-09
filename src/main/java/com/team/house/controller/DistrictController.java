package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.service.DistrictService;
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
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    @RequestMapping("getDistrict")
    @ResponseBody
    public Map<String,Object> getDistrict(PageUtil pageUtil){
        //分页
        PageInfo<District> info = districtService.getDistrictByPage( pageUtil );
        Map<String,Object> map=new HashMap<String,Object>(  );
        map.put( "total",info.getTotal() );
        map.put( "rows",info.getList() );
        return map;
    }
    @RequestMapping("addDistrict")
    @ResponseBody
    public String addDistrict(District district){
        //添加
        int add = districtService.add( district );
        return "{\"result\":"+add+"}";
    }
    @RequestMapping("upDistrict")
    @ResponseBody
    public District upDistrict(Integer id){
        //回显
        District district = districtService.getDistrict( id );
        return district;
    }
    @RequestMapping("updateDistrict")
    @ResponseBody
    public String updateDistrict(District district){
        //修改
        int update = districtService.update( district );
        return "{\"result\":"+update+"}";
    }
    @RequestMapping("getDistrict2")
    @ResponseBody
    public List<District> getDistrict2(){
        //下拉列表
        List<District> list = districtService.getList();
        return list;
    }
    @RequestMapping("deleteDistrict")
    @ResponseBody
    public String deleteDistrict(Integer id){
        //单条删除
        int delete = districtService.delete( id );
        return "{\"result\":"+delete+"}";
    }
    @RequestMapping("delMoreDistrict")  //?id=1,2,3,4
    @ResponseBody
    public String delMoreDistrict(String id) {//接收编号，名称
        //分割字符串
        String[] arys = id.split(",");
        //转化为List
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arys.length; i++) {
            list.add(Integer.parseInt(arys[i]));
        }
        //调用业务
        int temp = districtService.delMoreDistrict(list);
        return "{\"result\":" + temp + "}";
    }
}
