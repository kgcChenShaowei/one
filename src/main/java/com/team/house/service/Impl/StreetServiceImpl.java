package com.team.house.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.Street;
import com.team.house.entity.StreetExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.StreetService;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {
    @Autowired
    private StreetMapper streetMapper;
    @Autowired
    private DistrictMapper districtMapper;

    @Override
    public PageInfo<Street> getStreetByPage(PageUtil pageUtil) {
        PageHelper.startPage( pageUtil.getPage(),pageUtil.getRows() );
        StreetExample streetExample=new StreetExample();
        List<Street> streets = streetMapper.selectByExample( streetExample );
        for(Street street:streets){
            Integer id = street.getDistrictId();
            District district = districtMapper.selectByPrimaryKey( id );
            street.setDistrict( district );
        }
        PageInfo<Street> info=new PageInfo<Street>( streets );
        return info;
    }

    @Override
    public PageInfo<Street> getStreetById(Integer id, PageUtil pageUtil) {
        PageHelper.startPage( pageUtil.getPage(),pageUtil.getRows() );
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo( id );
        List<Street> streets = streetMapper.selectByExample( streetExample );
        for(Street street:streets){
            Integer id1 = street.getDistrictId();
            District district = districtMapper.selectByPrimaryKey( id1 );
            street.setDistrict( district );
        }
        PageInfo<Street> info=new PageInfo<Street>( streets );
        return info;
    }

    @Override
    public int add(Street street) {
        return streetMapper.insertSelective( street );
    }

    @Override
    public Street getStreet(Integer id) {
        return streetMapper.selectByPrimaryKey( id );
    }

    @Override
    public int update(Street street) {
        return streetMapper.updateByPrimaryKeySelective( street );
    }

    @Override
    public List<Street> getAllStreet(Integer id){
        StreetExample streetExample=new StreetExample();
        StreetExample.Criteria criteria = streetExample.createCriteria();
        criteria.andDistrictIdEqualTo( id );
        List<Street> streets = streetMapper.selectByExample( streetExample );
        return streets;
    }
    @Override
    public int delete(Integer id) {
        return streetMapper.deleteByPrimaryKey( id );
    }
    @Override
    public List<Street> getList() {
        StreetExample streetExample=new StreetExample();

        return streetMapper.selectByExample( streetExample );
    }

    @Override
    public int delMoreStreet(List<Integer> ids) {
        return 0;
    }
}
