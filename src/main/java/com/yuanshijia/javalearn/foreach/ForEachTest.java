package com.yuanshijia.javalearn.foreach;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author yuanshijia
 * @date 2019-07-18
 * @description
 */
public class ForEachTest {
    private static final String[] strings = new String[]{"yuan", "shi", "jia"};

    private static List<String> list = Arrays.asList(strings);


    private static void arrayTest(){
        for (int i=0;i<strings.length;i++){
            System.out.println(strings[i]);
        }
    }

    private static void iteratorTest(){
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    private static void foreachTest(){
        for (String s : list) {
            System.out.println(s);
        }
    }

    /**
     * error
     */
    private static void errorTest() {
        for (String s : list) {
            list.remove(s);
        }
    }

    public  static void main(String[] args) {
        arrayTest();
        foreachTest();
        iteratorTest();
//        errorTest();
    }
    
}
