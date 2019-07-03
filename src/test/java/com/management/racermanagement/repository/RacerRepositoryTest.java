package com.management.racermanagement.repository;

import com.management.racermanagement.RacermanagementApplicationTests;
import com.management.racermanagement.racer.Racer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class RacerRepositoryTest extends RacermanagementApplicationTests {

    @Autowired
    RacerRepository racerRepository;

    @Test
    public void createTest(){
        Racer racer = new Racer("Thanos", 1000);
        Racer savedRacer = racerRepository.save(racer);
        assertNotNull(savedRacer);
    }

    @Test
    public void findByIdTest(){
        Optional<Racer> racer = racerRepository.findById(1);
        assertTrue(racer.isPresent());
    }

    @Test
    public void updateTest(){
        Optional<Racer> optionalRacer = racerRepository.findById(1);
        Racer racer = optionalRacer.get();
        System.out.println("Updating name of: " + racer.getName());
        racer.setName("Shareem Teofilo");
        Racer updatedRacer = racerRepository.save(racer);
        assertNotNull(updatedRacer);

        System.out.println("New name: " + updatedRacer.getName());
    }

    @Test
    public void deleteByIdTest(){
        racerRepository.deleteById(3);
    }

    @Test
    public void deleteTest(){
        Racer racer = racerRepository.findById(1).get();
        racerRepository.delete(racer);
    }

    @Test
    public void findByNameTest(){
        Racer racer = racerRepository.findFirstByName("Shareem");
        assertNotNull(racer);
    }
    
    @Test
    public void findAllTest(){
        List<Racer> racers = racerRepository.findAll();
        assertFalse(racers.isEmpty());
    }
}
