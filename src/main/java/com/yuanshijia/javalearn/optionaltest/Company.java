package com.yuanshijia.javalearn.optionaltest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @author yuanshijia
 * @date 2019-07-29
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Company {
    private String name;
    private List<Employee> employees;
}
