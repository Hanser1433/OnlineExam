package com.onlinejudge.test002.service;

import com.onlinejudge.test002.pojo.Admin;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    Admin findByUsername(String username);
    void save(Admin admin);
    boolean updateByAdminId(Admin admin);

    Admin getById(Integer id);
}
