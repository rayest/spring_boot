package com.rayeston.thread;

/**
 * Created by lirui on 2017/4/13.
 */

public class UnsafeSequence {

    private int value;

    public int getNext() {
        return value++;
    }

}
