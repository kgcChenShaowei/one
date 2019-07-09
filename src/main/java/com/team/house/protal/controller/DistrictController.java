package com.team.house.protal.controller;

import com.team.house.entity.District;
import com.team.house.entity.Type;
import com.team.house.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 王建兵
 * @Classname UserController
 * @Description TODO
 * @Date 2019/7/1 8:52
 * @Created by Administrator
 */
@Controller("districtController2")
@RequestMapping("/page/")
public class DistrictController {

    @Autowired
    private UsersService userService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private DistrictService districtService;
    @Autowired
    private StreetService streetService;

    @RequestMapping("goDistrict")
    @ResponseBody
    public List<District> gostreet(){
        List<District> allDistrict = districtService.getList();
        return allDistrict;   //进入发布出租房页面
    }

}
