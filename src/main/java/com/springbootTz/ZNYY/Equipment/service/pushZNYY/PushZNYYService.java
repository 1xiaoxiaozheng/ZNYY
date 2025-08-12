package com.springbootTz.ZNYY.Equipment.service.pushZNYY;

import com.springbootTz.ZNYY.Equipment.service.EquipDeprRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootTz.ZNYY.Equipment.service.EquipCardInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 推送seeyon卡片信息到znyy的服务
 */
@Service
public class PushZNYYService {
    private static final Logger logger = LoggerFactory.getLogger(PushZNYYService.class);

    @Autowired
    private EquipCardInfoService equipCardInfoService;

    @Autowired
    private EquipDeprRecordService equipDeprRecordService;

    /**
     * 推送seeyon卡片信息到znyy
     */
    public void pushEquipCardInfoToZnyy() {
        logger.info("开始推送seeyon卡片信息到znyy...");
        try {
            equipCardInfoService.syncEquipCardInfo();
            logger.info("推送seeyon卡片信息到znyy完成");
        } catch (Exception e) {
            logger.error("推送seeyon卡片信息到znyy失败", e);
            throw e;
        }
    }
    /**
     * 推送设备折旧记录到znyy
     */
    public void pushEquipDepreciationRecordToZnyy() {
        logger.info("开始推送设备折旧记录到znyy...");
        try {
            equipDeprRecordService.syncEquipDeprRecord();
            logger.info("推送设备折旧记录到znyy完成");
        }catch (Exception e) {
            logger.error("推送设备折旧记录到znyy失败", e);
            throw e;
        }
    }

    /**
     * 每天凌晨0点自动推送seeyon卡片信息到znyy
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void pushEquipCardInfoToZnyyScheduled() {
        logger.info("【定时任务】开始推送seeyon卡片信息到znyy...");
        try {
            equipCardInfoService.syncEquipCardInfo();
            logger.info("【定时任务】推送seeyon卡片信息到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送seeyon卡片信息到znyy失败", e);
        }
        logger.info("开始推送设备折旧记录到znyy...");
        try {
            equipDeprRecordService.syncEquipDeprRecord();
            logger.info("推送设备折旧记录到znyy完成");
        }catch (Exception e) {
            logger.error("推送设备折旧记录到znyy失败", e);
            throw e;
        }
    }
}