package com.rayeston.thymeleaf;

/**
 * Created by Rayest on 2016/8/30 0030.
 */
public class ThymeleafPersonEntity {
    private String name;
    private Integer age;

    public ThymeleafPersonEntity() {
    }

    public ThymeleafPersonEntity(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
