package com.interview.thread.part6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ThreadPoolDemo {
    public static void main(String[] args){
        //当前设备的CPU个数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
