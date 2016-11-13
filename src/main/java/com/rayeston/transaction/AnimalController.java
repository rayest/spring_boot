package com.rayeston.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
@RestController
public class AnimalController {
    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = "/animal/rollback", method = RequestMethod.GET)
    public Animal rollback(Animal animal) {
        return animalService.saveWithRollback(animal);
    }

    @RequestMapping(value = "/animal/rollback/not", method = RequestMethod.GET)
    public Animal rollbackNot(Animal animal) {
        return animalService.saveWithoutRollback(animal);
    }

}
