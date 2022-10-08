package com.mapper.sso;

import com.common.entity.Student;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface StudentMapper {

    public Student getUserById(Integer id);

    @Select("select * from student where id = #{id}")
    Student getByUserId(Integer id);
}
