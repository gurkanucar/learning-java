package org.gucardev.fluentAndStepPattern;

public interface ProductStep {

  ProductStep addProduct(String name, double price, int quantity);

  DeliveryOptionStep finishProducts();
}
