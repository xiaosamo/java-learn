package com.yuanshijia.javalearn.jdkcache;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author yuan
 * @date 2019/6/6
 * @description 使用JDK来实现自己的缓存（支持高并发）
 */
public class Cache {
    /**
     * 键值对集合
     */
    private final static Map<String, Entity> map = new HashMap<>();

    /**
     * 定时器线程池，用于清除过期缓存
     */
    private final static ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();

    /**
     *
     * @param key
     * @param data
     */
    public synchronized static void put(String key,Object data){
        put(key, data, 0);
    }

    /**
     * 添加缓存
     * @param key
     * @param data
     * @param expire 过期时间，单位：毫秒， 0表示无限长
     */
    public synchronized static void put(String key, Object data, long expire) {
        // 清除原键值对
        remove(key);
        // 设置过期时间
        if (expire > 0) {
            Future future = executor.schedule(() -> {
                synchronized (Cache.class) {
                    map.remove(key);
                }
            }, expire, TimeUnit.MILLISECONDS);
            map.put(key, new Entity(data, future));
        } else {
            // 不设置过期时间
            map.put(key, new Entity(data, null));
        }
    }

    /**
     * 获取缓存
     * @param key
     * @return
     */
    public synchronized static Object get(String key) {
        Entity entity = map.get(key);
        return entity == null ? null : entity.getValue();
    }


    /**
     * 获取缓存
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public synchronized static <T> T get(String key,Class<T> clazz) {
        return clazz.cast(get(key));
    }

    /**
     * 清除缓存
     * @param key
     * @return
     */
    public synchronized static Object remove(String key){
        // 清除原缓存数据
        Entity entity = map.remove(key);
        if (entity == null) {
            return null;
        }
        Future future = entity.getFuture();
        if (future != null) {
            future.cancel(true);
        }
        return entity.getValue();
    }

    /**
     * 获取数量
     * @return
     */
    public synchronized static int size(){
        return map.size();
    }


    /**
     * 缓存实体类
     */
    private static class Entity{
        private Object value;
        private Future future;

        public Entity(Object value, Future future) {
            this.value = value;
            this.future = future;
        }

        public Object getValue() {
            return value;
        }

        public Future getFuture() {
            return future;
        }
    }
}
