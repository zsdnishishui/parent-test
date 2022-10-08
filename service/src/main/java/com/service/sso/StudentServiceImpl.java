package com.service.sso;


import com.common.entity.Student;
import com.mapper.sso.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student getUser(Integer id) {
        return studentMapper.getByUserId(id);
    }

    @Override
    public Student getUserById(Integer id) {
        return studentMapper.getUserById(id);
    }
}
