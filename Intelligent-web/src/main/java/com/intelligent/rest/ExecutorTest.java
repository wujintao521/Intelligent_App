package com.intelligent.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ExecutorTest {

    public static void main(String[] args) {
        List<String> storeList = Arrays.asList("G001", "G002");
        List<String> storeList1 = new ArrayList<>();
        storeList1.add("1");
        int size = storeList.size();
        ExecutorService executorService = Executors.newFixedThreadPool(Math.min(size,10));
        CountDownLatch countDownLatch = new CountDownLatch(Math.min(size,10));
        for (String storeCode : storeList) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.submit(() -> println(storeCode,countDownLatch));
        }
        try {
            log.info("等待子线程开始执行getMiddleStock:{}", Thread.currentThread().getName());
            countDownLatch.await();
            log.info("主线程执行完成getMiddleStock->名称:{}", Thread.currentThread().getName());
        } catch (InterruptedException e) {
            log.error(e.getMessage(), e);
        }
        executorService.shutdown();
    }

    private static void println(String storeCode,CountDownLatch countDownLatch) {
        List<String> list = new ArrayList<>();
        System.out.println(1);
        if (CollectionUtils.isEmpty(list)) {
            return;
        }
        System.out.println(2);
        countDownLatch.countDown();
    }

}
