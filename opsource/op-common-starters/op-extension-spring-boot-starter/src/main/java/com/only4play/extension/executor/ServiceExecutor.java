package com.only4play.extension.executor;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author gim
 */
public interface ServiceExecutor {

  /**
   * 执行void 方法
   *
   * @param clazz
   * @param bizScene
   * @param consumer
   * @param <S>
   */
  <S> void execute(Class<S> clazz, BizScene bizScene, Consumer<S> consumer);

  /**
   * 执行有返回值的方法
   *
   * @param clazz
   * @param bizScene
   * @param function
   * @param <R>
   * @param <S>
   * @return
   */
  <R, S> R execute(Class<S> clazz, BizScene bizScene, Function<S, R> function);

}
