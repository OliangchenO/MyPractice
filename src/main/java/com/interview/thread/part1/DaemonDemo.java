package com.interview.thread.part1;

public class DaemonDemo {
    public static void main(String[] args){
        Thread daemonThread = new Thread(new Runnable() {
            public void run() {
                while (true){
                    try {
                        System.out.println("i am alive");
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        //守护线程在退出的时候并不会执行finnaly块中的代码，所以将释放资源等操作不要放在finnaly块中执行，这种操作是不安全的
                        System.out.println("finally block");
                    }
                }
            }
        });
        //线程可以通过setDaemon(true)的方法将线程设置为守护线程。并且需要注意的是设置守护线程要先于start()方法，否则会报
        //Exception in thread "main" java.lang.IllegalThreadStateException at java.lang.Thread.setDaemon(Thread.java:1365) at learn.DaemonDemo.main(DaemonDemo.java:19)
        //这样的异常，但是该线程还是会执行，只不过会当做正常的用户线程执行。
        daemonThread.setDaemon(true);
        daemonThread.start();
        //确保main线程结束前能给daemonThread能够分到时间片
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
