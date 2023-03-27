package com.intelligent.utils;

import org.apache.commons.lang.StringUtils;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.UUID;

public class IdGenerate {

    private static SecureRandom random = new SecureRandom();
    private static IdWorker idWorker = new IdWorker(-1L, -1L);

    public IdGenerate() {
    }

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static long randomLong() {
        return Math.abs(random.nextLong());
    }

    public static String nextId() {
        return String.valueOf(idWorker.nextId());
    }

    public static String nextCode(String code) {
        return nextCode(code, 1);
    }

    public static String nextCode(String code, int step) {
        if (code == null) {
            return null;
        } else {
            String str = code.trim();
            int len = str.length() - 1;
            int lastNotNumIndex = 0;

            for(int i = len; i >= 0; --i) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                    lastNotNumIndex = i;
                    break;
                }
            }

            if (str.charAt(len) >= '0' && str.charAt(len) <= '9' && lastNotNumIndex == len) {
                lastNotNumIndex = -1;
            }

            String prefix = str.substring(0, lastNotNumIndex + 1);
            String numStr = str.substring(lastNotNumIndex + 1, str.length());
            BigDecimal num = new BigDecimal(numStr);
            num = num.add(new BigDecimal(step));
            int numLength = numStr.length();
            String postStr = StringUtils.leftPad(num.toString(), numLength, "0");
            str = prefix + postStr;
            return str;
        }
    }

}

