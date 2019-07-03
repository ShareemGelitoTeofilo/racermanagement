package com.management.racermanagement.service;

import com.management.racermanagement.racer.Racer;
import com.management.racermanagement.repository.RacerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class RacerServiceImpl implements RacerService {

    @Autowired
    RacerRepository racerRepository;

    @Override
    public Racer save(Racer racer) throws Exception {
        if(racerRepository.findByName(racer.getName()) != null){
            throw new Exception("Racer with a name \"" + racer.getName() + "\" already exist.");
        }
        return racerRepository.save(racer);
    }

    @Override
    public Racer findById(int id) throws Exception {
        return racerRepository.findById(id).orElseThrow(() -> new Exception("Racer with ID " + id + " not found."));
    }

    @Override
    public void deleteById(int id) throws Exception {
        Racer racer = findById(id);
        racerRepository.deleteById(racer.getId());
    }

    @Override
    public Racer findByName(String name) throws Exception {
        Racer racer = racerRepository.findByName(name);
        if(racer == null){
            throw new Exception("Racer not found");
        }
        return racer;
    }

    @Override
    public List<Racer> findAll() throws Exception {
        List<Racer> racers = racerRepository.findAll();
        if(racers.isEmpty()){
            throw new Exception("No records found.");
        }
        return racers;
    }

    @Override
    public Racer update(Racer racer) throws Exception {
        Racer existingRacer = findById(racer.getId());

        Racer racerWithSameName = racerRepository.findByName(racer.getName());
        if (racerWithSameName != null && existingRacer.getId() != racerWithSameName.getId()) {
            throw new Exception("Name is already used.");
        } else {
            existingRacer.setName(racer.getName());
            existingRacer.setSpeed(racer.getSpeed());
        }
        return racerRepository.save(existingRacer);
    }

    @Override
    public void deleteAll() {
        racerRepository.deleteAll();
    }

    @Override
    public List<Racer> saveAll(List<Racer> racers) throws Exception {

        for(Racer racer: racers){
            if(racerRepository.findByName(racer.getName()) != null){
                throw new Exception("One or more racers already exists.");
            }
        }

        return racerRepository.saveAll(racers);
    }

}
