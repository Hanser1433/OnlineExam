package com.onlinejudge.test002.mapper;

import com.onlinejudge.test002.pojo.Admin;
import com.onlinejudge.test002.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    @Select("SELECT * FROM admin WHERE username = #{username}")
    Admin findByUsername(String username);
    @Insert("INSERT INTO admin (username, password) VALUES (#{username}, #{password})")
    void save(Admin admin);
    @Update("UPDATE admin SET password = #{password}, email = #{email}, username=#{username} WHERE id = #{id}")
    boolean updateByAdminId(Admin admin);
    @Select("SELECT * FROM admin WHERE id = #{id}")
    Admin getById(Integer id);

}
