package com.interview.thread.part8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {
    //表示老师只有5支笔
    private static Semaphore semaphore = new Semaphore(5);

    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i=0; i<10; i++) {
            service.execute(()->{
                try {
                    System.out.println(Thread.currentThread().getName() + "  同学准备获取笔......");
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "  同学获取到笔");
                    System.out.println(Thread.currentThread().getName() + "  填写表格ing.....");
                    TimeUnit.SECONDS.sleep(3);
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() + "  填写完表格，归还了笔！！！！！！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        }
        service.shutdown();
    }
}
