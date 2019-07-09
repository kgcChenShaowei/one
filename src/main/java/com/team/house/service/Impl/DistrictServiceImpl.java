package com.team.house.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.District;
import com.team.house.entity.DistrictExample;
import com.team.house.mapper.DistrictMapper;
import com.team.house.mapper.StreetMapper;
import com.team.house.service.DistrictService;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    @Autowired
    private StreetMapper streetMapper;

    @Override
    public PageInfo<District> getDistrictByPage(PageUtil pageUtil) {
        PageHelper.startPage( pageUtil.getPage(),pageUtil.getRows() );
        DistrictExample districtExample=new DistrictExample();
        List<District> districtList = districtMapper.selectByExample( districtExample );
        PageInfo<District> info=new PageInfo<District>( districtList );
        return info;
    }

    @Override
    public int add(District district) {
        return districtMapper.insertSelective( district );
    }

    @Override
    public District getDistrict(Integer id) {
        return districtMapper.selectByPrimaryKey( id );
    }

    @Override
    public int update(District district) {
        return districtMapper.updateByPrimaryKeySelective( district );
    }

    @Override
    public List<District> getList() {
        DistrictExample districtExample=new DistrictExample();
        return districtMapper.selectByExample( districtExample );
    }

    @Override
    @Transactional
    public int delete(Integer id) {

        return districtMapper.deleteByPrimaryKey( id );
    }

    @Override
    public int delMoreDistrict(List<Integer> ids) {
        return districtMapper.delDistrict( ids );
    }


}
