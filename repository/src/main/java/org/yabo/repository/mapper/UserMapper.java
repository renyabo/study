package org.yabo.repository.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yabo.common.beans.User;

public interface UserMapper {
    int insert(User user);
}
