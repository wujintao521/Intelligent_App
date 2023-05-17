package com.intelligent.handler;

import org.apache.commons.collections4.map.LinkedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;

import java.util.Map;

public class ProjectBasicInfo {

    private static Environment environment = SpringContextHolder.getBean(Environment.class);

    private static final Logger logger = LoggerFactory.getLogger(ProjectBasicInfo.class);

    public ProjectBasicInfo() {
    }

    public static void printProjectBasicInfo() {
        Map<String,String> projectBasicInfoMap = getProjectBasicInfo();
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n").append("----------------------Project started successfully--------------------------------------------------").append("\r\n");
        projectBasicInfoMap.forEach((k,v)->{
            sb.append(getFormatString(20, k));
            sb.append(v).append("\r\n");
        });
        sb.append("\r\n").append("----------------------------------------------------------------------------------------------------").append("\r\n");
        logger.info(sb.toString());
    }

    private static LinkedMap<String,String> getProjectBasicInfo() {
        LinkedMap<String,String> projectBasicInfoMap = new LinkedMap<>();
        projectBasicInfoMap.put("Application",environment.getProperty("spring.application.name"));
        projectBasicInfoMap.put("ServerPort",environment.getProperty("server.port"));
        projectBasicInfoMap.put("ActiveProfiles",environment.getProperty("spring.profiles.active"));
        projectBasicInfoMap.put("Nacos",environment.getProperty("spring.cloud.nacos.discovery.server-addr"));
        projectBasicInfoMap.put("DatasourceUrl",environment.getProperty("spring.datasource.url"));
        return projectBasicInfoMap;
    }

    private static String getFormatString(int length, String s1) {
        int szCount = 0;

        int format;
        for(format = 0; format < s1.length(); ++format) {
            char c = s1.charAt(format);
            if (c >= ' ' && c <= 133) {
                ++szCount;
            }
        }

        format = length - s1.length() + szCount;
        String a = "%-" + format + "s";
        return String.format(a, s1);
    }

}
