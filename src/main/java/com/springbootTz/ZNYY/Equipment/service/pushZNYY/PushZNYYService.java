package com.springbootTz.ZNYY.Equipment.service.pushZNYY;

import com.springbootTz.ZNYY.Equipment.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.boot.CommandLineRunner;

/**
 * 推送seeyon卡片信息到znyy的服务
 */
@Service
public class PushZNYYService implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(PushZNYYService.class);

    @Autowired
    private EquipCardInfoService equipCardInfoService;

    @Autowired
    private EquipDeprRecordService equipDeprRecordService;

    @Autowired
    private EquipDiscardedRecordService equipDiscardedRecordService;

    @Autowired
    private EquipRegInfoService_CL equipRegInfoService_CL;

    @Autowired
    private EquipRegInfoService_JJ equipRegInfoService_JJ;

    @Autowired
    private EquipRegInfoService_TD equipRegInfoService_TD;

    @Autowired
    private EquipRegInfoService_WL equipRegInfoService_WL;

    @Autowired
    private EquipRegInfoService_WX equipRegInfoService_WX;

    @Autowired
    private EquipRegInfoService_YL equipRegInfoService_YL;

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
        } catch (Exception e) {
            logger.error("推送设备折旧记录到znyy失败", e);
            throw e;
        }
    }

    /**
     * 推送seeyon设备报废记录到znyy
     */
    public void pushEquipDepreciationRecordToZnyyBySeeyon() {
        logger.info("开始推送seeyon设备报废记录到znyy...");
        try {
            equipDiscardedRecordService.syncEquipDiscardedRecord();
        } catch (Exception e) {
            logger.error("推送seeyon设备报废记录到znyy失败", e);
            throw e;
        }
    }

    /**
     * 推送设备登记表————车辆登记数据到znyy
     */
    public void pushVehicleRegisterToZnyy() {
        logger.info("开始推送设备登记表————车辆登记数据到znyy...");
        try {
            equipRegInfoService_CL.syncEquipRegInfo();
        } catch (Exception e) {
            logger.error("推送设备登记表————车辆登记数据到znyy失败", e);
            throw e;
        }
    }

    /**
     * 推送设备登记表————家居设备数据到znyy
     */
    public void pushHomeApplianceRegisterToZnyy() {
        logger.info("开始推送设备登记表————家居设备数据到znyy...");
        try {
            equipRegInfoService_JJ.syncEquipRegInfoFromSeeyonToZNYY();
        } catch (Exception e) {
            logger.error("推送设备登记表————家居设备数据到znyy失败", e);
            throw e;
        }
    }

    /**
     * 推送设备登记表————房屋土地数据到znyy
     */
    public void pushLandRegisterToZnyy() {
        logger.info("开始推送设备登记表————房屋土地数据到znyy...");
        try {
            equipRegInfoService_TD.syncEquipRegInfo();
        } catch (Exception e) {
            logger.error("推送设备登记表————房屋土地数据到znyy失败", e);
            throw e;
        }
    }

    /**
     * 推送设备登记表————网络设备数据到znyy
     */
    public void pushNetworkRegisterToZnyy() {
        logger.info("开始推送设备登记表————网络设备数据到znyy...");
        try {
            equipRegInfoService_WL.syncEquipRegInfo();
        } catch (Exception e) {
            logger.error("推送设备登记表————网络设备数据到znyy失败", e);
            throw e;
        }
    }

    /**
     * 推送设备登记表————无形资产数据到znyy
     */
    public void pushIntangibleAssetRegisterToZnyy() {
        logger.info("开始推送设备登记表————无形资产数据到znyy...");
        try {
            equipRegInfoService_WX.syncEquipRegInfo();
        } catch (Exception e) {
            logger.error("推送设备登记表————无形资产数据到znyy失败", e);
            throw e;
        }
    }

    /**
     * 推送设备登记表————医疗设备数据到znyy
     */
    public void pushMedicalRegisterToZnyy() {
        logger.info("开始推送设备登记表————医疗设备数据到znyy...");
        try {
            equipRegInfoService_YL.syncEquipRegInfo();
        } catch (Exception e) {
            logger.error("推送设备登记表————医疗设备数据到znyy失败", e);
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

        logger.info("【定时任务】开始推送seeyon设备折旧记录到znyy...");
        try {
            equipDeprRecordService.syncEquipDeprRecord();
            logger.info("【定时任务】推送设备折旧记录到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备折旧记录到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送seeyon设备报废记录到znyy...");
        try {
            equipDiscardedRecordService.syncEquipDiscardedRecord();
            logger.info("【定时任务】推送seeyon设备报废记录到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送seeyon设备报废记录到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————车辆登记数据到znyy...");
        try {
            equipRegInfoService_CL.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————车辆登记数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————车辆登记数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————家居设备数据到znyy...");
        try {
            equipRegInfoService_JJ.syncEquipRegInfoFromSeeyonToZNYY();
            logger.info("【定时任务】推送设备登记表————家居设备数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————家居设备数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————房屋土地数据到znyy...");
        try {
            equipRegInfoService_TD.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————房屋土地数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————房屋土地数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————网络设备数据到znyy...");
        try {
            equipRegInfoService_WL.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————网络设备数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————网络设备数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————无形资产数据到znyy...");
        try {
            equipRegInfoService_WX.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————无形资产数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————无形资产数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————医疗设备数据到znyy...");
        try {
            equipRegInfoService_YL.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————医疗设备数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————医疗设备数据到znyy失败", e);
            throw e;
        }
    }

    // 开机自启
    @Override
    public void run(String... args) {


        logger.info("【定时任务】开始推送seeyon设备折旧记录到znyy...");
        try {
            equipDeprRecordService.syncEquipDeprRecord();
            logger.info("【定时任务】推送设备折旧记录到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备折旧记录到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送seeyon设备报废记录到znyy...");
        try {
            equipDiscardedRecordService.syncEquipDiscardedRecord();
            logger.info("【定时任务】推送seeyon设备报废记录到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送seeyon设备报废记录到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————车辆登记数据到znyy...");
        try {
            equipRegInfoService_CL.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————车辆登记数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————车辆登记数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————家居设备数据到znyy...");
        try {
            equipRegInfoService_JJ.syncEquipRegInfoFromSeeyonToZNYY();
            logger.info("【定时任务】推送设备登记表————家居设备数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————家居设备数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————房屋土地数据到znyy...");
        try {
            equipRegInfoService_TD.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————房屋土地数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————房屋土地数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————网络设备数据到znyy...");
        try {
            equipRegInfoService_WL.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————网络设备数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————网络设备数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————无形资产数据到znyy...");
        try {
            equipRegInfoService_WX.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————无形资产数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————无形资产数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送设备登记表————医疗设备数据到znyy...");
        try {
            equipRegInfoService_YL.syncEquipRegInfo();
            logger.info("【定时任务】推送设备登记表————医疗设备数据到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送设备登记表————医疗设备数据到znyy失败", e);
            throw e;
        }

        logger.info("【定时任务】开始推送seeyon卡片信息到znyy...");
        try {
            equipCardInfoService.syncEquipCardInfo();
            logger.info("【定时任务】推送seeyon卡片信息到znyy完成");
        } catch (Exception e) {
            logger.error("【定时任务】推送seeyon卡片信息到znyy失败", e);
        }
    }

}