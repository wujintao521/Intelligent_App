package com.intelligent.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class IdWorker {

    private static final Logger log = LoggerFactory.getLogger(IdWorker.class);
    private static final long twepoch = 1288834974657L;
    private static final long workerIdBits = 5L;
    private static final long datacenterIdBits = 5L;
    private static final long maxWorkerId = 31L;
    private static final long maxDatacenterId = 31L;
    private static final long sequenceBits = 12L;
    private static final long workerIdShift = 12L;
    private static final long datacenterIdShift = 17L;
    private static final long timestampLeftShift = 22L;
    private static final long sequenceMask = 4095L;
    private static long lastTimestamp = -1L;
    private long sequence = 0L;
    private final long workerId;
    private final long datacenterId;

    public IdWorker(long workerId, long datacenterId) {
        if (workerId <= 31L && workerId >= 0L) {
            this.workerId = workerId;
        } else {
            if (workerId != -1L) {
                throw new IllegalArgumentException("worker Id can't be greater than %d or less than 0");
            }

            this.workerId = (long)(new Random()).nextInt(31);
        }

        if (datacenterId <= 31L && datacenterId >= 0L) {
            this.datacenterId = datacenterId;
        } else {
            if (datacenterId != -1L) {
                throw new IllegalArgumentException("datacenter Id can't be greater than %d or less than 0");
            }

            this.datacenterId = (long)(new Random()).nextInt(31);
        }

    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if (timestamp < lastTimestamp) {
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
            } catch (Exception var5) {
                log.error(var5.getMessage(), var5);
            }
        }

        if (lastTimestamp == timestamp) {
            this.sequence = this.sequence + 1L & 4095L;
            if (this.sequence == 0L) {
                timestamp = this.tilNextMillis(lastTimestamp);
            }
        } else {
            this.sequence = 0L;
        }

        lastTimestamp = timestamp;
        long nextId = timestamp - 1288834974657L << 22 | this.datacenterId << 17 | this.workerId << 12 | this.sequence;
        return nextId;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
        }

        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) throws Exception {
        final Set<Long> set = new HashSet();
        final IdWorker w1 = new IdWorker(-1L, -1L);
        final IdWorker w2 = new IdWorker(-1L, -1L);
        final CyclicBarrier cdl = new CyclicBarrier(100);

        for(int i = 0; i < 1000; ++i) {
            (new Thread(new Runnable() {
                public void run() {
                    try {
                        cdl.await();
                    } catch (InterruptedException var3) {
                        IdWorker.log.error(var3.getMessage(), var3);
                    } catch (BrokenBarrierException var4) {
                        IdWorker.log.error(var4.getMessage(), var4);
                    }

                    Long id = w1.nextId();
                    if (set.contains(id)) {
                        System.out.println(id + " exists");
                    }

                    set.add(id);
                    System.out.println(id);
                    Long id2 = w2.nextId();
                    if (set.contains(id2)) {
                        System.out.println(id2 + " exists");
                    }

                    set.add(id2);
                    System.out.println(id2);
                }
            })).start();
        }

        try {
            TimeUnit.SECONDS.sleep(5L);
        } catch (InterruptedException var6) {
            log.error(var6.getMessage(), var6);
        }

    }
}
