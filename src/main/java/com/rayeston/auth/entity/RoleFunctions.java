package com.rayeston.auth.entity;

import com.rayeston.auth.commons.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by dello on 2016/7/27.
 */
@Data
public class RoleFunctions extends BaseEntity implements Serializable {
    private Long Id;
    private Long roleId;
    private Long functionId;
    private int status;

    public RoleFunctions() {
    }

    public RoleFunctions(Long id, Long roleId, Long functionId, int status) {
        Id = id;
        this.roleId = roleId;
        this.functionId = functionId;
        this.status = status;
    }
}
