package com.team.house.protal.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.entity.*;
import com.team.house.service.*;
import com.team.house.utils.HouseCondition;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author 王建兵
 * @Classname UserController
 * @Description TODO
 * @Date 2019/7/1 8:52
 * @Created by Administrator
 */
@Controller("houseController2")
@RequestMapping("/page/")
public class HouseController {

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

    //注册出租屋下拉列表，同步
    @RequestMapping("gofabu")
    public String fabu(Model model) throws  Exception{
        List<Type> typeList = typeService.getList();
        List<District> districtList = districtService.getList();
        model.addAttribute( "typeList",typeList );
        model.addAttribute( "districtList",districtList );
        return "fabu";   //进入发布出租房页面
    }

    //异步获得区域对应的街道
    @RequestMapping("gostreet")
    @ResponseBody
    public List<Street> gostreet(Integer id){
        List<Street> allStreet = streetService.getAllStreet( id );
        return allStreet;   //进入发布出租房页面
    }

    //添加新的出租房，上传图片
    @RequestMapping("addHouse")
    public String addHouse(House house, HttpSession session,
                           @RequestParam(name = "pfile",required = false) CommonsMultipartFile pfile) throws IOException {
        //1.实现图片上传：图片在图片服务器 d:/images
        String filename = pfile.getOriginalFilename();
        //1.jpg  上传文件名称
        String substring = filename.substring( filename.lastIndexOf( "." ) );
        String str=System.currentTimeMillis()+substring;//保存文件名称
        String path="d:/CHEN/"+str;//保存路径
        File file=new File( path );
        pfile.transferTo( file );
        //2.将输入的数据保存到数据库中
        house.setId( System.currentTimeMillis()+"" );
        Users user =(Users) session.getAttribute( "loginInfo" );
        house.setUserId( user.getId() );
        house.setPath(str);
        house.setIsdel( 0 );
        house.setIspass( 0 );

        int add = houseService.add( house );
        if(add==1){
            return "redirect:zhuye";
        }
        file.delete();
        return "redirect:gofabu";
    }

    //修改出租房信息回显
    @RequestMapping("updateHouse")
    public String updateHouse(String id,Model model) throws  Exception{
        House house = houseService.getHouse( id  );
        model.addAttribute( "house",house );
        return "updatefabu";
    }
    @RequestMapping("deleteHouse")
    public String deleteHouse(String id) throws  Exception{
        House house=new House();
        house.setId( id );
        house.setIsdel( 1 );
        int update = houseService.update( house );
        return "redirect:zhuye";
    }

    //添加新的出租房，上传图片
    @RequestMapping("updateHouse2")
    public String updateHouse(String oldPath,House house, HttpSession session,
                           @RequestParam(name = "pfile",required = false) CommonsMultipartFile pfile) throws IOException {

        //1.实现图片上传：图片在图片服务器 d:/images
        String filename = pfile.getOriginalFilename();
        if(!filename.equals( "" )){
            //1.jpg  上传文件名称
            String substring = filename.substring( filename.lastIndexOf( "." ) );
            String str=System.currentTimeMillis()+substring;//保存文件名称
            String path="d:/CHEN/"+str;//保存路径
            File file=new File( path );
            pfile.transferTo( file );
            //2.删除原有图片
            new File("d:/CHEN/"+oldPath).delete();
            house.setPath(str);
        }

        //2.将输入的数据保存到数据库中
        Users user =(Users) session.getAttribute( "loginInfo" );
        house.setUserId( user.getId() );
        house.setIsdel( 0 );
        house.setIspass( 0 );


        int update = houseService.update( house );
        if(update==1){
            return "redirect:zhuye";
        }
        return "redirect:zhuye";
    }

    @RequestMapping("getBroswerHouse")
    public String  getBroswerHouse(HouseCondition condition, Model model){
        //调用业务层
        PageInfo<House> pageInfo=houseService.getBorswerHouse(condition);
        model.addAttribute("pageInfo",pageInfo);
        //回显查询条件
        model.addAttribute("condition",condition);
        return  "list2";
    }


}
