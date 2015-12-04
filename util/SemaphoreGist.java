package com.creditease.tradematch.tmfront.gist.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 */
public class SemaphoreGist {

    public static void main(String[] argv) throws Exception {
        final Semaphore[] semaphoreArray = new Semaphore[100];

        semaphoreArray[0] = new Semaphore(0);
        // ……
        semaphoreArray[51] = new Semaphore(0);
        // ……
        semaphoreArray[99] = new Semaphore(0);

        ExecutorService e = Executors.newFixedThreadPool(2);

        e.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.print(Thread.currentThread().getName());
                    System.out.println("：投资请求已发送，等待接收端通知。");

                    semaphoreArray[51].acquire();

                    System.out.print(Thread.currentThread().getName());
                    System.out.println("：收到通知，方法结束。");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        });

        e.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.print(Thread.currentThread().getName());
                    System.out.println("：等待消息到达……");

                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }

                System.out.print(Thread.currentThread().getName());
                System.out.println("：收到消息，通知发送端。");

                semaphoreArray[51].release();
            }
        });
        e.shutdown();
    }
}
