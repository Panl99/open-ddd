package com.only4play.system.domain.asset.asset;

import com.only4play.codegen.processor.api.GenCreateRequest;
import com.only4play.codegen.processor.api.GenQueryRequest;
import com.only4play.codegen.processor.api.GenResponse;
import com.only4play.codegen.processor.api.GenUpdateRequest;
import com.only4play.codegen.processor.controller.GenController;
import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.creator.IgnoreCreator;
import com.only4play.codegen.processor.mapper.GenMapper;
import com.only4play.codegen.processor.query.GenQuery;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.service.GenService;
import com.only4play.codegen.processor.service.GenServiceImpl;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.common.annotation.FieldDesc;
import com.only4play.common.constants.ValidStatus;
import com.only4play.common.exception.BusinessException;
import com.only4play.jpa.converter.ValidStatusConverter;
import com.only4play.jpa.support.BaseJpaAggregate;
import com.only4play.system.domain.asset.asset.domainservice.model.AssetBizInfo;
import com.only4play.system.domain.asset.asset.events.AssetEvents;
import com.only4play.system.infrastructure.constants.AssetErrorCode;
import lombok.Data;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@GenVo(pkgName = "com.only4play.system.domain.asset.asset.vo")
@GenCreator(pkgName = "com.only4play.system.domain.asset.asset.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.asset.asset.updater")
@GenRepository(pkgName = "com.only4play.system.domain.asset.asset.repository")
@GenService(pkgName = "com.only4play.system.domain.asset.asset.service")
@GenServiceImpl(pkgName = "com.only4play.system.domain.asset.asset.service")
@GenQuery(pkgName = "com.only4play.system.domain.asset.asset.query")
@GenMapper(pkgName = "com.only4play.system.domain.asset.asset.mapper")
@GenController(pkgName = "com.only4play.system.controller")
@GenCreateRequest(pkgName = "com.only4play.system.domain.asset.asset.request")
@GenUpdateRequest(pkgName = "com.only4play.system.domain.asset.asset.request")
@GenQueryRequest(pkgName = "com.only4play.system.domain.asset.asset.request")
@GenResponse(pkgName = "com.only4play.system.domain.asset.asset.response")
@Entity
@Table(name = "asset")
@Data
public class Asset extends BaseJpaAggregate {

    @FieldDesc(name = "仓库id")
    private Long houseId;

    @Convert(converter = ValidStatusConverter.class)
    @IgnoreUpdater
    @IgnoreCreator
    private ValidStatus validStatus;

    @FieldDesc(name = "资产名称")
    private String name;

    @FieldDesc(name = "唯一编码")
    private String uniqueCode;

    @FieldDesc(name = "skuId")
    private Long skuId;


    public void init(){
        setValidStatus(ValidStatus.VALID);
    }


    /**
     * 入库
     */
    public void in(AssetBizInfo bizInfo){
        if(Objects.equals(ValidStatus.VALID,this.getValidStatus())){
            throw new BusinessException(AssetErrorCode.ASSET_HAS_IN);
        }
        setValidStatus(ValidStatus.VALID);
        registerEvent(new AssetEvents.AssetInEvent(this, bizInfo));
    }

    /**
     * 出库
     */
    public void out(AssetBizInfo bizInfo){
        if(Objects.equals(ValidStatus.INVALID,this.getValidStatus())){
            throw new BusinessException(AssetErrorCode.ASSET_HAS_OUT);
        }
        setValidStatus(ValidStatus.INVALID);
        registerEvent(new AssetEvents.AssetOutEvent(this, bizInfo));
    }

}
