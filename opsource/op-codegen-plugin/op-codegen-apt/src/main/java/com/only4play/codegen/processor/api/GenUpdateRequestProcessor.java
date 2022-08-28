package com.only4play.codegen.processor.api;

import com.google.auto.service.AutoService;
import com.only4play.codegen.processor.BaseCodeGenProcessor;
import com.only4play.codegen.processor.DefaultNameContext;
import com.only4play.codegen.processor.updater.IgnoreUpdater;
import com.only4play.codegen.spi.CodeGenProcessor;
import com.only4play.common.model.Request;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.FieldSpec;
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
public class GenUpdateRequestProcessor extends BaseCodeGenProcessor {

  public static String UPDATE_REQUEST_SUFFIX = "UpdateRequest";
  @Override
  protected void generateClass(TypeElement typeElement, RoundEnvironment roundEnvironment) {
    DefaultNameContext nameContext = getNameContext(typeElement);
    Set<VariableElement> fields = findFields(typeElement,
        p -> Objects.isNull(p.getAnnotation(IgnoreUpdater.class)));
    TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder(nameContext.getUpdateClassName())
        .addModifiers(Modifier.PUBLIC)
        .addSuperinterface(Request.class)
        .addAnnotation(Schema.class);

    addSetterAndGetterMethodWithConverter(typeSpecBuilder, fields);
    typeSpecBuilder.addField(
        FieldSpec.builder(ClassName.get(Long.class), "id", Modifier.PRIVATE).build());
    addIdSetterAndGetter(typeSpecBuilder);
    genJavaSourceFile(generatePackage(typeElement),
        typeElement.getAnnotation(GenUpdateRequest.class).sourcePath(), typeSpecBuilder);
  }

  @Override
  public Class<? extends Annotation> getAnnotation() {
    return GenUpdateRequest.class;
  }

  @Override
  public String generatePackage(TypeElement typeElement) {
    return typeElement.getAnnotation(GenUpdateRequest.class).pkgName();
  }
}
