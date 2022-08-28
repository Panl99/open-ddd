package com.only4play.jpa.support;

import java.util.function.Supplier;

/**
 * @author gim 2022/1/28 9:55 下午
 */
public interface Create<T> {

  UpdateHandler<T> create(Supplier<T> supplier);

}
