package com.management.racermanagement.repository;

import com.management.racermanagement.racer.Racer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RacerRepository extends JpaRepository<Racer, Integer> {
    Racer findByName(String name);
}
