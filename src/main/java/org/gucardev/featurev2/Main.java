package org.gucardev.featurev2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

  public static String sayHello(String name) {
    return "hello " + name;
  }

  public static void main(String[] args) {
    Map<String, FutureOption<Supplier<Object>, Function<Throwable, Object>>> features = new HashMap<>();

    features.put("h1", new FutureOption<>(() -> sayHello("Gurkan"), e -> null));
    features.put("h2", new FutureOption<>(() -> sayHello("Ahmet"), e -> null));
    features.put("h3", new FutureOption<>(() -> sayHello("Mehmet"), e -> null));

    var result = FutureUtil.allOf(features).join();

    System.out.println(result.toString());
    System.out.println(result.get("h1"));
    System.out.println(result.get("h2"));
    System.out.println(result.get("h3"));
  }

}
