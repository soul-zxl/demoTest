package com.example.demotest.entity;

import lombok.Data;

@Data
public class Student {

    int id;
    String name;
    int tid;
    Teacher teacher;

}
