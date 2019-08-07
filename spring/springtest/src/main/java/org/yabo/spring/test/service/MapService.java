package org.yabo.spring.test.service;

import org.springframework.stereotype.Service;
import org.yabo.common.beans.Book;
import org.yabo.common.beans.User;

import java.util.List;
import java.util.Map;

@Service
public class MapService {
    private Map<String, User> map;
    private Book book;
    private String test;
    private List<String> list;

    public MapService(Map<String, User> map, Book book, String test, List<String> list) {
        this.map = map;
        this.book = book;
        this.test = test;
        this.list = list;
    }

    public Map<String, User> getMap() {
        return map;
    }

    public void setMap(Map<String, User> map) {
        this.map = map;
    }
}
