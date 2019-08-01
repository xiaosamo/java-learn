package com.yuanshijia.javalearn.errortest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuanshijia
 * @date 2019-08-01
 * @description                                     
 */
public class HeapOOM {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while(true) {
            list.add(new OOMObject());
        }
        
    }
    
}
