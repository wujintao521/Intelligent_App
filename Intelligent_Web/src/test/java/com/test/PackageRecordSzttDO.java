package com.test;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Data
public class PackageRecordSzttDO {

    /**
     * id
     */
    @TableId
    private String id;

    /**
     * 调证任务id
     */
    private String taskId;

    /**
     * 应用id
     */
    private String appId;

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 打包名称
     */
    private String packageName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 平台
     */
    private String platform;

    /**
     * 打包状态
     */
    private String packageStatus;

    /**
     * ip
     */
    private String ip;

    /**
     * 端口号
     */
    private String port;

    /**
     * 打包时间
     */
    private String packageTime;
}
