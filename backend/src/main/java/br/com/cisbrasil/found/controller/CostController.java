package br.com.cisbrasil.found.controller;

import br.com.cisbrasil.found.model.Cost;
import br.com.cisbrasil.found.service.CostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cost")
@CrossOrigin("https:/localhost:3000/")
public class CostController {
    @Autowired
    CostService service;
    @GetMapping
    List<Cost> findAll(){
        return service.findAll();
    }
    Cost save(@RequestBody Cost cost){
        return service.save(cost);
    }
    @DeleteMapping("{costId}")
    @ResponseStatus
    void delete(@PathVariable("costId") int costId){
        service.delete(costId);
    }
    @PatchMapping("{costId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    Cost update(@RequestBody Cost costToUpdate, @PathVariable("costId") int costId){
        return service.update(costToUpdate, costId);
    }
}