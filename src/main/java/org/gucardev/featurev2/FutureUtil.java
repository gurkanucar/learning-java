package org.gucardev.featurev2;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FutureUtil {

  public static CompletableFuture<Map<String, Object>> allOf(
      Map<String, FutureOption<Supplier<Object>, Function<Throwable, Object>>> tasks) {
    Map<String, CompletableFuture<?>> futures = tasks.entrySet()
        .stream().collect(Collectors.toMap(x -> x.getKey(),
            entry -> CompletableFuture.supplyAsync(entry.getValue().getMethod())
                .exceptionally(entry.getValue().getException())));

    CompletableFuture<Void> allFeatures = CompletableFuture.allOf(futures.values()
        .toArray(new CompletableFuture[0]));

    return allFeatures.thenApply(v -> futures.entrySet().stream()
        .collect(Collectors.toMap(x -> x.getKey(), entry -> entry.getValue().join())));

  }

}
