package com.rayeston.h2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by lirui on 2017/10/5.
 */
@Repository
public interface H2UserRepository extends JpaRepository<H2User, Long>{
}
