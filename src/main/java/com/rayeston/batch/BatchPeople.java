package com.rayeston.batch;

import lombok.Data;

/**
 * Created by lirui on 2017/10/5.
 */
@Data
public class BatchPeople {

    private String lastName;
    private String firstName;

    public BatchPeople() {
    }

    public BatchPeople(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
