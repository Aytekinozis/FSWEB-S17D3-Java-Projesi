package com.workintech.s17d3.validation;

import com.workintech.s17d3.entity.Kangaroo;
import com.workintech.s17d3.entity.Koala;
import com.workintech.s17d3.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooValidation {

    public static void isIdValid(Long id) {
        if (id == null || id < 0) {
            throw new ZooException("Id is not valid: "+id, HttpStatus.BAD_REQUEST);
        }
    }

    public static void isZooNotExist(Map<Long, Kangaroo> kangaroos, Long id) {
        if (!kangaroos.containsKey(id)) {
            throw new ZooException("Kangaroo is Not Exist: " + id, HttpStatus.NOT_FOUND);
        }
    }
    public static void isZooNotExist2(Map<Long, Koala> koalas, Long id) {
        if (!koalas.containsKey(id)) {
            throw new ZooException("Kangaroo is Not Exist: " + id, HttpStatus.NOT_FOUND);
        }
    }

    public static void isKangarooValid(Kangaroo kangaroo){
        if(kangaroo == null || kangaroo.getName() == null|| kangaroo.getName().isEmpty() || kangaroo.getId() == null ||
        kangaroo.getId().describeConstable().isEmpty() || kangaroo.getWeight()<0||kangaroo.getHeight()<0){
throw new ZooException("Zoo Credentials is not valid", HttpStatus.BAD_REQUEST);
        }
    }
    public static void isKoalaValid(Koala koala){
        if(koala == null || koala.getName() == null|| koala.getName().isEmpty() || koala.getId() == null ||
                koala.getId().describeConstable().isEmpty() || koala.getWeight()<0){
            throw new ZooException("Zoo Credentials is not valid", HttpStatus.BAD_REQUEST);
        }
    }
}
