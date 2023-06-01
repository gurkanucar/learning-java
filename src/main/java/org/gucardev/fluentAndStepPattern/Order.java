package org.gucardev.fluentAndStepPattern;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
  private String accountEmail;
  private String shippingAddress;
  private String paymentMethod;
  private List<Product> products;
  private String deliveryOption;

  public Order(
      String accountEmail,
      String shippingAddress,
      String paymentMethod,
      List<Product> products,
      String deliveryOption) {
    this.accountEmail = accountEmail;
    this.shippingAddress = shippingAddress;
    this.paymentMethod = paymentMethod;
    this.products = products;
    this.deliveryOption = deliveryOption;
  }

  @Override
  public String toString() {
    return "Order{"
        + "accountEmail='"
        + accountEmail
        + '\''
        + ", shippingAddress='"
        + shippingAddress
        + '\''
        + ", paymentMethod='"
        + paymentMethod
        + '\''
        + ", products="
        + products
        + ", deliveryOption='"
        + deliveryOption
        + '\''
        + '}';
  }
}
