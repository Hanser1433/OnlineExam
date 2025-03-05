package com.onlinejudge.test002.mapper;

import com.onlinejudge.test002.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    //调用findByUsername方法时，MyBatis会执行该方法上@Select注解指定的SQL语句，并处理查询结果。如果查询成功并返回了数据，
    // MyBatis会使用Student类的属性来映射这些数据，并创建一个或多个Student对象（取决于查询结果的数量）。然后，这些对象会
    // 被返回给方法的调用者。
    @Select("SELECT * FROM student WHERE username = #{username}")
    Student findByUsernameAndPassword(String username);
    @Insert("INSERT INTO student (sid,name,username, password,email,phone) VALUES (#{sid},#{name},#{username}, #{password},#{email},#{phone})")
    void save(Student student);

    // 修改操作
   @Update("UPDATE student SET password = #{password}, email = #{email},phone=#{phone}, sid=#{sid}, name=#{name}, username=#{username} WHERE id = #{id}")
    boolean updateByStudentId(Student student);

    // 删除操作
    @Delete("DELETE FROM student WHERE id = #{id}")
    boolean deleteByStudentId(Integer id);
    @Select("SELECT * FROM student")
    List<Student> getList();

    void batchDelete(@Param("ids") List<Integer> ids);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getById(Integer id);
}
