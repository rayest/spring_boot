package com.rayeston.auth.entity;

import com.rayeston.auth.commons.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by dello on 2016/7/27.
 */
@Data
public class Functions extends BaseEntity implements Serializable {
    private Long id;
    private String name;
    private Long parentId;
    private String url;
    private int serialNum;
    private int accordion;

    public Functions() {
    }

    public Functions(Long id, String name, Long parentId, String url, int serialNum, int accordion) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.url = url;
        this.serialNum = serialNum;
        this.accordion = accordion;
    }

}
