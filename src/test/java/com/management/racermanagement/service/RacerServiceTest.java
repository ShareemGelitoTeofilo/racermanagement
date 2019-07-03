package com.management.racermanagement.service;

import com.management.racermanagement.RacermanagementApplicationTests;
import com.management.racermanagement.racer.Racer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void findByIdTest() throws Exception {
        Racer racer = racerService.findById(1);
        assertNotNull(racer);
    }

    @Test
    public void updateTest() throws Exception {
        Racer racer = racerService.findById(2);
        System.out.println("Updating name of: " + racer.getName());
        racer.setName("Shareem Gelito Teofilo");
        Racer updatedRacer = racerService.save(racer);
        assertNotNull(updatedRacer);

        System.out.println("New name: " + updatedRacer.getName());
    }

    @Test
    public void deleteTest() throws Exception {
        Racer racer = saveRacer();
        racerService.deleteById(racer.getId());
    }

    @Test
    public void findByNameTest(){
        Racer racer = racerService.findByName("Sharee1m");
        assertNotNull(racer);
    }

    private Racer saveRacer() throws Exception {
        Racer racer = new Racer(UUID.randomUUID().toString(), 3000);
        return racerService.save(racer);
    }

}
