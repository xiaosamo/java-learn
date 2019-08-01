package com.yuanshijia.javalearn.guavacachetest;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutionException;

/**
 * @author yuanshijia
 * @date 2019-07-30
 * @description
 */
public class GuavaCachDemo {

    private LoadingCache<String, Man> loadingCache;


    public void InitLoadingCache() {
        CacheLoader<String, Man> cacheLoader = new CacheLoader<>() {
            /**
             * 指定一个如果数据不存在获取数据的方法
             * @param key
             * @return
             * @throws Exception
             */
            @Override
            public Man load(String key) throws Exception {
                //模拟mysql操作
                Logger logger = LoggerFactory.getLogger("LoadingCache");
                logger.info("LoadingCache测试 从mysql加载缓存ing...(2s)");
                Thread.sleep(2000);
                logger.info("LoadingCache测试 从mysql加载缓存成功");
                Man tmpman = new Man();
                tmpman.setId(key);
                tmpman.setName("其他人");
                if (key.equals("001")) {
                    tmpman.setName("张三");
                    return tmpman;
                }
                if (key.equals("002")) {
                    tmpman.setName("李四");
                    return tmpman;
                }
                return tmpman;
            }
        };

        loadingCache = CacheBuilder.newBuilder().maximumSize(1).build(cacheLoader);
        
    }

    /**
     * 获取数据，如果不存在返回null
     * @param key
     * @return
     */
    public Man getIfPresentloadingCache(String key){
        return loadingCache.getIfPresent(key);
    }

    /**
     * 获取数据，如果数据不存在则通过cacheLoader获取数据，缓存并返回
     * @param key
     * @return
     */
    public Man getCacheKeyloadingCache(String key){
        try {
            return loadingCache.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 直接向缓存put数据
     * @param key
     * @param value
     */
    public void putloadingCache(String key,Man value){
        Logger logger = LoggerFactory.getLogger("LoadingCache");
        logger.info("put key :{} value : {}",key,value.getName());
        loadingCache.put(key,value);
    }

}
