package com.rayeston.h2;

import io.swagger.annotations.Api;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by lirui on 2017/10/5.
 */
@Api("h2内存数据库")
@Data
@Entity
public class H2User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String name;

    @Column
    private Short age;

    @Column
    private BigDecimal balance;


}
