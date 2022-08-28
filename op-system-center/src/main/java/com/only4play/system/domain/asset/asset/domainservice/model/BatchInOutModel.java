package com.only4play.system.domain.asset.asset.domainservice.model;

import com.only4play.common.annotation.FieldDesc;
import com.only4play.system.domain.asset.assetrecord.InOutBizType;
import lombok.Data;
import java.util.List;

/**
 * 批量出入库模型
 */
@Data
public class BatchInOutModel {

    private String name;

    @FieldDesc(name = "出入库类型")
    private InOutBizType inOutBizType;

    @FieldDesc(name = "操作用户")
    private String operateUser;

    @FieldDesc(name = "仓库Id")
    private Long houseId;

    @FieldDesc(name = "唯一编码")
    private List<String> uniqueCodes;

    @FieldDesc(name = "批次号")
    private String batchNo;

    @FieldDesc(name = "skuId")
    private Long skuId;
}
