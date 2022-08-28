package com.only4play.system.domain.asset.assetrecord;

import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.jpa.support.BaseJpaAggregate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.asset.assetrecord.vo")
@GenCreator(pkgName = "com.only4play.system.domain.asset.assetrecord.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.asset.assetrecord.updater")
@GenRepository(pkgName = "com.only4play.system.domain.asset.assetrecord.repository")
@Entity
@Table(name = "asset_record_detail")
@Data
public class AssetRecordDetail extends BaseJpaAggregate {

  private Long recordId;

  private String uniqueCode;

}
