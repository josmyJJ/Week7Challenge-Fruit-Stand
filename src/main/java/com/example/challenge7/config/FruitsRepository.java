package com.example.challenge7.config;

import com.example.challenge7.model.Fruits;
import org.springframework.data.repository.CrudRepository;

public interface FruitsRepository extends CrudRepository<Fruits, Long> {
    //   I have to add the stuff here because it is many fruits

}
