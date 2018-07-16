package com.example.challenge7.config;

import com.example.challenge7.model.Day;
import org.springframework.data.repository.CrudRepository;

public interface DaysRepository extends CrudRepository<Day, Long> {
}
