package com.rayeston.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by lirui on 2017/9/24.
 */
@Repository("jpaUserRepository")
public interface JpaUserRepository extends JpaRepository<JpaUser, Long> {

    JpaUser findByName(String name);

    JpaUser findByNameAndAge(String name, Integer age);

    @Query("from JpaUser u where u.age = :age")
    JpaUser findUser(@Param("age") Integer age);

}
