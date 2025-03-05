package com.onlinejudge.test002.controller;

import com.onlinejudge.test002.pojo.Student;
import com.onlinejudge.test002.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*") // 允许所有域名的跨域请求
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        System.out.println("Received username: " + username);
        System.out.println("Received password: " + password);

        Student student = studentService.findByUsername(username);//向Service传递username，调用find,返回学生对象
        if (student != null) {
            System.out.println("Found student with username: " + username);
            if (student.getPassword().equals(password)) {
                System.out.println("Login successful for user: " + username); // 控制台输出登录成功消息
                Integer id=student.getId();
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
    public String register(@RequestBody Student student) {
        Student existingStudent = studentService.findByUsername(student.getUsername());
        if (existingStudent != null) {
            return "Username already exists";
        }

        studentService.save(student);
        return "Registration successful";
    }

    /**
     * 新增
     * @param student
     * @return
     */
    @PostMapping("/save")
    public String saveStu(@RequestBody Student student){
        studentService.save(student);
        return "save successful";
    }

    /**
     * 修改
     * @param student
     * @return
     */
    @PostMapping("/update")
    public String updateStu(@RequestBody Student student){
        studentService.updateByStudentId(student);
        return "update successful";
    }

    /**
     * 删除
     * @param student
     * @return
     */
    @PostMapping("/delete")
    public String deleteStu(@RequestBody Student student){
        studentService.deleteByStudentId(student);
        return "delete successful";
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/batchDelete")
    public String deleteStu(@RequestBody List<Integer> ids ){
        studentService.batchDeleteStudents(ids);
        return "batchDelete successful";
    }

    /**
     * 获取列表
     * @return
     */
    @GetMapping("/getList")
    public List<Student> getList(){
        return studentService.getList();
    }

    /**
     * 根据id获取
     * @return
     */
    @GetMapping("/getById")
    public Student getById(@RequestParam Integer id){
        return studentService.getById(id);
    }

}
