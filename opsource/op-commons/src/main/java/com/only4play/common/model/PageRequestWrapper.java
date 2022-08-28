package com.only4play.common.model;

import java.util.Map;
import lombok.Data;

/**
 * @author gim
 */
@Data
public class PageRequestWrapper<T> {

  private T bean;
  private Integer pageSize;
  private Integer page;
  private Map<String, String> sorts;
}
