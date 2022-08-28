package com.only4play.system.domain.permission.role;

import com.only4play.codegen.processor.creator.GenCreator;
import com.only4play.codegen.processor.repository.GenRepository;
import com.only4play.codegen.processor.updater.GenUpdater;
import com.only4play.codegen.processor.vo.GenVo;
import com.only4play.jpa.support.BaseJpaAggregate;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@GenVo(pkgName = "com.only4play.system.domain.permission.role.vo")
@GenCreator(pkgName = "com.only4play.system.domain.permission.role.creator")
@GenUpdater(pkgName = "com.only4play.system.domain.permission.role.updater")
@GenRepository(pkgName = "com.only4play.system.domain.permission.role.repository")
@Entity
@Table(name = "role_resource_rel")
@Data
public class RoleResourceRel extends BaseJpaAggregate {

  private Long roleId;

  private Long resourceId;

}
