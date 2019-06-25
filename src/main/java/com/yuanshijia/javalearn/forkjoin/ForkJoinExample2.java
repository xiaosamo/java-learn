package com.yuanshijia.javalearn.forkjoin;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * ForkJoin 主要用于并行计算中，和 MapReduce 原理类似，都是把大的计算任务拆分成多个小任务并行计算
 * @author ysj
 * @date 2019-06-25
 */
public class ForkJoinExample2 extends RecursiveTask<BigInteger> {

    private final int threshold = 20;
    private int first;
    private int last;

    public ForkJoinExample2(int first, int last) {
        this.first = first;
        this.last = last;
    }

    @Override
    protected BigInteger compute() {
        BigInteger result = BigInteger.valueOf(0);
        if (last - first <= threshold) {
            // 任务足够小则直接计算
            for (int i = first; i <= last; i++) {
                result = result.add(BigInteger.valueOf(i));

            }
        } else {
            // 拆分成小任务
            int m = first + (last - first) / 2;
            ForkJoinExample2 leftTask = new ForkJoinExample2(first, m);
            ForkJoinExample2 rightTask = new ForkJoinExample2(m + 1, last);
            leftTask.fork();
            rightTask.fork();
            result = leftTask.join().add(rightTask.join());

        }
        return result;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        ForkJoinExample2 example = new ForkJoinExample2(1, 10000000);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<BigInteger> result = forkJoinPool.submit(example);
        System.out.println(result.get().toString());


        long end = System.currentTimeMillis();
        System.out.printf("耗时%dms\n", end - start);
    }
}
