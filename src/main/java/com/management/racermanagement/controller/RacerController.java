package com.management.racermanagement.controller;

import com.management.racermanagement.racer.Racer;
import com.management.racermanagement.service.RacerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/racers")
public class RacerController {

    @Autowired
    RacerService racerService;

    @PostMapping("/create")
    public Racer createRacer(@RequestBody Racer racer) throws Exception {
        return racerService.save(racer);
    }

    @GetMapping("/findAll")
    public List<Racer> getAllRacers(){
        return racerService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Racer getRacerById(@PathVariable(value = "id") int racerId) throws Exception {
        return racerService.findById(racerId);
    }

    @GetMapping("/findByName/{name}")
    public Racer getRacerByName(@PathVariable(value = "name") String name) throws Exception {
        return racerService.findByName(name);
    }

    // TODO
    @PostMapping("/update")
    public Racer updateRacer(@RequestBody Racer racer) throws Exception {
        return racerService.update(racer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRacerById(@PathVariable(value = "id") int racerId) throws Exception {
        racerService.deleteById(racerId);
    }

}
