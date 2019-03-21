package com.mamun.lombokdemo.entity;

import lombok.Data;

@Data
public class EmployeeWithLombokTwo {

    /**
     * @Data is the shortcut of
     * ToString, @EqualsAndHashCode, @Getter / @Setter
     * and @RequiredArgsConstructor
     * */
    private int id;
    private String name;
    private String designation;


}
