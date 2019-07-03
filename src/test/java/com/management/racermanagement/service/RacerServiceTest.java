package com.management.racermanagement.service;

import com.management.racermanagement.RacermanagementApplicationTests;
import com.management.racermanagement.racer.Racer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

public class RacerServiceTest extends RacermanagementApplicationTests {

    @Autowired
    RacerService racerService;

    @Test
    public void saveTest() throws Exception {
        Racer savedRacer = saveRacer();
        assertNotNull(savedRacer);
    }

    @Test
    public void saveAllTest() throws Exception {
        List<Racer> racers = new ArrayList<>();

        Racer racer1 = new Racer();
        racer1.setName("Batman");
        racer1.setSpeed(100);

        Racer racer2 = new Racer();
        racer2.setName("Hulk");
        racer2.setSpeed(200);

        racers.add(racer1);
        racers.add(racer2);

        List<Racer> savedRacers = racerService.saveAll(racers);
    }

    @Test
    public void findByIdTest() throws Exception {
        Racer racer = racerService.findById(1);
        assertNotNull(racer);
    }


    @Test
    public void deleteByIdTest() throws Exception {
        Racer racer = saveRacer();
        racerService.deleteById(racer.getId());
    }

    @Test
    public void deleteAll(){
        racerService.deleteAll();
    }

    @Test
    public void findByNameTest() throws Exception {
        Racer racer = racerService.findByName("Joker");
        assertNotNull(racer);
    }

    @Test
    public void findAllTest() throws Exception {
        List<Racer> racers = racerService.findAll();
        assertNotNull(racers);
    }

    @Test
    public void updateTest() throws Exception {
        Racer racer = new Racer();
        racer.setId(100);
        racer.setName("Superman");
        racer.setSpeed(400);
        Racer updatedRacer = racerService.update(racer);
    }

    private Racer saveRacer() throws Exception {
        Racer racer = new Racer(UUID.randomUUID().toString(), 3000);
        return racerService.save(racer);
    }

}
