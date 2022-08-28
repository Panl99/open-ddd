package com.only4play.codegen.processor.api;

import com.google.auto.service.AutoService;
import com.only4play.codegen.processor.BaseCodeGenProcessor;
import com.only4play.codegen.processor.DefaultNameContext;
import com.only4play.codegen.processor.query.QueryItem;
import com.only4play.codegen.spi.CodeGenProcessor;
import com.only4play.common.model.Request;
import com.squareup.javapoet.TypeSpec;
import io.swagger.v3.oas.annotations.media.Schema;
import java.lang.annotation.Annotation;
import java.util.Objects;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;

/**
 * @Author: Gim
 * @Date: 2019-10-08 17:14
 * @Description:
 */
@AutoService(value = CodeGenProcessor.class)
public class GenQueryRequestProcessor extends BaseCodeGenProcessor {

  public static String QUERY_REQUEST_SUFFIX = "QueryRequest";
  @Override
  protected void generateClass(TypeElement typeElement, RoundEnvironment roundEnvironment) {
    DefaultNameContext nameContext = getNameContext(typeElement);
    Set<VariableElement> fields = findFields(typeElement,
        p -> Objects.nonNull(p.getAnnotation(QueryItem.class)));
    TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(nameContext.getQueryRequestClassName())
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(Request.class)
        .addAnnotation(Schema.class);
    addSetterAndGetterMethodWithConverter(typeSpecBuilder, fields);
    genJavaSourceFile(generatePackage(typeElement),
        typeElement.getAnnotation(GenQueryRequest.class).sourcePath(), typeSpecBuilder);
  }

  @Override
  public Class<? extends Annotation> getAnnotation() {
    return GenQueryRequest.class;
  }

  @Override
  public String generatePackage(TypeElement typeElement) {
    return typeElement.getAnnotation(GenQueryRequest.class).pkgName();
  }
}
