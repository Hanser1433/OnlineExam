package com.onlinejudge.test002.service.impl;

import com.onlinejudge.test002.mapper.StudentMapper;
import com.onlinejudge.test002.pojo.Student;
import com.onlinejudge.test002.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student findByUsername(String username) {
        return studentMapper.findByUsernameAndPassword(username);
    }
    @Override
    public void save(Student student) {
        studentMapper.save(student);
    }
    @Override
    public boolean updateByStudentId(Student student) {
        return studentMapper.updateByStudentId(student);
    }

    @Override
    public boolean deleteByStudentId(Student student) {
        return studentMapper.deleteByStudentId(student.getId());
    }

    @Override
    public List<Student> getList() {
        return studentMapper.getList();
    }
    @Override
    public void batchDeleteStudents(List<Integer> ids) {
        studentMapper.batchDelete(ids);
    }

    @Override
    public Student getById(Integer id) {
        return studentMapper.getById(id);
    }
}
