package com.yuanshijia.javalearn.concurrentmap;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author yuanshijia
 * @date 2019-07-24
 * @description
 */
public class ConcurrentSkipSetTest {
    private void test() {
        ConcurrentSkipListSet<Integer> skiplistSet = new ConcurrentSkipListSet<>();
        skiplistSet.add(3);
        skiplistSet.add(1);
        skiplistSet.add(2);

        // 抛出最低的一个
        System.out.println(skiplistSet.pollFirst());

        // 抛出最后一个
        System.out.println(skiplistSet.pollLast());


        System.out.println("size=" + skiplistSet.size());
        skiplistSet.forEach(System.out::println);
    }

    public static void main(String[] args) {
        ConcurrentSkipSetTest test = new ConcurrentSkipSetTest();
        test.test();
    }
}
