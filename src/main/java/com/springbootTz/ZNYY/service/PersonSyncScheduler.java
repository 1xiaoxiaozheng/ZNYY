package com.springbootTz.ZNYY.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PersonSyncScheduler implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(PersonSyncScheduler.class);

    @Autowired
    private PersonSyncService personSyncService;

    // 每天凌晨0点执行一次人员基本信息（对应的是默认表person）
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncAllAtMidnight() {
        try {
            personSyncService.syncAll();
        } catch (Exception e) {
            logger.error("syncAll failed", e);
        }
    }

    // 每天凌晨0点执行一次教育（对应的是默认表Education）
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncEducationInfoAtMidnight() {
        try {
            personSyncService.syncEducationInfoAll();
        } catch (Exception e) {
            logger.error("syncEducationInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次工作履历同步
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncWorkInfoAtMidnight() {
        try {
            personSyncService.syncWorkInfoAll();
        } catch (Exception e) {
            logger.error("syncWorkInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次人员岗位聘任信息表同步（对应的是默认表work）
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncEmpTypeAtMidnight() {
        try {
            personSyncService.syncEmpTypeInfoAll();
        } catch (Exception e) {
            logger.error("syncEmpTypeInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次高层次人才科技奖励信息同步
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncHeightAwardAtMidnight() {
        try {
            personSyncService.syncHeightAwardInfoAll();
        } catch (Exception e) {
            logger.error("syncHeightAwardInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次高层次人才类型信息
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncHighLevelTalentAtMidnight() {
        try {
            personSyncService.syncHeightInfoAll();
        } catch (Exception e) {
            logger.error("syncHeightInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次论文信息同步
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncPaperInfoAtMidnight() {
        try {
            personSyncService.syncPaperInfoAll();
        } catch (Exception e) {
            logger.error("syncPaperInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次专利信息同步
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncPatentInfoAtMidnight() {
        try {
            personSyncService.syncPatentInfoAll();
        } catch (Exception e) {
            logger.error("syncPatentInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次专业技术资格
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncTechInfoAtMidnight() {
        try {
            personSyncService.syncTechInfoAll();
        } catch (Exception e) {
            logger.error("syncTechInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次科研情况信息
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncResearchInfoAtMidnight() {
        try {
            personSyncService.syncResearchInfoAll();
        } catch (Exception e) {
            logger.error("syncResearchInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次个人奖励称号信息
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncAwardInfoAtMidnight() {
        try {
            personSyncService.syncHonorInfoAll();
        } catch (Exception e) {
            logger.error("syncHonorInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次学术社团任职
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncSocietyInfoAtMidnight() {
        try {
            personSyncService.syncSocietyInfoAll();
        } catch (Exception e) {
            logger.error("syncSocietyInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次外出培训及学术活动（重写，对应的是默认表train）
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncOutTrainInfoAtMidnight() {
        try {
            personSyncService.syncOutInfoAll();
        } catch (Exception e) {
            logger.error("syncOutInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次上级单位进修信息
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncUpTrainInfoAtMidnight() {
        try {
            personSyncService.syncSuperviseInfoAll();
        } catch (Exception e) {
            logger.error("syncSuperviseInfoAll failed", e);
        }
    }

    // 每天凌晨0点执行一次人员学术专著信息
    @Scheduled(cron = "0 0 0 * * ?")
    public void syncSciPubInfoAtMidnight() {
        try {
            personSyncService.syncAcademicInfoAll();
        } catch (Exception e) {
            logger.error("syncAcademicInfoAll failed", e);
        }
    }

    @Override
    public void run(String... args) {
        // // √
        // try {
        // personSyncService.syncAll();
        // } catch (Exception e) {
        // logger.error("syncAll failed", e);
        // }
        // // √
        // try {
        // personSyncService.syncEducationInfoAll();
        // } catch (Exception e) {
        // logger.error("syncEducationInfoAll failed", e);
        // }
        // // √
        // try {
        // personSyncService.syncWorkInfoAll();
        // } catch (Exception e) {
        // logger.error("syncWorkInfoAll failed", e);
        // }
        // // √
        // try {
        // personSyncService.syncEmpTypeInfoAll();
        // } catch (Exception e) {
        // logger.error("syncEmpTypeInfoAll failed", e);
        // }
        // // √
        // try {
        // personSyncService.syncHeightAwardInfoAll();
        // } catch (Exception e) {
        // logger.error("syncHeightAwardInfoAll failed", e);
        // }
        // // √
        // try {
        // personSyncService.syncHeightInfoAll();
        // } catch (Exception e) {
        // logger.error("syncHeightInfoAll failed", e);
        // }
        // // √
        // try {
        // personSyncService.syncPaperInfoAll();
        // } catch (Exception e) {
        // logger.error("syncPaperInfoAll failed", e);
        // }
        // // √
        // try {
        // personSyncService.syncPatentInfoAll();
        // } catch (Exception e) {
        // logger.error("syncPatentInfoAll failed", e);
        // }
        // try {
        // personSyncService.syncTechInfoAll();
        // } catch (Exception e) {
        // logger.error("syncTechInfoAll failed", e);
        // }
        // try {
        // personSyncService.syncResearchInfoAll();
        // } catch (Exception e) {
        // logger.error("syncResearchInfoAll failed", e);
        // }
        // try {
        // personSyncService.syncHonorInfoAll();
        // } catch (Exception e) {
        // logger.error("syncHonorInfoAll failed", e);
        // }
        // try {
        // personSyncService.syncSocietyInfoAll();
        // } catch (Exception e) {
        // logger.error("syncSocietyInfoAll failed", e);
        // }
        // try {
        // personSyncService.syncOutInfoAll();
        // } catch (Exception e) {
        // logger.error("syncOutInfoAll failed", e);
        // }
        // try {
        // personSyncService.syncSuperviseInfoAll();
        // } catch (Exception e) {
        // logger.error("syncSuperviseInfoAll failed", e);
        // }
        // try {
        // personSyncService.syncAcademicInfoAll();
        // } catch (Exception e) {
        // logger.error("syncAcademicInfoAll failed", e);
        // }
    }
}