package com.only4play.system.domain.asset.asset.events;

import com.only4play.system.domain.asset.asset.Asset;
import com.only4play.system.domain.asset.asset.domainservice.model.AssetBizInfo;
import lombok.Value;

public interface AssetEvents {

    @Value
    class AssetInEvent{
        private Asset asset;
        private AssetBizInfo bizInfo;
    }

    @Value
    class AssetOutEvent{
        private Asset asset;
        private AssetBizInfo bizInfo;
    }

}
