package com.workintech.s17d3.controller;

import com.workintech.s17d3.entity.Kangaroo;
import com.workintech.s17d3.validation.ZooValidation;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooConroller {

    private Map<Long, Kangaroo> kangaroos;

    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();
    }
@GetMapping
    public List<Kangaroo> findAll() {
        return this.kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo find(@PathVariable("id") Long id){
        ZooValidation.isIdValid(id);
        ZooValidation.isZooNotExist(kangaroos,id);
        return kangaroos.get(id);
    }

    @PostMapping
    public Kangaroo save(@RequestBody Kangaroo kangaroo){
        ZooValidation.isKangarooValid(kangaroo);
        kangaroos.put(kangaroo.getId(),kangaroo);
        return kangaroos.get(kangaroo.getId());
    }
@PutMapping("/{id}")
    public  Kangaroo update(@PathVariable Long id, @RequestBody Kangaroo kangaroo){
        ZooValidation.isIdValid(id);
        ZooValidation.isZooNotExist(kangaroos,id);
        ZooValidation.isKangarooValid(kangaroo);
        kangaroo.setId(id);
        kangaroos.put(id,kangaroo);
        return kangaroos.get(id);

    }
    @DeleteMapping("/{id}")
    public  Kangaroo delete(@PathVariable Long id){
        ZooValidation.isIdValid(id);
        ZooValidation.isZooNotExist(kangaroos,id);
        return kangaroos.remove(id);
    }
}
