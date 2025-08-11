package com.springbootTz.ZNYY.Equipment.service;

import com.springbootTz.ZNYY.Equipment.mapper.seeyon.LexmisN6_AssetCardMapper;
import com.springbootTz.ZNYY.Equipment.mapper.seeyon.UnitInfoToolMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipDiscardedRecordService {
    @Autowired
    private UnitInfoToolMapper unitInfoToolMapper;

    @Autowired
    private LexmisN6_AssetCardMapper lexmisN6_AssetCardMapper;
    /**
     * 映射关系
     *  equip_discarded_record表，formmain_1082和formson_1083的关联表AssetDisposalWithDetailDTO
     *  rid，uscid+sys_prdr_code+discarded_no
     *  orgName,unitInfoToolMapper.selectUnitNameById(field0034)
     *  uscid,unitInfoToolMapper.selectUnitCodeByName(field0034)
     *  uploadTime,当前上传时间
     *  sysPrdrCode,FJZZZYKJGS
     *  sysPrdrName,福建众智政友有限公司
     *  discardedNo,field0001
     *  equipCode,field0023
     *  equipName,field0006
     *  spec,无
     *  equipModel,field0013
     *  unit,1
     *  unitName,个
     *  useDep,field0019
     *  equipPric,field0015
     *  purcDate,field0014
     *  usedLife,当前日期-field0015获取已用年限
     *  estimaResidualValue,
     *  discardedRea,0
     *  applyerName,field0009
     *  applyDate,无
     *  auditOperatorName,无
     *  auditDate,startDate
     *  manufacturerCode,无
     *  manufacturerName,lexmisN6_AssetCardMapper.selectByAcNo(field0023),然后对应为ev_field6（周总-车辆，周总-房屋土地，周总-家居设备，周总-医疗专用设备，周总-无形资产，周县-家居设备，周县-网络信息设备，周县-医疗专用设备，周县-无形资产，周县-车辆，周县-房屋土地），ev_field7（周总-网络信息设备）
     *  state,0
     *  reserve1,无
     *  reserve2,无
     *  dataClctPrdrName,福建众智政友有限公司
     *  crteTime,startDate
     *  updtTime,startDate
     *  deleted,默认0，除非update的时候没有这条记录需要update，那就把deleted设为1，表示该条记录被删除了
     *  deletedTime，null
     *
     */
}
