package com.team.house.protal.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.House;
import com.team.house.entity.Type;
import com.team.house.entity.Users;
import com.team.house.service.*;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 王建兵
 * @Classname UserController
 * @Description TODO
 * @Date 2019/7/1 8:52
 * @Created by Administrator
 */
@Controller("userController2")
@RequestMapping("/page/")
public class UserController {

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


    /*检查用户名是否存在*/
    @RequestMapping("checkUname")
    @ResponseBody
    public String  checkUname(String name){
        //调用业务
       int temp=userService.checkUserName(name);
        return "{\"result\":"+temp+"}";
    }


    @RequestMapping("reg")
    public String reg(Users user) throws  Exception{
       //调用业务实现注册
       int temp=userService.add(user);
       if(temp>0){
           return "login";   //进入登入页面
       }else{
           return "regs";  //进入注册页面
       }
    }

    //通过用户名密码实现登入
    @RequestMapping("loginAction")
    public String loginAction(String name, String password, Model model, HttpSession session) throws  Exception{
        //调用业务实现注册
       Users user=userService.login(name,password);
        if (user == null) {
            model.addAttribute( "info", "用户名和密码不正确" );
            return "login";
        }
        //只要登入，使用session作用域保存登入的人
        session.setAttribute( "loginInfo", user );
        //设置保存的有效时间
        session.setMaxInactiveInterval( 600 );  //以秒
        if (user.getIsadmin() == 0) {
            List<Type> typeList = typeService.getList();
            List<District> districtList = districtService.getList();
            model.addAttribute( "typeList",typeList );
            model.addAttribute( "districtList",districtList );
            return "list";//普通用户登入后的页面
        } else {
            return "redirect:zhuye";//管理用户登入后的页面
        }
    }
    @RequestMapping("zhuye")
    public String getHouse(PageUtil pageUtil,HttpSession session,Model model) throws Exception{
        //调用业务
        //获取用户编号
        Integer uid=((Users)session.getAttribute("loginInfo")).getId();
        PageInfo<House> pageInfo=houseService.getAllHouse(uid,pageUtil);
        model.addAttribute("pageInfo",pageInfo);
        return "guanli";
    }


}
