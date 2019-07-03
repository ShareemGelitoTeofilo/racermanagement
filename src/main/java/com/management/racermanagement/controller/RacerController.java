package com.management.racermanagement.controller;

import com.management.racermanagement.racer.Racer;
import com.management.racermanagement.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/")
public class RacerController {

    @Autowired
    RacerService racerService;

    @PostMapping("/racers")
    public Racer createRacer(@RequestBody Racer racer) throws Exception {
        return racerService.save(racer);
    }

    @GetMapping("/racers")
    public List<Racer> getAllRacers(){
        return racerService.findAll();
    }

    @GetMapping("/racers/{id}")
    public Racer getRacerById(@PathVariable(value = "id") int racerId) throws Exception {
        return racerService.findById(racerId);
    }

    @PostMapping("/racers/update")
    public Racer updateRacer(@RequestBody Racer racer) throws Exception {
        Racer racerToUpdate = racerService.findById(racer.getId());
        racerToUpdate.setName(racer.getName());
        racerToUpdate.setSpeed(racer.getSpeed());
        return racerService.update(racerToUpdate);
    }


    @DeleteMapping("/racers/{id}")
    public void deleteRacerById(@PathVariable(value = "id") int racerId) {
        racerService.deleteById(racerId);
    }
}
