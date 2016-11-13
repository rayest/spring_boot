package com.rayeston.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepository cardRepository;

    // 缓存新增的或更新的数据到缓存，其中缓存的名称是 cards, 数据的 key 是 card 的 id
    @Override
    @CachePut(value = "cards", key = "#card.id")
    public Card save(Card card) {
        Card card1 = cardRepository.save(card);
        System.out.println("为 id、key 为：" + card1.getId() + "数据做了缓存");
        return card1;
    }

    // 缓存 key 是 card 的 id 数据到缓存 cards 中
    @Override
    @Cacheable(value = "cards", key = "#card.id")
    public Card findOne(Card card) {
        Card card1 = cardRepository.findOne(card.getId());
        System.out.println("为id、key 为：" + card1.getId() + "的数据做了缓存 ");
        return card1;
    }

    // 从缓存 cards 中删除 key 为 id 的数据（数据中的数据也会被删掉）
    @Override
    @CacheEvict(value = "cards")
    public void remove(Long id) {
        System.out.println("删除了id、key 为" + id + "的数据缓存");
        cardRepository.delete(id);
    }
}
