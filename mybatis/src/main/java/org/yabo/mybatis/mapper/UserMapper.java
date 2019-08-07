package org.yabo.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.yabo.common.beans.User;

import java.util.List;

@Mapper
public interface UserMapper {

    int insert(User user);

    List<User> query();

    User queryById(@Param("id") Long id);

    int updateNameById(@Param("id") Long id, @Param("userName") String userName);

    int deleteById(@Param("id") Long id);
}
