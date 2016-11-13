package com.rayeston.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Rayest on 2016/11/13 0013.
 */
@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Animal saveWithRollback(Animal animal) {
        Animal animal_1 = animalRepository.save(animal);
        if (animal_1.getName().equals("kimi")) {
            throw new IllegalArgumentException("kimi 已存在，数据将滚回");
        }
        return animal_1;
    }

    @Override
    @Transactional(noRollbackFor = {IllegalArgumentException.class})
    public Animal saveWithoutRollback(Animal animal) {
        Animal animal_2 = animalRepository.save(animal);
        if (animal_2.getName().equals("kimi")){
            throw new IllegalArgumentException("kimi 虽已存在，但数据不会滚回");
        }
        return animal_2;
    }
}
