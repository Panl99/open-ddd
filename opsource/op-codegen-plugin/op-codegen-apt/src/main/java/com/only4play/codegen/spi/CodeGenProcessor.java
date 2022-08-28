package com.only4play.codegen.spi;

import java.lang.annotation.Annotation;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;

/**
 * @author gim
 */
public interface CodeGenProcessor {

  /**
   * 需要解析的类上的注解
   * @return
   */
  Class<? extends Annotation> getAnnotation();

  /**
   * 获取生成的包路径
   * @return
   */
  String generatePackage(TypeElement typeElement);

  /**
   * 代码生成逻辑
   * @throws Exception
   */
  void generate(TypeElement typeElement, RoundEnvironment roundEnvironment) throws Exception;
}
