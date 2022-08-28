package com.only4play.security.base.extension;


import com.only4play.security.base.BaseJwtUser;

/**
 * @author gim
 */
public interface UserContextAware {

  /**
   * 处理token
    * @param token
   * @return
   */
  BaseJwtUser processToken(String token);

}
