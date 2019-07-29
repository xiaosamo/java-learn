package com.yuanshijia.javalearn.optionaltest;

import java.util.List;

/**
 * @author yuanshijia
 * @date 2019-07-29
 * @description
 */
public class Company {
    private String name;
    private List<Employee> employees;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
