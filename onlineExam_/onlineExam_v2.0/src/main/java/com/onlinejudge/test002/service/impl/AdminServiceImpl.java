package com.onlinejudge.test002.service.impl;

import com.onlinejudge.test002.mapper.AdminMapper;
import com.onlinejudge.test002.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.onlinejudge.test002.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin findByUsername(String username){return adminMapper.findByUsername(username);}
    @Override
    public void save(Admin admin) {adminMapper.save(admin);}
    @Override
    public boolean updateByAdminId(Admin admin) {
        return adminMapper.updateByAdminId(admin);
    }

    @Override
    public Admin getById(Integer id) {
        return adminMapper.getById(id);
    }
}
