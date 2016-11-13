package com.rayeston.transaction;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
public interface AnimalService {
    Animal saveWithRollback(Animal animal);

    Animal saveWithoutRollback(Animal animal);
}
