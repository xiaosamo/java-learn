package com.yuanshijia.javalearn.optionaltest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author yuanshijia
 * @date 2019-07-30
 * @description
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

    private String id;
    private String name;
}
