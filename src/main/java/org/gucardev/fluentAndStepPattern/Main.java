package org.gucardev.fluentAndStepPattern;

public class Main {

  public static void main(String[] args) {
    Order order =
        OrderBuilder.builder()
            .setAccount("email@example.com")
            .setShippingAddress("123 Street, City, State, Country")
            .setPaymentMethod("Credit Card")
            .addProduct("Book", 15.99, 1)
            .addProduct("Laptop", 1200.00, 1)
            .finishProducts()
            .setDeliveryOption("Express")
            .build();

    System.out.println(order);
  }
}
