package com.only4play.system.domain.asset.asset.domainservice;

import com.only4play.system.domain.asset.asset.domainservice.model.BatchInOutModel;
import com.only4play.system.domain.asset.asset.domainservice.model.TransferModel;

public interface IAssetDomainService {

    /**
     * 资产入库
     * @param batchInOutModel
     */
    void handleAssetIn(BatchInOutModel batchInOutModel);


    /**
     * 资产出库
     * @param batchInOutModel
     */
    void handleAssetOut(BatchInOutModel batchInOutModel);

    /**
     * 资产调拨，转移
     * @param transferModel
     */
    void handleAssetTransfer(TransferModel transferModel);
}
