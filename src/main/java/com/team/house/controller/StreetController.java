package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Street;
import com.team.house.service.StreetService;
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
public class StreetController {
    @Autowired
    private StreetService streetService;

    @RequestMapping("getStreet")
    @ResponseBody
    public Map<String,Object> getstreet(PageUtil pageUtil){
        PageInfo<Street> info = streetService.getStreetByPage( pageUtil );
        Map<String,Object> map=new HashMap<String,Object>(  );
        map.put( "total",info.getTotal() );
        map.put( "rows",info.getList() );
        return map;
    }
    @RequestMapping("getStreet3")
    @ResponseBody
    public Map<String,Object> getStreet3(Integer id,PageUtil pageUtil){
        PageInfo<Street> info = streetService.getStreetById( id,pageUtil );
        Map<String,Object> map=new HashMap<String,Object>(  );
        map.put( "total",info.getTotal() );
        map.put( "rows",info.getList() );
        return map;
    }
    @RequestMapping("addStreet")
    @ResponseBody
    public String addStreet(Street street){
        //添加
        int add = streetService.add( street );
        return "{\"result\":"+add+"}";
    }
    @RequestMapping("upStreet")
    @ResponseBody
    public Street upStreet(Integer id){
        //回显
        Street street = streetService.getStreet( id );
        return street;
    }
    @RequestMapping("updateStreet")
    @ResponseBody
    public String updateStreet(Street street){
        //修改
        int update = streetService.update( street );
        return "{\"result\":"+update+"}";
    }
    @RequestMapping("getStreet2")
    @ResponseBody
    public List<Street> getStreet2(){
        //下拉列表
        List<Street> list = streetService.getList();
        return list;
    }
    @RequestMapping("deleteStreet")
    @ResponseBody
    public String deleteStreet(Integer id){
        //单条删除
        int delete = streetService.delete( id );
        return "{\"result\":"+delete+"}";
    }
    @RequestMapping("delMoreStreet")  //?id=1,2,3,4
    @ResponseBody
    public String delMoreStreet(String id) {//接收编号，名称
        //分割字符串
        String[] arys = id.split(",");
        //转化为List
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < arys.length; i++) {
            list.add(Integer.parseInt(arys[i]));
        }
        //调用业务
        int temp = streetService.delMoreStreet(list);
        return "{\"result\":" + temp + "}";
    }
}
