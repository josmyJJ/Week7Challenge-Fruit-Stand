package com.example.challenge7.config;

import com.example.challenge7.model.Fruit;
import org.springframework.data.repository.CrudRepository;

public interface FruitsRepository extends CrudRepository<Fruit, Long> {
    //   I have to add the stuff here because it is many fruits

}
