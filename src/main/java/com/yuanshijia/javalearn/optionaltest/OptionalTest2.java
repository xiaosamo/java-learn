package com.yuanshijia.javalearn.optionaltest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author yuanshijia
 * @date 2019-07-29
 * @description
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        Employee employee1 = new Employee("zhangsan");
        Employee employee2 = new Employee("lisi");

        Company company = new Company("company1", Arrays.asList(employee1, employee2));

//        company.setEmployees(null);

        // 取出Company中的Employee列表，如果有，那么返回该Employee列表；
        // 如果没有，那么返回一个空的Employee列表。
        Optional<Company> optional = Optional.ofNullable(company);
        List<Employee> result =
                optional.map(Company::getEmployees)
                .orElse(Collections.emptyList());


        result.forEach(employee -> System.out.println(employee.getName()));
    }
}
