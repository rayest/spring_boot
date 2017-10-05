package com.rayeston.h2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.assertEquals;

/**
 * Created by lirui on 2017/10/5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class H2UserRepositoryTest {
    @Resource
    private H2UserRepository h2UserRepository;

    @Test
    public void testFindById() throws Exception {
        H2User h2User = h2UserRepository.findOne(1L);
        assertEquals("lee", h2User.getUsername());
    }
}
