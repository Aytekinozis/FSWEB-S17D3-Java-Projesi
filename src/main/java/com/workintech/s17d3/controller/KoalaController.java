package com.workintech.s17d3.controller;

import com.workintech.s17d3.entity.Koala;
import com.workintech.s17d3.entity.Koala;
import com.workintech.s17d3.validation.ZooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map<Long,Koala> koalas;

    @PostConstruct
    public void init(){
        koalas = new HashMap<>();
    }
    @GetMapping
    public List<Koala> findAll() {
        return this.koalas.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Koala find(@PathVariable("id") Long id){
        ZooValidation.isIdValid(id);
        ZooValidation.isZooNotExist2(koalas,id);
        return koalas.get(id);
    }

    @PostMapping
    public Koala save(@RequestBody Koala Koala){
        ZooValidation.isKoalaValid(Koala);
        koalas.put(Koala.getId(),Koala);
        return koalas.get(Koala.getId());
    }
    @PutMapping("/{id}")
    public  Koala update(@PathVariable Long id, @RequestBody Koala Koala){
        ZooValidation.isIdValid(id);
        ZooValidation.isZooNotExist2(koalas,id);
        ZooValidation.isKoalaValid(Koala);
        Koala.setId(id);
        koalas.put(id,Koala);
        return koalas.get(id);

    }
    @DeleteMapping("/{id}")
    public  Koala delete(@PathVariable Long id){
        ZooValidation.isIdValid(id);
        ZooValidation.isZooNotExist2(koalas,id);
        return koalas.remove(id);
    }
}
