package com.book.config.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.util.concurrent.*;

@Slf4j
public  class ThreadPoolUtils {
    /**
     * 核心线程数
     */
    private static int CORE_POOLSIZE = Runtime.getRuntime().availableProcessors() * 2;
    /**
     * 最大线程数
     */
    private static int MAX_POOLSIZE = CORE_POOLSIZE * 10;
    /**
     * 存活时间
     */
    private static long KEEP_ALIVETIME = 300000L;
    /**
     * 时间单位
     */
    private static TimeUnit UNIT = TimeUnit.MILLISECONDS;
    /**
     * 队列容量
     */
    private static int CAPACITY = 20;
    /**
     * 队列
     */
    private static BlockingQueue<Runnable> WORK_QUEUE;
    /**
     * 线程工厂
     */
    private static ThreadFactory THREAD_FACTORY;
    /**
     * 默认拒绝策略
     */
    private static RejectedExecutionHandler REJECTED_EXECUTION_HANDLER;

    private static long SHUTDOWN_WAIT_TIME = 300000L;

    public static ThreadPoolExecutor executor = null;

    /**
     * 线程池单例
     *
     * @return
     */

    public ThreadPoolUtils() {
        if (CORE_POOLSIZE <= 0 || CORE_POOLSIZE > 10) {
            CORE_POOLSIZE = 4;
            MAX_POOLSIZE = CORE_POOLSIZE * 10;
        }
        THREAD_FACTORY = (ThreadFactory) new ThreadPoolUtils();
        WORK_QUEUE = new ArrayBlockingQueue<>(CAPACITY);
        REJECTED_EXECUTION_HANDLER = new AbortPolicy();

        executor = new ThreadPoolExecutor(
                CORE_POOLSIZE,
                MAX_POOLSIZE,
                KEEP_ALIVETIME,
                UNIT,
                WORK_QUEUE,
                THREAD_FACTORY,
                REJECTED_EXECUTION_HANDLER
        );
    }



    /**
     * 拒绝策略，丢弃不作任何处理
     */
    public static class AbortPolicy implements RejectedExecutionHandler {
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            String info = "";
            try {
                Field field = FutureTask.class.getDeclaredField("callable");
                field.setAccessible(true);

                FutureTask futureTask = (FutureTask) r;
                Callable callable = (Callable) field.get(futureTask);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            log.error("AbortPolicy: " + info + " rejected from " + e.toString());
        }
    }
}
