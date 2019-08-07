package org.yabo.sharding.shardingsphere.dao;


import org.yabo.sharding.shardingsphere.bean.Student;

import java.util.List;

public interface StudentMapper {
    Integer insert(Student s);

    List<Student> findAll();

    List<Student> findByStudentIds(List<Integer> studentIds);
}