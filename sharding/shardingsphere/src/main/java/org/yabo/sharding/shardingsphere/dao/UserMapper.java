package org.yabo.sharding.shardingsphere.dao;


import org.yabo.sharding.shardingsphere.bean.User;

import java.util.List;

public interface UserMapper {

    Integer insert(User u);

    List<User> findAll();

    List<User> findByUserIds(List<Integer> userIds);


}