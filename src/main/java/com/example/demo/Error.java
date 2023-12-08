package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Error {
    private int status;
    private String message;
    private long timestamp;
}
