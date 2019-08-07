package org.yabo.sharding.shardingsphere.service.impl;

import org.springframework.stereotype.Service;
import org.yabo.sharding.shardingsphere.bean.Student;
import org.yabo.sharding.shardingsphere.dao.StudentMapper;
import org.yabo.sharding.shardingsphere.service.StudentService;

import javax.annotation.Resource;


@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    public StudentMapper studentMapper;

    public boolean insert(Student student) {
        return studentMapper.insert(student) > 0;
    }

}