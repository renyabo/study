package org.yabo.common.beans;

import org.yabo.common.anno.CheckEntity;

public class Company {
    private Long id;
    private String name;

    public String getName() {
        return name;
    }

    @CheckEntity(key = "#name")
    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}