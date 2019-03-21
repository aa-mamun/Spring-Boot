package com.mamun.lombokdemo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EmployeeWithLombok {

    /**
     * Simplified entity with lombok
     * */
    private int id;
    private String name;
    private String designation;
}
