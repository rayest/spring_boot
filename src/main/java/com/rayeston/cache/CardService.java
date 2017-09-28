package com.rayeston.cache;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
public interface CardService {
    Card create(Card card);

    Card getById(long id);

    void deleteById(Long id);

 }
