package org.gucardev.completablefuture;

import java.net.URL;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Main {

  public static void main(String[] args) {

    CompletableFuture.supplyAsync(() -> getRequest("https://jsonplaceholder.typicode.com/posts/1"))
        .thenAccept(res -> System.out.printf("Result: %s%n", res)).join();

    System.out.println("end of the code");


  }

  public static String getRequest(String targetUrl) {
    try {
      sleep(2500);
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
