package com.only4play.common.exception;

import com.only4play.common.model.ValidateResult;
import java.util.List;
import lombok.Getter;

/**
 * @author gim
 */
public class ValidationException extends RuntimeException {
  @Getter
  private List<ValidateResult> result;
  public ValidationException(List<ValidateResult> list){
    super();
    this.result = list;
  }
}
