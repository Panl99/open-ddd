package com.only4play.system.domain.objectsku;

import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.jpa.support.BaseJpaAggregate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.objectsku.vo")
@GenCreator(pkgName = "com.only4play.system.domain.objectsku.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.objectsku.updater")
@GenRepository(pkgName = "com.only4play.system.domain.objectsku.repository")
@Entity
@Table(name = "sku_attribute_rel")
@Data
public class SkuAttributeRel extends BaseJpaAggregate {

  private Long skuId;

  private String attributeId;

}
