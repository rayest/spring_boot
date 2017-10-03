package com.rayeston.auth.entity;


import com.rayeston.auth.commons.BaseEntity;

import java.io.Serializable;

/**
 * Created by dello on 2016/7/27.
 */
public class Role extends BaseEntity implements Serializable {

    public Role() {
    }

    private Long id;
    private String name;

    public Role(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
