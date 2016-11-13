package com.rayeston.cache;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
public interface CardService {
    Card save(Card card);

    Card findOne(Card card);

    void remove(Long id);
}
