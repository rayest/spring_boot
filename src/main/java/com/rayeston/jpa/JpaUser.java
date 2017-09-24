package com.rayeston.jpa;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by lirui on 2017/9/24.
 */

@Data
@Entity
@Table(name = "jpa_user")
public class JpaUser {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer age;

}
