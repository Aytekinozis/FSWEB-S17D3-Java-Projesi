package com.workintech.s17d3.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Koala {
    private Long id;
    private String name;
    private Double weight;
    private Double sleepHour;
    private String gender;
}
