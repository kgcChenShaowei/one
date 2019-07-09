package com.team.house.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.entity.Users;
import com.team.house.entity.UsersExample;
import com.team.house.mapper.UsersMapper;
import com.team.house.service.UsersService;
import com.team.house.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public PageInfo<Users> getUsersByPage(PageUtil pageUtil) {
        PageHelper.startPage( pageUtil.getPage(),pageUtil.getRows() );
        UsersExample usersExample=new UsersExample();
        List<Users> usersList = usersMapper.selectByExample( usersExample );
        PageInfo<Users> info=new PageInfo<Users>( usersList );
        return info;
    }

    @Override
    public int add(Users users) {
        users.setIsadmin( 0 );
        return usersMapper.insertSelective( users );
    }

    @Override
    public Users getUsers(Integer id) {
        return usersMapper.selectByPrimaryKey( id );
    }

    @Override
    public int update(Users users) {
        return usersMapper.updateByPrimaryKeySelective( users );
    }

    @Override
    public List<Users> getList() {
        UsersExample usersExample=new UsersExample();

        return usersMapper.selectByExample( usersExample );
    }

    @Override
    public int delete(Integer id) {
        return usersMapper.deleteByPrimaryKey( id );
    }

    @Override
    public int delMoreUsers(List<Integer> ids) {
        return usersMapper.delUsers( ids );
    }

    @Override
    public int checkUserName(String name) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo( name );
        List<Users> list = usersMapper.selectByExample( usersExample );
        return list.size();
    }

    @Override
    public Users login(String name, String password) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andNameEqualTo( name );
        criteria.andPasswordEqualTo( password );
        List<Users> list = usersMapper.selectByExample( usersExample );
        if(list.size()==1){
            return list.get( 0 );
        }
        return null;
    }
}
