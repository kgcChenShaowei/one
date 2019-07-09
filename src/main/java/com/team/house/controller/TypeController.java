package com.team.house.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.service.TypeService;
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
public class TypeController {
    @Autowired
    private TypeService typeService;

    @RequestMapping("getType")
    @ResponseBody
    public Map<String,Object> getType(PageUtil pageUtil){
        PageInfo<Type> info = typeService.getTypeByPage( pageUtil );
        Map<String,Object> map=new HashMap<String,Object>(  );
        map.put( "total",info.getTotal() );
        map.put( "rows",info.getList() );
        return map;
    }
    @RequestMapping("addType")
    @ResponseBody
    public String addType(Type type){
        //添加
        int add = typeService.add( type );
        return "{\"result\":"+add+"}";
    }
    @RequestMapping("upType")
    @ResponseBody
    public Type upType(Integer id){
        //回显
        Type type = typeService.getType( id );
        return type;
    }
    @RequestMapping("updateType")
    @ResponseBody
    public String updateType(Type type){
        //修改
        int update = typeService.update( type );
        return "{\"result\":"+update+"}";
    }
    @RequestMapping("getType2")
    @ResponseBody
    public List<Type> getType2(){
        //下拉列表
        List<Type> list = typeService.getList();
        return list;
    }
    @RequestMapping("deleteType")
    @ResponseBody
    public String deleteType(Integer id){
        //单条删除
        int delete = typeService.delete( id );
        return "{\"result\":"+delete+"}";
    }
    @RequestMapping("delMoreType")  //?id=1,2,3,4
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
        int temp = typeService.delMoreType(list);
        return "{\"result\":" + temp + "}";
    }
}
