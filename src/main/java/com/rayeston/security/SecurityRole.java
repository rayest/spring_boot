package com.rayeston.security;

import io.swagger.annotations.Api;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by lirui on 2017/10/3.
 */
@Api("角色")
@Data
@Entity
public class SecurityRole {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
