package com.team.house.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.*;
import com.team.house.mapper.*;
import com.team.house.service.HouseService;
import com.team.house.utils.HouseCondition;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private UsersMapper usersMapper;
    @Override
    public PageInfo<House> getHouseByPage(PageUtil pageUtil) {
        PageHelper.startPage( pageUtil.getPage(),pageUtil.getRows() );
        HouseExample houseExample=new HouseExample();
        List<House> houses = houseMapper.selectByExample( houseExample );
        if(houses!=null){
            for(House house:houses){
                Integer streetId = house.getStreetId();
                Integer typeId = house.getTypeId();
                Integer userId = house.getUserId();
                Street street = streetMapper.selectByPrimaryKey( streetId );
                Integer id1 = street.getDistrictId();
                District district = districtMapper.selectByPrimaryKey( id1 );
                street.setDistrict( district );
                house.setStreet( street );
                Type type = typeMapper.selectByPrimaryKey( typeId );
                house.setType( type );
                Users users = usersMapper.selectByPrimaryKey( userId );
                house.setUsers( users );
            }
        }
        PageInfo<House> info=new PageInfo<House>( houses );

        return info;
    }

    @Override
    public int add(House house) {
        return houseMapper.insertSelective( house );
    }

    @Override
    public House getHouse(String id) {
        House house = houseMapper.getHouse( id );
        return house;
    }

    @Override
    public int update(House house) {
        return houseMapper.updateByPrimaryKeySelective( house );
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int delMoreHouse(List<Integer> ids) {
        return 0;
    }
    @Override
    public PageInfo<House> getAllHouse(Integer uid,PageUtil pageUtil) {
        PageHelper.startPage( pageUtil.getPage(),pageUtil.getRows() );
        List<House> houses = houseMapper.getHouseByUserId( uid );

        PageInfo<House> info=new PageInfo<House>( houses );
        return info;
    }

    @Override
    public PageInfo<House> getHouseByIsPass(PageUtil page,Integer ispass) {
        PageHelper.startPage(page.getPage(),page.getRows());
        //查询所有
        List<House> list=houseMapper.getHouseByIsPass(ispass);
        if(list!=null){
            for(House house:list){
                Integer streetId = house.getStreetId();
                Integer typeId = house.getTypeId();
                Integer userId = house.getUserId();
                Street street = streetMapper.selectByPrimaryKey( streetId );
                Integer id1 = street.getDistrictId();
                District district = districtMapper.selectByPrimaryKey( id1 );
                street.setDistrict( district );
                house.setStreet( street );
                Type type = typeMapper.selectByPrimaryKey( typeId );
                house.setType( type );
                Users users = usersMapper.selectByPrimaryKey( userId );
                house.setUsers( users );
            }
        }
        return new PageInfo<House>(list);
    }

    @Override
    public int houseIsPass(String id, Integer ispass) {
        House house=new House();
        house.setId(id);
        house.setIspass(ispass);

        return houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getBorswerHouse(HouseCondition condition) {
        //调用mapperh
        PageHelper.startPage(condition.getPage(),condition.getRows());

        //将查询条件传递给dao层
        List<House> list=houseMapper.getBorswerHouse(condition);
        if(list!=null){
            for(House house:list){
                Integer streetId = house.getStreetId();
                Integer typeId = house.getTypeId();
                Integer userId = house.getUserId();
                Street street = streetMapper.selectByPrimaryKey( streetId );
                Integer id1 = street.getDistrictId();
                District district = districtMapper.selectByPrimaryKey( id1 );
                street.setDistrict( district );
                house.setStreet( street );
                Type type = typeMapper.selectByPrimaryKey( typeId );
                house.setType( type );
                Users users = usersMapper.selectByPrimaryKey( userId );
                house.setUsers( users );
            }
        }
        PageInfo<House> pageInfo=new PageInfo<House>(list);
        return pageInfo;
    }

}
