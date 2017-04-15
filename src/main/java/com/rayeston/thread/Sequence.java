package com.rayeston.thread;

/**
 * Created by lirui on 2017/4/13.
 */
public class Sequence {

    private int value;

    public synchronized int getNext() {
        return value++;
    }

}
