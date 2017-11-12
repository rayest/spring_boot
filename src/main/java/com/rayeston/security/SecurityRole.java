package com.rayeston.security;

import io.swagger.annotations.Api;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by lirui on 2017/10/3.
 */
@Api("角色")
@Data
@Entity
public class SecurityRole implements Serializable {

    private static final long serialVersionUID = -8094938057884395784L;
    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
