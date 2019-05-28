package com.yuanshijia.javalearn.requestlimit;

/**
 * @author yuan
 * @date 2019/5/28
 * @description 令牌桶算法
 */
public class TokenBucket {

    /**
     * 桶的容量
     */
    private int capacity;


    /**
     * 令牌放入速度
     */
    private int rate;

    /**
     * 当前令牌数量
     */
    private int tokens;

    /**
     * 时间
     */
    private long timestamp = getNowTime();

    public TokenBucket() {
        this.capacity = 100;
        this.rate = 1;
    }


    public TokenBucket(int capacity, int rate) {
        this.capacity = capacity;
        this.rate = rate;
    }

    private long getNowTime(){
        return System.currentTimeMillis();
    }

    /**
     * 判断桶的容量和令牌数量哪个小
     * @param tokens
     * @param capacity
     * @return
     */
    private int min(int tokens, int capacity) {
        // 如果桶的容量比令牌数量多，
        return capacity > tokens ? tokens : capacity;
    }

    /**
     * 获取令牌
     * @return
     */
    public boolean getToken(){
        // 获取当前时间
        long nowTime = getNowTime();

        // 先添加令牌
        tokens = tokens + (int) ((nowTime - timestamp) * rate);

        // 添加令牌后的数量与桶的容量比较，哪个小
        tokens = min(tokens, capacity);

        System.out.println("当前令牌数量：" + tokens);

        // 修改拿令牌时间
        timestamp = nowTime;

        // 判断令牌是否足够
        if (tokens < 1) {
            // 若不到1个令牌，则拒绝
            return false;
        }

        // 发放令牌
        tokens -= 1;
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        TokenBucket tokenBucket = new TokenBucket(100, 1);
        for (int i = 0; i < 200; i++) {
            if (i == 10 || i == 180) {
                Thread.sleep(500);
            }
            System.out.println("第" + i + "次请求结果=" + tokenBucket.getToken());
        }
    }
}
