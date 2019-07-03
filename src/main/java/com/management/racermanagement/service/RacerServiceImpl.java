package com.management.racermanagement.service;

import com.management.racermanagement.racer.Racer;
import com.management.racermanagement.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
class RacerServiceImpl implements RacerService {

    @Autowired
    RacerRepository racerRepository;

    @Override
    public Racer save(Racer racer) throws Exception {
        Racer existingRacer = findByName(racer.getName());

        if(existingRacer != null){
            throw new Exception("Racer already exist");
        }

        return racerRepository.save(racer);
    }

    @Override
    public Racer findById(int id) throws Exception {
        return racerRepository.findById(id).orElseThrow(() -> new Exception("Racer not found."));
    }

    @Override
    public void deleteById(int id) {
        racerRepository.deleteById(id);
    }

    @Override
    public Racer findByName(String name) {
        return racerRepository.findFirstByName(name);
    }
}
