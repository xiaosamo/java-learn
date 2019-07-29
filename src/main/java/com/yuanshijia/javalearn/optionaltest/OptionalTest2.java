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
        Employee employee1 = new Employee();
        employee1.setName("zhangsan");
        Employee employee2 = new Employee();
        employee2.setName("lisi");

        Company company = new Company();
        company.setName("company1");

        List<Employee> employees = Arrays.asList(employee1, employee2);
//        List<Employee> employees = null;
        company.setEmployees(employees);

        // 取出Company中的Employee列表，如果有，那么返回该Employee列表；
        // 如果没有，那么返回一个空的Employee列表。
        Optional<Company> optional = Optional.ofNullable(company);
        List<Employee> result =
                optional.map(theCompany -> theCompany.getEmployees())
                .orElse(Collections.emptyList());
        result.forEach(employee -> System.out.println(employee.getName()));
    }
}
