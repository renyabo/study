package org.yabo.spring.cache.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.yabo.common.beans.User;

@Mapper
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public interface UserDAO {

    @Select("select * from user where id=#{id}")
    @Cacheable(value = "c.user", key = "#{id}")
    User queryById(@Param("id") Long id);

    @Insert("insert into user values(#{id},#{user_name},#{description})")
    int insert(User user);

    @Update("update user set user_name=#{userName} where id=#{id}")
    int update(@Param("id") Long id, @Param("userName") String userName);

    @Delete("delete from user where id=#{id}")
    int deleteById(@Param("id") Long id);
}
