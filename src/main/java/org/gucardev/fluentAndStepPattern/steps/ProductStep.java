package org.gucardev.fluentAndStepPattern.steps;

public interface ProductStep {

  ProductStep addProduct(String name, double price, int quantity);

  DeliveryOptionStep finishProducts();
}
