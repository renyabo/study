package org.yabo.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.yabo.common.beans.Book;

import java.util.List;

@Mapper
public interface BookMapper {
    List<Book> query();
}
