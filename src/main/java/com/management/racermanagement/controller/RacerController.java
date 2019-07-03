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

    @PostMapping("/save")
    public Racer saveRacer(@RequestBody Racer racer) throws Exception {
        return racerService.save(racer);
    }

    @PostMapping("/saveAll")
    public List<Racer> saveAllRacers(@RequestBody List<Racer> racers) throws Exception {
        return racerService.saveAll(racers);
    }

    @GetMapping("/findAll")
    public List<Racer> getAllRacers() throws Exception {
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

    @PostMapping("/update")
    public Racer updateRacer(@RequestBody Racer racer) throws Exception {
        return racerService.update(racer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRacerById(@PathVariable(value = "id") int racerId) throws Exception {
        racerService.deleteById(racerId);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        racerService.deleteAll();
    }

}
