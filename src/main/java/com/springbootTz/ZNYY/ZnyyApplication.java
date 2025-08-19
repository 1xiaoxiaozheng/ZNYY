package com.springbootTz.ZNYY;

import com.springbootTz.ZNYY.Equipment.service.pushZNYY.PushZNYYService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableScheduling
@EnableTransactionManagement
public class ZnyyApplication implements CommandLineRunner {

    // 引入日志组件
    private static final Logger logger = LoggerFactory.getLogger(ZnyyApplication.class);

    @Autowired
    private PushZNYYService pushZNYYService;

    public static void main(String[] args) {
        SpringApplication.run(ZnyyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        logger.info("开始执行推送seeyon卡片信息到znyy的任务...");

        try {
            // 执行推送操作
//            pushZNYYService.pushEquipCardInfoToZnyy();
//            pushZNYYService.pushEquipDepreciationRecordToZnyy();
//            pushZNYYService.pushEquipDepreciationRecordToZnyyBySeeyon();

            // 执行车辆登记推送操作
            try {
                pushZNYYService.pushVehicleRegisterToZnyy();
            } catch (Exception e) {
//                logger.error("推送车辆登记信息到znyy失败", e);
            }

            // 执行家电登记推送操作
            try {
                pushZNYYService.pushHomeApplianceRegisterToZnyy();
            } catch (Exception e) {
//                logger.error("推送家电登记信息到znyy失败", e);
            }

            // 执行土地登记推送操作
            try {
                pushZNYYService.pushLandRegisterToZnyy();
            } catch (Exception e) {
//                logger.error("推送土地登记信息到znyy失败", e);
            }

            // 执行网络登记推送操作
            try {
                pushZNYYService.pushNetworkRegisterToZnyy();
            } catch (Exception e) {
//                logger.error("推送网络登记信息到znyy失败", e);
            }

            // 执行无形资产登记推送操作
            try {
                pushZNYYService.pushIntangibleAssetRegisterToZnyy();
            } catch (Exception e) {
//                logger.error("推送无形资产登记信息到znyy失败", e);
            }

            // 执行医疗器械登记推送操作
            try {
                pushZNYYService.pushMedicalRegisterToZnyy();
            } catch (Exception e) {
//                logger.error("推送医疗器械登记信息到znyy失败", e);
            }

        } catch (Exception e) {
            // 捕获所有可能的异常，记录详细错误信息但不中断应用启动
            logger.error("推送seeyon信息到znyy失败，应用将继续启动", e);
        }
    }

}
