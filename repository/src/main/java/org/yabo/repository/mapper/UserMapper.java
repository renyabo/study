package org.yabo.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.cache.annotation.Cacheable;
import org.yabo.common.anno.CheckEntity;
import org.yabo.common.beans.User;

import java.util.List;

public interface UserMapper {

    int insert(User user);

    List<User> query();

//    @Cacheable(value = "user", key = "#root.args[0]")
//    User queryById(@Param("id") Long id);

    @CheckEntity(key = "#root.args[0]")
    User queryById(@Param("id") Long id);

    @CheckEntity(key = "root.args[0]")
    int updateNameById(@Param("id") Long id, @Param("userName") String userName);

    @CheckEntity(key = "#root.args[0]")
    int deleteById(@Param("id") Long id);
}
