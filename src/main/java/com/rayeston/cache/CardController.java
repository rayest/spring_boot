package com.rayeston.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/card/cache/put", method = RequestMethod.GET)
    public Card putCache(Card card) {
        return cardService.save(card);
    }

    @RequestMapping(value = "/card/cache/able", method = RequestMethod.GET)
    public Card EnableCache(Card card) {
        return cardService.findOne(card);
    }

    @RequestMapping(value = "/card/cache/evit/{id}", method = RequestMethod.GET)
    public String evitCache(@PathVariable("id") Long id) {
        cardService.remove(id);
        return "OK";
    }

}
