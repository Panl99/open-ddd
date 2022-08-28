package com.only4play.order.commons.pipeline;


/**
 * @author gim design pattern pipeline
 */
public class Pipeline<I, O> {

  private final Handler<I, O> currentHandler;

  public Pipeline(Handler<I, O> currentHandler) {
    this.currentHandler = currentHandler;
  }

  <K> Pipeline<I, K> addHandler(Handler<O, K> newHandler) {
    return new Pipeline<>(input -> newHandler.process(currentHandler.process(input)));
  }

  O execute(I input) {
    return currentHandler.process(input);
  }

}
