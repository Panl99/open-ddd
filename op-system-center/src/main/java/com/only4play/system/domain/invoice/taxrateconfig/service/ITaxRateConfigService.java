// ---Auto Generated by Only4Play ---
package com.only4play.system.domain.invoice.taxrateconfig.service;

import com.only4play.common.model.PageRequestWrapper;
import com.only4play.system.domain.invoice.taxrateconfig.creator.TaxRateConfigCreator;
import com.only4play.system.domain.invoice.taxrateconfig.query.TaxRateConfigQuery;
import com.only4play.system.domain.invoice.taxrateconfig.updater.TaxRateConfigUpdater;
import com.only4play.system.domain.invoice.taxrateconfig.vo.TaxRateConfigVO;
import java.lang.Long;
import org.springframework.data.domain.Page;

public interface ITaxRateConfigService {
  /**
   * create
   */
  Long createTaxRateConfig(TaxRateConfigCreator creator);

  /**
   * update
   */
  void updateTaxRateConfig(TaxRateConfigUpdater updater);

  /**
   * valid
   */
  void validTaxRateConfig(Long id);

  /**
   * invalid
   */
  void invalidTaxRateConfig(Long id);

  /**
   * findById
   */
  TaxRateConfigVO findById(Long id);

  /**
   * findByPage
   */
  Page<TaxRateConfigVO> findByPage(PageRequestWrapper<TaxRateConfigQuery> query);
}