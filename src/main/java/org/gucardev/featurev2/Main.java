package org.gucardev.featurev2;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {

  public static String sayHello(String name) {
    return "hello " + name;
  }

  public static void main(String[] args) {

    long time = System.currentTimeMillis();

    //   getRequest("https://jsonplaceholder.typicode.com/posts/1", 5000);
    //  getRequest("https://jsonplaceholder.typicode.com/posts", 5000);

    Map<String, FutureOption<Supplier<Object>, Function<Throwable, Object>>> features = new HashMap<>();

    features.put("h1", new FutureOption<>(() -> sayHello("Gurkan"), e -> null));
    features.put("h2", new FutureOption<>(() -> sayHello("Ahmet"), e -> null));
    features.put("h3", new FutureOption<>(() -> sayHello("Mehmet"), e -> null));
    features.put("h4",
        new FutureOption<>(() -> getRequest("https://jsonplaceholder.typicode.com/posts/1", 5000),
            e -> null));
    features.put("h5",
        new FutureOption<>(() -> getRequest("https://jsonplaceholder.typicode.com/posts", 5000),
            e -> null));

    var result = FutureUtil.allOf(features).join();

    System.out.println("time: " + (System.currentTimeMillis() - time));

    System.out.println(result.keySet());
    // System.out.println(result.get("h1"));
    // System.out.println(result.get("h2"));
    // System.out.println(result.get("h3"));

  }


  public static String getRequest(String targetUrl, int delay) {
    try {
      sleep(delay);
      URL url = new URL(targetUrl);
      OkHttpClient client = new OkHttpClient().newBuilder().build();
      Request request = new Request.Builder().url(url).get().build();
      Response response = client.newCall(request).execute();
      return Objects.requireNonNull(response.body()).string();
    } catch (Exception e) {
      throw new RuntimeException("Hata! %s".formatted(e.getMessage()));
    }
  }


  static void sleep(int millis) {
    try {
      Thread.sleep(millis);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
