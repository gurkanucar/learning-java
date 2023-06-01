package org.gucardev.fluentAndStepPattern;

import java.util.ArrayList;
import java.util.List;
import org.gucardev.fluentAndStepPattern.steps.AccountStep;
import org.gucardev.fluentAndStepPattern.steps.BuildStep;
import org.gucardev.fluentAndStepPattern.steps.DeliveryOptionStep;
import org.gucardev.fluentAndStepPattern.steps.PaymentStep;
import org.gucardev.fluentAndStepPattern.steps.ProductStep;
import org.gucardev.fluentAndStepPattern.steps.ShippingStep;

public class OrderBuilder
    implements AccountStep, ShippingStep, PaymentStep, ProductStep, DeliveryOptionStep, BuildStep {
  private String accountEmail;
  private String shippingAddress;
  private String paymentMethod;
  private List<Product> products = new ArrayList<>();
  private String deliveryOption;

  public static AccountStep builder() {
    return new OrderBuilder();
  }

  @Override
  public ShippingStep setAccount(String accountEmail) {
    this.accountEmail = accountEmail;
    return this;
  }

  @Override
  public PaymentStep setShippingAddress(String shippingAddress) {
    this.shippingAddress = shippingAddress;
    return this;
  }

  @Override
  public ProductStep setPaymentMethod(String paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  @Override
  public ProductStep addProduct(String name, double price, int quantity) {
    this.products.add(new Product(name, price, quantity));
    return this;
  }

  @Override
  public DeliveryOptionStep finishProducts() {
    return this;
  }

  @Override
  public BuildStep setDeliveryOption(String deliveryOption) {
    this.deliveryOption = deliveryOption;
    return this;
  }

  @Override
  public Order build() {
    return new Order(accountEmail, shippingAddress, paymentMethod, products, deliveryOption);
  }
}
