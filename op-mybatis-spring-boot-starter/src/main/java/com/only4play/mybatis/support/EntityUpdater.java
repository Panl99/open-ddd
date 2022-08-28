package com.only4play.mybatis.support;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.google.common.base.Preconditions;
import com.only4play.common.constants.CodeEnum;
import com.only4play.common.exception.BusinessException;
import com.only4play.common.validator.UpdateGroup;
import io.vavr.control.Try;
import java.io.Serializable;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import lombok.extern.slf4j.Slf4j;

/**
 * @author gim
 */
@Slf4j
public class EntityUpdater<T> extends BaseEntityOperation implements Loader<T>,
    UpdateHandler<T>, Executor<T> {

  private final BaseMapper<T> baseMapper;
  private T entity;
  private Consumer<T> successHook = t -> log.info("update success");
  private Consumer<? super Throwable> errorHook = e -> e.printStackTrace();

  public EntityUpdater(BaseMapper<T> baseMapper) {
    this.baseMapper = baseMapper;
  }

  @Override
  public Optional<T> execute() {
    doValidate(this.entity, UpdateGroup.class);
    T save = Try.of(() -> {
          baseMapper.updateById(entity);
          return this.entity;
        })
        .onSuccess(successHook)
        .onFailure(errorHook).getOrNull();
    return Optional.ofNullable(save);
  }

  @Override
  public UpdateHandler<T> loadById(Serializable id) {
    Preconditions.checkArgument(Objects.nonNull(id), "id is null");
    T t = baseMapper.selectById(id);
    if(Objects.isNull(t)){
      throw new BusinessException(CodeEnum.NotFindError);
    }else {
      this.entity = t;
    }
    return this;
  }

  @Override
  public UpdateHandler<T> load(Supplier<T> t) {
    this.entity = t.get();
    return this;
  }

  @Override
  public Executor<T> update(Consumer<T> consumer) {
    Preconditions.checkArgument(Objects.nonNull(entity), "entity is null");
    consumer.accept(this.entity);
    return this;
  }

  @Override
  public Executor<T> successHook(Consumer<T> consumer) {
    this.successHook = consumer;
    return this;
  }

  @Override
  public Executor<T> errorHook(Consumer<? super Throwable> consumer) {
    this.errorHook = consumer;
    return this;
  }

}