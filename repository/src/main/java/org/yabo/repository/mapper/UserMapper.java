package org.yabo.repository.mapper;

import org.yabo.common.beans.User;

import java.util.List;

public interface UserMapper {
    int insert(User user);

    List<User> query();
}
