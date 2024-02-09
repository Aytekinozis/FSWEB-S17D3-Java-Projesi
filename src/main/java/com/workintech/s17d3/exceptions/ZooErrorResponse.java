package com.workintech.s17d3.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ZooErrorResponse {
    private  Integer status;
    private String message;
    private LocalDateTime timestamp;
}
