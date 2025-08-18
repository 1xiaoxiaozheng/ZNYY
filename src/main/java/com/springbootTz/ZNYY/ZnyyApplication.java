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

              pushZNYYService.pushVehicleRegisterToZnyy();
              pushZNYYService.pushHomeApplianceRegisterToZnyy();
              pushZNYYService.pushLandRegisterToZnyy();
              pushZNYYService.pushNetworkRegisterToZnyy();
              pushZNYYService.pushIntangibleAssetRegisterToZnyy();
              pushZNYYService.pushMedicalRegisterToZnyy();

//            logger.info("推送seeyon卡片信息到znyy成功！");

        } catch (Exception e) {
            // 捕获所有可能的异常，记录详细错误信息但不中断应用启动
            logger.error("推送seeyon信息到znyy失败，应用将继续启动", e);
        }
    }
}
