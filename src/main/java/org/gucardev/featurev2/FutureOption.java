package org.gucardev.featurev2;

public class FutureOption<T, U> {

  private final T method;
  private final U action;

  public FutureOption(T method, U action) {
    this.method = method;
    this.action = action;
  }

  public T getMethod() {
    return method;
  }

  public U getAction() {
    return action;
  }
}
