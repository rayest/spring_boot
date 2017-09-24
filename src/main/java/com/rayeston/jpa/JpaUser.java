package com.rayeston.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

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

    @Column(nullable = false, name = "create_date")
    private Date createDate;

}
