package com.team.house.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Type;
import com.team.house.entity.TypeExample;
import com.team.house.mapper.TypeMapper;
import com.team.house.service.TypeService;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public PageInfo<Type> getTypeByPage(PageUtil pageUtil) {
        PageHelper.startPage( pageUtil.getPage(),pageUtil.getRows() );
        TypeExample typeExample=new TypeExample();
        List<Type> typeList = typeMapper.selectByExample( typeExample );
        PageInfo<Type> info=new PageInfo<Type>( typeList );
        return info;
    }

    @Override
    public int add(Type type) {
        return typeMapper.insertSelective( type );
    }

    @Override
    public Type getType(Integer id) {
        return typeMapper.selectByPrimaryKey( id );
    }

    @Override
    public int update(Type type) {
        return typeMapper.updateByPrimaryKeySelective( type );
    }
    @Override
    public List<Type> getList() {
        TypeExample typeExample=new TypeExample();
        return typeMapper.selectByExample( typeExample );
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public int delMoreType(List<Integer> ids) {
        return 0;
    }
}
