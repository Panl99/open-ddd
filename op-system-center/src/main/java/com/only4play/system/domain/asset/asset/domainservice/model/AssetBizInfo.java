package com.only4play.system.domain.asset.asset.domainservice.model;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.system.domain.asset.assetrecord.InOutBizType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class AssetBizInfo {

    private InOutBizType inOutBizType;

    @FieldDesc(name = "唯一编码")
    private List<String> uniqueCodes;

    @FieldDesc(name = "批次号")
    private String batchNo;

    @FieldDesc(name = "自动生成批次号")
    private String genBatchNo;

    private String operateUser;
}