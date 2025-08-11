package com.springbootTz.ZNYY.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.springbootTz.ZNYY.entity.OraclePerson;
import com.springbootTz.ZNYY.entity.OraclePersonEduInfo;
import com.springbootTz.ZNYY.entity.OraclePersonEmpType;
import com.springbootTz.ZNYY.entity.OraclePersonEmprInfo;
import com.springbootTz.ZNYY.entity.OraclePersonHeigth;
import com.springbootTz.ZNYY.entity.OraclePersonHeigthAward;
import com.springbootTz.ZNYY.entity.OraclePersonPaper;
import com.springbootTz.ZNYY.entity.OraclePersonPatent;
import com.springbootTz.ZNYY.entity.OraclePersonProf;
import com.springbootTz.ZNYY.entity.OraclePersonResearch;
import com.springbootTz.ZNYY.entity.OraclePersonRewards;
import com.springbootTz.ZNYY.entity.OracleStaffCorp;
import com.springbootTz.ZNYY.entity.OracleStaffStudy;
import com.springbootTz.ZNYY.entity.PostgresPerson;
import com.springbootTz.ZNYY.entity.PostgresPersonDetailCustom;
import com.springbootTz.ZNYY.entity.PostgresPersonDetailEducationExperience;
import com.springbootTz.ZNYY.entity.PostgresPersonDetailTraining;
import com.springbootTz.ZNYY.entity.PostgresPersonDetailWorkExperience;
import com.springbootTz.ZNYY.mapper.PersonEduInfoFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonEmpFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonEmperFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonHeightAward;
import com.springbootTz.ZNYY.mapper.PersonHeightFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonPaperFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonPatentFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonPsnProfFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonResearchMapper;
import com.springbootTz.ZNYY.mapper.PersonRewardsFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonStaffCorpFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonStudyFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonTrainFieldMapper;
import com.springbootTz.ZNYY.mapper.PersonWorkFieldMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonEduInfoMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonEmpTypeMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonEmprInfoMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonHeigthAwardMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonHeigthMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonPaperMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonPatentMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonProfMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonResearchMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonRewardsMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonTrainMapper;
import com.springbootTz.ZNYY.mapper.oracle.OraclePersonWorkMapper;
import com.springbootTz.ZNYY.mapper.oracle.OracleStaffCorpMapper;
import com.springbootTz.ZNYY.mapper.oracle.OracleStaffStudyMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailCustomMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailEducationExperienceMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailTrainingMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonDetailWorkExperienceMapper;
import com.springbootTz.ZNYY.mapper.postgresql.PostgresPersonMapper;

@Service
@Transactional
public class PersonSyncService {

    private static final Logger logger = LoggerFactory.getLogger(PersonSyncService.class);

    @Autowired
    private PostgresPersonMapper postgresPersonMapper;
    @Autowired
    private OraclePersonMapper oraclePersonMapper;
    @Autowired
    private PersonFieldMapper personFieldMapper;
    @Autowired
    private OraclePersonEduInfoMapper oraclePersonEduInfoMapper;
    @Autowired
    private PostgresPersonDetailEducationExperienceMapper postgresPersonDetailEducationExperienceMapper;
    @Autowired
    private PersonEduInfoFieldMapper personEduInfoFieldMapper;
    @Autowired
    private OraclePersonEmprInfoMapper oraclePersonEmprInfoMapper;
    @Autowired
    private PostgresPersonDetailCustomMapper postgresPersonDetailCustomMapper;
    @Autowired
    private PersonEmperFieldMapper personEmperFieldMapper;

    @Autowired
    private PersonTrainFieldMapper personTrainingFieldMapper;
    @Autowired
    private PostgresPersonDetailTrainingMapper postgresPersonDetailTrainingMapper;
    @Autowired
    private PostgresPersonDetailWorkExperienceMapper postgresPersonDetailWorkExperienceMapper;
    @Autowired
    private OraclePersonEmpTypeMapper oraclePersonEmpTypeMapper;

    @Autowired
    private PersonEmpFieldMapper personEmpFieldMapper;

    @Autowired
    private PersonHeightAward personHeightAward;

    @Autowired
    private OraclePersonHeigthAwardMapper oraclePersonHeigthAwardMapper;

    @Autowired
    private PersonHeightFieldMapper personHeightFieldMapper;

    @Autowired
    private OraclePersonHeigthMapper oraclePersonHeigthMapper;

    @Autowired
    private PersonPaperFieldMapper personPaperFieldMapper;

    @Autowired
    private OraclePersonPaperMapper oraclePersonPaperMapper;

    @Autowired
    private PersonPatentFieldMapper personPatentFieldMapper;

    @Autowired
    private OraclePersonPatentMapper oraclePersonPatentMapper;

    @Autowired
    private PersonPsnProfFieldMapper personPsnProfFieldMapper;

    @Autowired
    private OraclePersonProfMapper oraclePersonProfMapper;

    @Autowired
    private PersonResearchMapper personResearchMapper;

    @Autowired
    private OraclePersonResearchMapper oraclePersonResearchMapper;

    @Autowired
    private PersonRewardsFieldMapper personRewardsFieldMapper;

    @Autowired
    private OraclePersonRewardsMapper oraclePersonRewardsMapper;

    @Autowired
    private PersonStaffCorpFieldMapper personStaffCorpFieldMapper;

    @Autowired
    private OracleStaffCorpMapper oracleStaffCorpMapper;

    @Autowired
    private PersonStudyFieldMapper personStudyFieldMapper;

    @Autowired
    private OracleStaffStudyMapper oracleStaffStudyMapper;

    @Autowired
    private PersonTrainFieldMapper personTrainFieldMapper;

    @Autowired
    private OraclePersonTrainMapper oraclePersonTrainMapper;

    @Autowired
    private PersonWorkFieldMapper personWorkFieldMapper;

    @Autowired
    private OraclePersonWorkMapper oraclePersonWorkMapper;

    /**
     * 批量删除工具方法，处理Oracle IN子句最大1000个值的限制
     *
     * @param deleteIds 需要删除的ID列表
     * @param deleteFunction 执行删除的函数
     */
    private void batchDelete(List<String> deleteIds, Function<List<String>, Integer> deleteFunction) {
        if (deleteIds == null || deleteIds.isEmpty()) {
            return;
        }

        // 分批处理，每批最多900条（预留一些余量，避免刚好到1000的边界）
        int batchSize = 900;
        int totalSize = deleteIds.size();
        int batchCount = (totalSize + batchSize - 1) / batchSize; // 向上取整得到批次数

        int totalDeleted = 0;
        for (int i = 0; i < batchCount; i++) {
            int fromIndex = i * batchSize;
            int toIndex = Math.min((i + 1) * batchSize, totalSize);
            List<String> batchIds = deleteIds.subList(fromIndex, toIndex);

            int deletedCount = deleteFunction.apply(batchIds);
            totalDeleted += deletedCount;

//            logger.info("完成第{}批删除，本批删除{}条记录", i + 1, deletedCount);
        }

//        logger.info("批量删除完成，共删除{}条记录", totalDeleted);
    }

    /**
     * 全量同步人员基本信息Postgres到Oracle，original_id存在则update，不存在则insert
     */
    public void syncAll() {
        List<PostgresPerson> pgList = postgresPersonMapper.selectList(null);
        for (PostgresPerson pg : pgList) {
            // 字段映射
            Map<String, Function<PostgresPerson, String>> mapping = personFieldMapper.FIELD_MAPPING;
            OraclePerson oraclePerson = new OraclePerson();
            for (Map.Entry<String, Function<PostgresPerson, String>> entry : mapping.entrySet()) {
                personFieldMapper.setOracleField(oraclePerson, entry.getKey(), entry.getValue().apply(pg));
            }
            // 只同步 USCID 为指定值的数据，USCID 为空或null不推送
            String uscid = oraclePerson.getUscid();
            if (uscid == null || uscid.trim().isEmpty()) {
                continue; // USCID 为空不推送
            }
            if (!"12352230490632333M".equals(uscid)) {
                continue; // 只推送指定 USCID
            }
            // 判断original_id是否已存在
            QueryWrapper<OraclePerson> qw = new QueryWrapper<>();
            qw.eq("ORIGINAL_ID", oraclePerson.getOriginalId());
            OraclePerson exist = oraclePersonMapper.selectOne(qw);
            if (exist != null) {
                // 保持主键不变，更新
                oraclePerson.setRid(exist.getRid());
                oraclePersonMapper.updateById(oraclePerson);
            } else {
                oraclePersonMapper.insert(oraclePerson);
            }
        }
    }

    /**
     * 全量同步Postgres教育经历到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncEducationInfoAll() {
        List<PostgresPersonDetailEducationExperience> pgList = postgresPersonDetailEducationExperienceMapper
                .selectList(null);
        for (PostgresPersonDetailEducationExperience pg : pgList) {
            Map<String, Function<PostgresPersonDetailEducationExperience, String>> mapping = personEduInfoFieldMapper.FIELD_MAPPING;
            OraclePersonEduInfo oracleEdu = new OraclePersonEduInfo();
            for (Map.Entry<String, Function<PostgresPersonDetailEducationExperience, String>> entry : mapping
                    .entrySet()) {
                personEduInfoFieldMapper.setOracleField(oracleEdu, entry.getKey(), entry.getValue().apply(pg));
            }
            String uscid = oracleEdu.getUscid();
            if (uscid == null || uscid.trim().isEmpty()) {
                continue; // USCID 为空不推送
            }
            if (!"12352230490632333M".equals(uscid)) {
                continue; // 只推送指定 USCID
            }
            QueryWrapper<OraclePersonEduInfo> qw = new QueryWrapper<>();
            qw.eq("ORIGINAL_ID", oracleEdu.getOriginalId());
            OraclePersonEduInfo exist = oraclePersonEduInfoMapper.selectOne(qw);
            if (exist != null) {
                oracleEdu.setRid(exist.getRid());
                oraclePersonEduInfoMapper.updateById(oracleEdu);
            } else {
                oraclePersonEduInfoMapper.insert(oracleEdu);
            }
        }
    }

    /**
     * 全量同步Postgres工作经历标到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncWorkInfoAll() {
        logger.info("开始执行syncWorkInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_DFIXZgBn");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用批量删除工具方法删除Oracle表中的记录
            batchDelete(toDeleteIds, batchIds -> {
                QueryWrapper<OraclePersonEmprInfo> oracleQueryWrapper = new QueryWrapper<>();
                oracleQueryWrapper.in("ORIGINAL_ID", batchIds);
                return oraclePersonEmprInfoMapper.delete(oracleQueryWrapper);
            });

//            logger.info("正在从PostgreSQL查询工作经历数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
//            logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
//                logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_DFIXZgBn".equals(pg.getDetailId())) {
//                    logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personEmperFieldMapper.FIELD_MAPPING;
                OraclePersonEmprInfo oracleEmpr = new OraclePersonEmprInfo();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
//                        logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personEmperFieldMapper.setOracleField(oracleEmpr, fieldName, fieldValue);
                    }

                    // 打印关键字段的值
                    logger.info("记录ID: {} 的字段值:", pg.getId());
                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
                    logger.info("WKBEGN_DATE: [{}]", fieldValues.get("WKBEGN_DATE"));
                    logger.info("WKEND_DATE: [{}]", fieldValues.get("WKEND_DATE"));
                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
                        logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
                        logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

                    logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OraclePersonEmprInfo> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
                        logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OraclePersonEmprInfo exist = oraclePersonEmprInfoMapper.selectOne(qw);

                        if (exist != null) {
                            logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                            oracleEmpr.setRid(exist.getRid());
                            oraclePersonEmprInfoMapper.updateById(oracleEmpr);
                            updateCount++;
                            logger.info("更新成功");
                        } else {
                            logger.info("未找到已存在记录，准备插入新记录");
                            if (oracleEmpr.getRid() == null || oracleEmpr.getRid().trim().isEmpty()) {
                                logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                                continue;
                            }
                            oraclePersonEmprInfoMapper.insert(oracleEmpr);
                            insertCount++;
                            logger.info("插入成功");
                        }
                    } catch (Exception e) {
                        logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),
                                e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * * 全量同步Postgres聘任信息到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncEmpTypeInfoAll() {
        logger.info("开始执行syncEmpTypeInfoAll同步...");

        try {
            // logger.info("正在从PostgreSQL查询work_experience数据...");
            List<PostgresPersonDetailWorkExperience> pgList = postgresPersonDetailWorkExperienceMapper.selectList(null);
            // logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailWorkExperience pg : pgList) {
                // logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                Map<String, Function<PostgresPersonDetailWorkExperience, String>> mapping = personEmpFieldMapper.FIELD_MAPPING;
                OraclePersonEmpType oracleEmpType = new OraclePersonEmpType();

                try {
                    for (Map.Entry<String, Function<PostgresPersonDetailWorkExperience, String>> entry : mapping
                            .entrySet()) {
                        personEmpFieldMapper.setOracleField(oracleEmpType, entry.getKey(), entry.getValue().apply(pg));
                    }
                } catch (Exception e) {
                    // logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }

                String uscid = oracleEmpType.getUscid();
                if (uscid == null || uscid.trim().isEmpty()) {
                    // logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                    continue;
                }
                if (!"12352230490632333M".equals(uscid)) {
                    // logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                    continue;
                }
                //
                // logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}",
                // oracleEmpType.getOriginalId(), uscid);

                try {
                    QueryWrapper<OraclePersonEmpType> qw = new QueryWrapper<>();
                    qw.eq("ORIGINAL_ID", oracleEmpType.getOriginalId());
                    // logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}",
                    // oracleEmpType.getOriginalId());
                    OraclePersonEmpType exist = oraclePersonEmpTypeMapper.selectOne(qw);

                    if (exist != null) {
                        // logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                        oracleEmpType.setRid(exist.getRid());
                        oraclePersonEmpTypeMapper.updateById(oracleEmpType);
                        updateCount++;
                        // logger.info("更新成功");
                    } else {
                        // logger.info("未找到已存在记录，准备插入新记录");
                        if (oracleEmpType.getRid() == null || oracleEmpType.getRid().trim().isEmpty()) {
                            // logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                            continue;
                        }
                        oraclePersonEmpTypeMapper.insert(oracleEmpType);
                        insertCount++;
                        // logger.info("插入成功");
                    }
                } catch (Exception e) {
                    logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", oracleEmpType.getOriginalId(), e.getMessage(),
                            e);
                }
            }

            logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres高层次人才奖励信息到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncHeightAwardInfoAll() {
        logger.info("开始执行syncHeightAwardInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_iMSAH8eL");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用batchDelete方法删除Oracle表中的记录
            if (!toDeleteIds.isEmpty()) {
                batchDelete(toDeleteIds, ids -> {
                    QueryWrapper<OraclePersonHeigthAward> oracleQueryWrapper = new QueryWrapper<>();
                    oracleQueryWrapper.in("ORIGINAL_ID", ids);
                    return oraclePersonHeigthAwardMapper.delete(oracleQueryWrapper);
                });
//                logger.info("成功清理不符合条件的数据");
            }

//            logger.info("正在从PostgreSQL查询height_award数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
//            logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
//                logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_iMSAH8eL".equals(pg.getDetailId())) {
//                    logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, ?>> mapping = personHeightAward.FIELD_MAPPING;
                OraclePersonHeigthAward oracleHeightAward = new OraclePersonHeigthAward();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, ?>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        Object fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 所有值都转换为String
                        String strValue = fieldValue == null ? " " : fieldValue.toString();
//                        personHeightAward.setOracleField(oracleHeightAward, fieldName, strValue);
                    }

                    // 打印所有日期字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("AWARDS_TIME: [{}]", fieldValues.get("AWARDS_TIME"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }

                String uscid = oracleHeightAward.getUscid();
                if (uscid == null || uscid.trim().isEmpty()) {
//                    logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                    continue;
                }
                if (!"12352230490632333M".equals(uscid)) {
//                    logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                    continue;
                }

             //   logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", oracleHeightAward.getOriginalId(), uscid);

                try {
                    QueryWrapper<OraclePersonHeigthAward> qw = new QueryWrapper<>();
                    qw.eq("ORIGINAL_ID", oracleHeightAward.getOriginalId());
                    //     logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", oracleHeightAward.getOriginalId());
                    OraclePersonHeigthAward exist = oraclePersonHeigthAwardMapper.selectOne(qw);

                    if (exist != null) {
                        //     logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                        oracleHeightAward.setRid(exist.getRid());
                        oraclePersonHeigthAwardMapper.updateById(oracleHeightAward);
                        updateCount++;
                        //      logger.info("更新成功");
                    } else {
                        //      logger.info("未找到已存在记录，准备插入新记录");
                        if (oracleHeightAward.getRid() == null || oracleHeightAward.getRid().trim().isEmpty()) {
                            // logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                            continue;
                        }
                        oraclePersonHeigthAwardMapper.insert(oracleHeightAward);
                        insertCount++;
                        //       logger.info("插入成功");
                    }
                } catch (Exception e) {
                    logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", oracleHeightAward.getOriginalId(),
                            e.getMessage(), e);
                }
            }

            logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步高层次人才类型信息到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncHeightInfoAll() {
        logger.info("开始执行syncHeightInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_1ajwVmzB");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用batchDelete方法删除Oracle表中的记录
            if (!toDeleteIds.isEmpty()) {
                batchDelete(toDeleteIds, ids -> {
                    QueryWrapper<OraclePersonHeigth> oracleQueryWrapper = new QueryWrapper<>();
                    oracleQueryWrapper.in("ORIGINAL_ID", ids);
                    return oraclePersonHeigthMapper.delete(oracleQueryWrapper);
                });
                //  logger.info("成功清理不符合条件的数据");
            }

            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //   logger.info("Found {} records in PostgreSQL height table", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                processCount++;

                // 检查detail_id是否符合条件
                if (!"person_detail_1ajwVmzB".equals(pg.getDetailId())) {
                    //      logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personHeightFieldMapper.FIELD_MAPPING;
                OraclePersonHeigth oracleHeight = new OraclePersonHeigth();

                for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                    try {
                        personHeightFieldMapper.setOracleField(oracleHeight, entry.getKey(),
                                entry.getValue().apply(pg));
                    } catch (Exception e) {
                        logger.error("Error mapping field {} for record {}: {}", entry.getKey(), pg.getId(), e.getMessage());
                        continue;
                    }
                }

                String uscid = oracleHeight.getUscid();
                if (uscid == null || uscid.trim().isEmpty()) {
                    //      logger.debug("Skipping record with empty USCID, ORIGINAL_ID: {}", oracleHeight.getOriginalId());
                    continue; // USCID 为空不推送
                }
                if (!"12352230490632333M".equals(uscid)) {
                    //   logger.debug("Skipping record with non-matching USCID: {}, ORIGINAL_ID: {}", uscid,oracleHeight.getOriginalId());
                    continue; // 只推送指定 USCID
                }

                //     logger.info("Processing record with ORIGINAL_ID: {}, USCID: {}", oracleHeight.getOriginalId(), uscid);

                QueryWrapper<OraclePersonHeigth> qw = new QueryWrapper<>();
                qw.eq("ORIGINAL_ID", oracleHeight.getOriginalId());
                OraclePersonHeigth exist = oraclePersonHeigthMapper.selectOne(qw);

                try {
                    if (exist != null) {
                        //         logger.info("Updating existing record with RID: {}", exist.getRid());
                        oracleHeight.setRid(exist.getRid());
                        oraclePersonHeigthMapper.updateById(oracleHeight);
                        updateCount++;
                    } else {
                        //         logger.info("Inserting new record");
                        oraclePersonHeigthMapper.insert(oracleHeight);
                        insertCount++;
                    }
                } catch (Exception e) {
                    logger.error("Error saving record {}: {}", oracleHeight.getOriginalId(), e.getMessage());
                }
            }

            //    logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres论文信息到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncPaperInfoAll() {
        logger.info("开始执行syncPaperInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_kX9wywgy");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用batchDelete方法删除Oracle表中的记录
            if (!toDeleteIds.isEmpty()) {
                batchDelete(toDeleteIds, ids -> {
                    QueryWrapper<OraclePersonPaper> oracleQueryWrapper = new QueryWrapper<>();
                    oracleQueryWrapper.in("ORIGINAL_ID", ids);
                    return oraclePersonPaperMapper.delete(oracleQueryWrapper);
                });
                //   logger.info("成功清理不符合条件的数据");
            }

            //    logger.info("正在从PostgreSQL查询论文数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //  logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                // 检查detail_id是否符合条件
                if (!"person_detail_kX9wywgy".equals(pg.getDetailId())) {
                    //         logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personPaperFieldMapper.FIELD_MAPPING;
                OraclePersonPaper oraclePaper = new OraclePersonPaper();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);
                        personPaperFieldMapper.setOracleField(oraclePaper, fieldName, fieldValue);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }

                String uscid = oraclePaper.getUscid();
                if (uscid == null || uscid.trim().isEmpty()) {
                    continue;
                }
                if (!"12352230490632333M".equals(uscid)) {
                    continue;
                }

                try {
                    QueryWrapper<OraclePersonPaper> qw = new QueryWrapper<>();
                    qw.eq("ORIGINAL_ID", oraclePaper.getOriginalId());
                    OraclePersonPaper exist = oraclePersonPaperMapper.selectOne(qw);

                    if (exist != null) {
                        oraclePaper.setRid(exist.getRid());
                        oraclePersonPaperMapper.updateById(oraclePaper);
                        updateCount++;
                    } else {
                        oraclePersonPaperMapper.insert(oraclePaper);
                        insertCount++;
                    }
                } catch (Exception e) {
                    logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", oraclePaper.getOriginalId(), e.getMessage(), e);
                }
            }

            logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres专利信息到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncPatentInfoAll() {
        //     logger.info("开始执行syncPatentInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_zT5ssVbi");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用batchDelete方法删除Oracle表中的记录
            if (!toDeleteIds.isEmpty()) {
                batchDelete(toDeleteIds, ids -> {
                    QueryWrapper<OraclePersonPatent> oracleQueryWrapper = new QueryWrapper<>();
                    oracleQueryWrapper.in("ORIGINAL_ID", ids);
                    return oraclePersonPatentMapper.delete(oracleQueryWrapper);
                });
                //          logger.info("成功清理不符合条件的数据");
            }

            //        logger.info("正在从PostgreSQL查询专利数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //     logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                //         logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_rBtRIvSB".equals(pg.getDetailId())) {
                    //          logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                // 打印custom_fields内容
                //        logger.info("记录的custom_fields内容: {}", pg.getCustomFields());

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personPatentFieldMapper.FIELD_MAPPING;
                OraclePersonPatent oraclePatent = new OraclePersonPatent();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
                        //                logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personPatentFieldMapper.setOracleField(oraclePatent, fieldName, fieldValue);
                    }

                    // 打印关键字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("GRANT_DATE: [{}]", fieldValues.get("GRANT_DATE"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
//                    logger.info("PATENT_NO: [{}]", fieldValues.get("PATENT_NO"));
//                    logger.info("PATENT_NAME: [{}]", fieldValues.get("PATENT_NAME"));
//                    logger.info("PATENT_OWNER: [{}]", fieldValues.get("PATENT_OWNER"));
//                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
//                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
                        //       logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
                        //      logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

                    //      logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OraclePersonPatent> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
                        //           logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OraclePersonPatent exist = oraclePersonPatentMapper.selectOne(qw);

                        if (exist != null) {
                            oraclePatent.setRid(exist.getRid());
                            oraclePersonPatentMapper.updateById(oraclePatent);
                            updateCount++;
                        } else {
                            oraclePersonPatentMapper.insert(oraclePatent);
                            insertCount++;
                        }
                    } catch (Exception e) {
                        logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),
                                e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            //      logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres专业技术资格标到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncTechInfoAll() {
        logger.info("开始执行syncTechInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_kX9wywgy");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用batchDelete方法删除Oracle表中的记录
            if (!toDeleteIds.isEmpty()) {
                batchDelete(toDeleteIds, ids -> {
                    QueryWrapper<OraclePersonProf> oracleQueryWrapper = new QueryWrapper<>();
                    oracleQueryWrapper.in("ORIGINAL_ID", ids);
                    return oraclePersonProfMapper.delete(oracleQueryWrapper);
                });
                //     logger.info("成功清理不符合条件的数据");
            }

            //     logger.info("正在从PostgreSQL查询专业技术资格数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //    logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                //       logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_kX9wywgy".equals(pg.getDetailId())) {
                    //            logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personPsnProfFieldMapper.FIELD_MAPPING;
                OraclePersonProf oracleProf = new OraclePersonProf();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
                        //         logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personPsnProfFieldMapper.setOracleField(oracleProf, fieldName, fieldValue);
                    }

                    // 打印关键字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("GET_DATE: [{}]", fieldValues.get("GET_DATE"));
//                    logger.info("EXPY_START_TIME: [{}]", fieldValues.get("EXPY_START_TIME"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
//                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
//                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
//                        logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
//                        logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

//                    logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OraclePersonProf> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
//                        logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OraclePersonProf exist = oraclePersonProfMapper.selectOne(qw);

                        if (exist != null) {
//                            logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                            oracleProf.setRid(exist.getRid());
                            oraclePersonProfMapper.updateById(oracleProf);
                            updateCount++;
//                            logger.info("更新成功");
                        } else {
//                            logger.info("未找到已存在记录，准备插入新记录");
                            if (oracleProf.getRid() == null || oracleProf.getRid().trim().isEmpty()) {
//                                logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                                continue;
                            }
                            oraclePersonProfMapper.insert(oracleProf);
                            insertCount++;
//                            logger.info("插入成功");
                        }
                    } catch (Exception e) {
                        logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),
                                e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres科研情况信息表到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncResearchInfoAll() {
        logger.info("开始执行syncResearchInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_zT5ssVbi");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用批量删除工具方法删除Oracle表中的记录
            batchDelete(toDeleteIds, batchIds -> {
                QueryWrapper<OraclePersonResearch> oracleQueryWrapper = new QueryWrapper<>();
                oracleQueryWrapper.in("ORIGINAL_ID", batchIds);
                return oraclePersonResearchMapper.delete(oracleQueryWrapper);
            });

            //    logger.info("正在从PostgreSQL查询科研项目数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //    logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                //        logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_zT5ssVbi".equals(pg.getDetailId())) {
                    //           logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personResearchMapper.FIELD_MAPPING;
                OraclePersonResearch oracleResearch = new OraclePersonResearch();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
                        //      logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personResearchMapper.setOracleField(oracleResearch, fieldName, fieldValue);
                    }

                    // 打印关键字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("START_TIME: [{}]", fieldValues.get("START_TIME"));
//                    logger.info("END_TIME: [{}]", fieldValues.get("END_TIME"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
//                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
//                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
                        //       logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
                        //      logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

                    //   logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OraclePersonResearch> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
                        //       logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OraclePersonResearch exist = oraclePersonResearchMapper.selectOne(qw);

                        if (exist != null) {
                            //         logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                            oracleResearch.setRid(exist.getRid());
                            oraclePersonResearchMapper.updateById(oracleResearch);
                            updateCount++;
                            //         logger.info("更新成功");
                        } else {
                            //         logger.info("未找到已存在记录，准备插入新记录");
                            if (oracleResearch.getRid() == null || oracleResearch.getRid().trim().isEmpty()) {
                                //              logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                                continue;
                            }
                            oraclePersonResearchMapper.insert(oracleResearch);
                            insertCount++;
                            //       logger.info("插入成功");
                        }
                    } catch (Exception e) {
                        logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),
                                e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            //    logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres个人奖励称号信息表到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncHonorInfoAll() {
        logger.info("开始执行syncHonorInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_IvMVko5s");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用批量删除工具方法删除Oracle表中的记录
            batchDelete(toDeleteIds, batchIds -> {
                QueryWrapper<OraclePersonRewards> oracleQueryWrapper = new QueryWrapper<>();
                oracleQueryWrapper.in("ORIGINAL_ID", batchIds);
                return oraclePersonRewardsMapper.delete(oracleQueryWrapper);
            });

            //  logger.info("正在从PostgreSQL查询荣誉信息数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //  logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                //    logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_IvMVko5s".equals(pg.getDetailId())) {
                    //    logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personRewardsFieldMapper.FIELD_MAPPING;
                OraclePersonRewards oracleRewards = new OraclePersonRewards();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
                        //        logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personRewardsFieldMapper.setOracleField(oracleRewards, fieldName, fieldValue);
                    }

                    // 打印关键字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("GET_DATE: [{}]", fieldValues.get("GET_DATE"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
//                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
//                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
                        //         logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
                        //        logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

                    //       logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OraclePersonRewards> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
                        //           logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OraclePersonRewards exist = oraclePersonRewardsMapper.selectOne(qw);

                        if (exist != null) {
                            //         logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                            oracleRewards.setRid(exist.getRid());
                            oraclePersonRewardsMapper.updateById(oracleRewards);
                            updateCount++;
                            //           logger.info("更新成功");
                        } else {
                            //            logger.info("未找到已存在记录，准备插入新记录");
                            if (oracleRewards.getRid() == null || oracleRewards.getRid().trim().isEmpty()) {
                                //                logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                                continue;
                            }
                            oraclePersonRewardsMapper.insert(oracleRewards);
                            insertCount++;
                            //        logger.info("插入成功");
                        }
                    } catch (Exception e) {
                        //     logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            //      logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres学术社团任职到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncSocietyInfoAll() {
        logger.info("开始执行syncSocietyInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_VXVwV5ve");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用批量删除工具方法删除Oracle表中的记录
            batchDelete(toDeleteIds, batchIds -> {
                QueryWrapper<OracleStaffCorp> oracleQueryWrapper = new QueryWrapper<>();
                oracleQueryWrapper.in("ORIGINAL_ID", batchIds);
                return oracleStaffCorpMapper.delete(oracleQueryWrapper);
            });

            //   logger.info("正在从PostgreSQL查询社会任职数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //  logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                //     logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_VXVwV5ve".equals(pg.getDetailId())) {
                    //       logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personStaffCorpFieldMapper.FIELD_MAPPING;
                OracleStaffCorp oracleStaffCorp = new OracleStaffCorp();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
                        //       logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personStaffCorpFieldMapper.setOracleField(oracleStaffCorp, fieldName, fieldValue);
                    }

                    // 打印关键字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("START_TIME: [{}]", fieldValues.get("START_TIME"));
//                    logger.info("END_TIME: [{}]", fieldValues.get("END_TIME"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
//                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
//                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
                        //        logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
                        //         logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

                    //      logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OracleStaffCorp> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
                        //    logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OracleStaffCorp exist = oracleStaffCorpMapper.selectOne(qw);

                        if (exist != null) {
                            //         logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                            oracleStaffCorp.setRid(exist.getRid());
                            oracleStaffCorpMapper.updateById(oracleStaffCorp);
                            updateCount++;
                            //      logger.info("更新成功");
                        } else {
                            //        logger.info("未找到已存在记录，准备插入新记录");
                            if (oracleStaffCorp.getRid() == null || oracleStaffCorp.getRid().trim().isEmpty()) {
                                //         logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                                continue;
                            }
                            oracleStaffCorpMapper.insert(oracleStaffCorp);
                            insertCount++;
                            //      logger.info("插入成功");
                        }
                    } catch (Exception e) {
                        logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),
                                e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            //     logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres外出培训及学术活动到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncOutInfoAll() {
        //    logger.info("开始执行syncOutInfoAll同步...");

        try {
            //      logger.info("正在从PostgreSQL查询外出培训及学术活动数据...");
            List<PostgresPersonDetailTraining> pgList = postgresPersonDetailTrainingMapper.selectList(null);
            //     logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailTraining pg : pgList) {
                //      logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                Map<String, Function<PostgresPersonDetailTraining, String>> mapping = personStudyFieldMapper.FIELD_MAPPING;
                OracleStaffStudy oracleStudy = new OracleStaffStudy();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailTraining, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
                        //           logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personStudyFieldMapper.setOracleField(oracleStudy, fieldName, fieldValue);
                    }

//                    // 打印关键字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("BEGNDATE: [{}]", fieldValues.get("BEGNDATE"));
//                    logger.info("ENDDATE: [{}]", fieldValues.get("ENDDATE"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
//                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
//                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
                        //       logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
                        //         logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

                    //        logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OracleStaffStudy> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
                        //       logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OracleStaffStudy exist = oracleStaffStudyMapper.selectOne(qw);

                        if (exist != null) {
                            //            logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                            oracleStudy.setRid(exist.getRid());
                            oracleStaffStudyMapper.updateById(oracleStudy);
                            updateCount++;
                            //             logger.info("更新成功");
                        } else {
                            //           logger.info("未找到已存在记录，准备插入新记录");
                            if (oracleStudy.getRid() == null || oracleStudy.getRid().trim().isEmpty()) {
                                //                logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                                continue;
                            }
                            oracleStaffStudyMapper.insert(oracleStudy);
                            insertCount++;
                            //            logger.info("插入成功");
                        }
                    } catch (Exception e) {
                        logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),
                                e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            //    logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres研究生导师标到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncSuperviseInfoAll() {
        logger.info("开始执行syncSuperviseInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_ZrcjY4VG");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用批量删除工具方法删除Oracle表中的记录
            batchDelete(toDeleteIds, batchIds -> {
                QueryWrapper<OracleStaffStudy> oracleQueryWrapper = new QueryWrapper<>();
                oracleQueryWrapper.in("ORIGINAL_ID", batchIds);
                return oracleStaffStudyMapper.delete(oracleQueryWrapper);
            });

            // logger.info("正在从PostgreSQL查询研究生导师数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //   logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                //        logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_ZrcjY4VG".equals(pg.getDetailId())) {
                    //        logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personTrainingFieldMapper.FIELD_MAPPING;
                OracleStaffStudy oracleStaffStudy = new OracleStaffStudy();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
                        //        logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personStudyFieldMapper.setOracleField(oracleStaffStudy, fieldName, fieldValue);
                    }

                    // 打印关键字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("START_TIME: [{}]", fieldValues.get("START_TIME"));
//                    logger.info("END_TIME: [{}]", fieldValues.get("END_TIME"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
//                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
//                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
                        //             logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
                        //          logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

                    //          logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OracleStaffStudy> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
                        //        logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OracleStaffStudy exist = oracleStaffStudyMapper.selectOne(qw);

                        if (exist != null) {
                            //          logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                            oracleStaffStudy.setRid(exist.getRid());
                            oracleStaffStudyMapper.updateById(oracleStaffStudy);
                            updateCount++;
                            //        logger.info("更新成功");
                        } else {
                            //        logger.info("未找到已存在记录，准备插入新记录");
                            if (oracleStaffStudy.getRid() == null || oracleStaffStudy.getRid().trim().isEmpty()) {
                                //             logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                                continue;
                            }
                            oracleStaffStudyMapper.insert(oracleStaffStudy);
                            insertCount++;
                            //       logger.info("插入成功");
                        }
                    } catch (Exception e) {
                        logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),
                                e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            //    logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

    /**
     * 全量同步Postgres学术兼职标到Oracle，original_id存在则update，不存在则insert
     * 只同步USCID有值且为指定机构代码的数据
     */
    public void syncAcademicInfoAll() {
        logger.info("开始执行syncAcademicInfoAll同步...");

        try {
            // 先从PostgreSQL获取detail_id不等于指定值的记录的id列表
            QueryWrapper<PostgresPersonDetailCustom> pgQueryWrapper = new QueryWrapper<>();
            pgQueryWrapper.ne("detail_id", "person_detail_JWsgfpYe");
            List<PostgresPersonDetailCustom> toDeleteList = postgresPersonDetailCustomMapper.selectList(pgQueryWrapper);
            List<String> toDeleteIds = toDeleteList.stream()
                    .map(PostgresPersonDetailCustom::getId)
                    .collect(Collectors.toList());

            // 使用批量删除工具方法删除Oracle表中的记录
            batchDelete(toDeleteIds, batchIds -> {
                QueryWrapper<OracleStaffCorp> oracleQueryWrapper = new QueryWrapper<>();
                oracleQueryWrapper.in("ORIGINAL_ID", batchIds);
                return oracleStaffCorpMapper.delete(oracleQueryWrapper);
            });

            //   logger.info("正在从PostgreSQL查询学术兼职数据...");
            List<PostgresPersonDetailCustom> pgList = postgresPersonDetailCustomMapper.selectList(null);
            //    logger.info("PostgreSQL查询完成，共获取{}条记录", pgList.size());

            int processCount = 0;
            int updateCount = 0;
            int insertCount = 0;

            for (PostgresPersonDetailCustom pg : pgList) {
                //       logger.debug("正在处理第{}条记录，ID: {}", ++processCount, pg.getId());

                // 检查detail_id是否符合条件
                if (!"person_detail_JWsgfpYe".equals(pg.getDetailId())) {
                    //       logger.debug("跳过非目标detail_id记录，当前detail_id: {}, ID: {}", pg.getDetailId(), pg.getId());
                    continue;
                }

                Map<String, Function<PostgresPersonDetailCustom, String>> mapping = personStaffCorpFieldMapper.FIELD_MAPPING;
                OracleStaffCorp oracleStaffCorp = new OracleStaffCorp();

                try {
                    // 记录所有字段的映射过程
                    Map<String, Object> fieldValues = new HashMap<>();
                    for (Map.Entry<String, Function<PostgresPersonDetailCustom, String>> entry : mapping.entrySet()) {
                        String fieldName = entry.getKey();
                        String fieldValue = entry.getValue().apply(pg);
                        fieldValues.put(fieldName, fieldValue);

                        // 打印每个字段的映射结果
                        //         logger.info("字段映射 - {}: [{}]", fieldName, fieldValue);

                        personStaffCorpFieldMapper.setOracleField(oracleStaffCorp, fieldName, fieldValue);
                    }

                    // 打印关键字段的值
//                    logger.info("记录ID: {} 的字段值:", pg.getId());
//                    logger.info("UPLOAD_TIME: [{}]", fieldValues.get("UPLOAD_TIME"));
//                    logger.info("START_TIME: [{}]", fieldValues.get("START_TIME"));
//                    logger.info("END_TIME: [{}]", fieldValues.get("END_TIME"));
//                    logger.info("CRTE_TIME: [{}]", fieldValues.get("CRTE_TIME"));
//                    logger.info("UPDT_TIME: [{}]", fieldValues.get("UPDT_TIME"));
//                    logger.info("DELETED_TIME: [{}]", fieldValues.get("DELETED_TIME"));
//                    logger.info("USCID: [{}]", fieldValues.get("USCID"));
//                    logger.info("ORG_NAME: [{}]", fieldValues.get("ORG_NAME"));

                    String uscid = (String) fieldValues.get("USCID");
                    if (uscid == null || uscid.trim().isEmpty()) {
                        //       logger.debug("跳过空USCID记录，ID: {}", pg.getId());
                        continue;
                    }
                    if (!"12352230490632333M".equals(uscid.trim())) {
                        //          logger.debug("跳过非目标USCID记录，当前USCID: {}, ID: {}", uscid, pg.getId());
                        continue;
                    }

                    //       logger.info("准备同步记录到Oracle，ORIGINAL_ID: {}, USCID: {}", fieldValues.get("ORIGINAL_ID"), uscid);

                    try {
                        QueryWrapper<OracleStaffCorp> qw = new QueryWrapper<>();
                        qw.eq("ORIGINAL_ID", fieldValues.get("ORIGINAL_ID"));
                        //       logger.debug("正在Oracle中查询是否存在记录，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                        OracleStaffCorp exist = oracleStaffCorpMapper.selectOne(qw);

                        if (exist != null) {
                            //          logger.info("找到已存在记录，准备更新，RID: {}", exist.getRid());
                            oracleStaffCorp.setRid(exist.getRid());
                            oracleStaffCorpMapper.updateById(oracleStaffCorp);
                            updateCount++;
                            //         logger.info("更新成功");
                        } else {
                            //         logger.info("未找到已存在记录，准备插入新记录");
                            if (oracleStaffCorp.getRid() == null || oracleStaffCorp.getRid().trim().isEmpty()) {
                                //             logger.warn("RID为空，跳过插入，ORIGINAL_ID: {}", fieldValues.get("ORIGINAL_ID"));
                                continue;
                            }
                            oracleStaffCorpMapper.insert(oracleStaffCorp);
                            insertCount++;
                            //         logger.info("插入成功");
                        }
                    } catch (Exception e) {
                        logger.error("Oracle操作失败，ORIGINAL_ID: {}, 错误: {}", fieldValues.get("ORIGINAL_ID"),
                                e.getMessage(), e);
                    }

                } catch (Exception e) {
                    logger.error("字段映射失败，记录ID: {}, 错误: {}", pg.getId(), e.getMessage(), e);
                    continue;
                }
            }

            //  logger.info("同步完成，总处理: {}条，更新: {}条，插入: {}条", processCount, updateCount, insertCount);
        } catch (Exception e) {
            logger.error("同步过程发生异常: {}", e.getMessage(), e);
            throw e;
        }
    }

}
