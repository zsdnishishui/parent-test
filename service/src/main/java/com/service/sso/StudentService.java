package com.service.sso;


import com.common.entity.Student;
import org.springframework.data.relational.core.sql.In;


public interface StudentService {

    public Student getUser(Integer id);

    public Student getUserById(Integer id);
}
