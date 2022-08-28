package com.only4play.extension.executor;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author gim
 */
public abstract class AbstractServiceSelectorExecutor implements ServiceExecutor {

  /**
   * 执行void 方法
   *
   * @param clazz
   * @param bizScene
   * @param consumer
   * @param <S>
   */
  @Override
  public <S> void execute(Class<S> clazz, BizScene bizScene, Consumer<S> consumer) {
    S service = selectService(bizScene, clazz);
    consumer.accept(service);
  }

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
  @Override
  public <R, S> R execute(Class<S> clazz, BizScene bizScene, Function<S, R> function) {
    S service = selectService(bizScene, clazz);
    return function.apply(service);
  }

  /**
   * 根据BizScene 查询相应的Service
   *
   * @param bizScene
   * @param clazz    接口Class
   * @return
   */
  protected abstract <S> S selectService(BizScene bizScene, Class<S> clazz);

}
