package com.rayeston.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
@RestController
public class CardController {
    @Autowired
    private CardService cardService;

    @RequestMapping(value = "/card", method = RequestMethod.POST)
    public Card create(@RequestBody Card card) {
        return cardService.create(card);
    }

    @RequestMapping(value = "/card/id/{id}", method = RequestMethod.GET)
    public Card getById(@PathVariable("id") long id) {
        return cardService.getById(id);
    }

    @RequestMapping(value = "/card/id/{id}", method = RequestMethod.DELETE)
    public String deleteById(@PathVariable("id") Long id) {
        cardService.deleteById(id);
        return "OK";
    }
}
