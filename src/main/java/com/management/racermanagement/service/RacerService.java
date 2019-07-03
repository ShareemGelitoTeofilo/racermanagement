package com.management.racermanagement.service;

import com.management.racermanagement.racer.Racer;

import java.util.List;

public interface RacerService {
    Racer save(Racer racer) throws Exception;
    Racer findById(int id) throws Exception;
    void deleteById(int id);
    Racer findByName(String name);
    List<Racer> findAll();
    Racer update(Racer racer) throws Exception;
}
