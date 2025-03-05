package com.onlinejudge.test002.service;

import com.onlinejudge.test002.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {
    Student findByUsername(String username);
    void save(Student student);
    boolean updateByStudentId(Student student);
    boolean deleteByStudentId(Student student);
    List<Student> getList();
    public void batchDeleteStudents(List<Integer> ids);

    Student getById(Integer id);
}
