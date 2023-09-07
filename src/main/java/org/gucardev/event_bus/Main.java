package org.gucardev.event_bus;

import com.google.common.eventbus.EventBus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

  public static void main(String[] args) {
    EventBus eventBus = new EventBus();
    new InternalEventListener(eventBus);
    new ExternalEventListener(eventBus);
    eventBus.post(new CustomEvent(EventTo.EXTERNAL, "closeProductReq", "close product request"));
  }

  public static void sayHello() {
    log.info("selam");
  }
}
