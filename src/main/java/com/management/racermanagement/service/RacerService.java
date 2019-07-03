package com.management.racermanagement.service;

import com.management.racermanagement.racer.Racer;

import java.util.List;

public interface RacerService {
    Racer save(Racer racer) throws Exception;
    Racer findById(int id) throws Exception;
    List<Racer> findAll();
    void deleteById(int id) throws Exception;
    Racer findByName(String name) throws Exception;
    Racer update(Racer racer) throws Exception;
}
