package com.onlinejudge.test002.controller;

import com.onlinejudge.test002.pojo.Admin;
import com.onlinejudge.test002.pojo.Student;
import com.onlinejudge.test002.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*") // 允许所有域名的跨域请求
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        System.out.println("Received username: " + username);
        System.out.println("Received password: " + password);

        Admin admin = adminService.findByUsername(username);//向Service传递username，调用find,返回学生对象
        if (admin != null) {
            System.out.println("Found admin with username: " + username);
            if (admin.getPassword().equals(password)) {
                System.out.println("Login successful for user: " + username); // 控制台输出登录成功消息
                Integer id=admin.getId();
                return String.valueOf(id);
            } else {
                System.out.println("Incorrect password for user: " + username);
                return "Invalid username or password";
            }
        } else {
            String notFoundMessage="No admin found with username: " + username;
            System.out.println(notFoundMessage);
            return notFoundMessage;
        }
    }
    @PostMapping("/register")
    public String register(@RequestBody Admin admin) {
        Admin existingAdmin = adminService.findByUsername(admin.getUsername());
        if (existingAdmin != null) {
            return "Username already exists";
        }

        adminService.save(admin);
        return "Registration successful";
    }

    /**
     * 修改
     * @param admin
     * @return
     */
    @PostMapping("/update")
    public String updateStu(@RequestBody Admin admin){
        adminService.updateByAdminId(admin);
        return "update successful";
    }

    /**
     * 根据id获取
     * @return
     */
    @GetMapping("/getById")
    public Admin getById(@RequestParam Integer id){
        return adminService.getById(id);
    }
}