// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.template.objecttemplate.service;

import com.only4play.common.model.PageRequestWrapper;
import com.only4play.system.domain.template.objecttemplate.creator.ObjectTemplateCreator;
import com.only4play.system.domain.template.objecttemplate.query.ObjectTemplateQuery;
import com.only4play.system.domain.template.objecttemplate.updater.ObjectTemplateUpdater;
import com.only4play.system.domain.template.objecttemplate.vo.ObjectTemplateVO;
import java.lang.Long;
import org.springframework.data.domain.Page;

public interface IObjectTemplateService {
  /**
   * create
   */
  Long createObjectTemplate(ObjectTemplateCreator creator);

  /**
   * update
   */
  void updateObjectTemplate(ObjectTemplateUpdater updater);

  /**
   * valid
   */
  void validObjectTemplate(Long id);

  /**
   * invalid
   */
  void invalidObjectTemplate(Long id);

  /**
   * findById
   */
  ObjectTemplateVO findById(Long id);

  /**
   * findByPage
   */
  Page<ObjectTemplateVO> findByPage(PageRequestWrapper<ObjectTemplateQuery> query);
}
