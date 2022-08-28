package com.only4play.mybatis.support;

import java.io.Serializable;
import java.util.function.Supplier;

/**
 * @author gim 2022/1/28 9:07 下午
 */
public interface Loader<T> {

  UpdateHandler<T> loadById(Serializable id);

  UpdateHandler<T> load(Supplier<T> t);

}
