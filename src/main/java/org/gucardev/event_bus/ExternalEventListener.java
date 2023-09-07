package org.gucardev.event_bus;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExternalEventListener {
  private final EventBus eventBus;

  public ExternalEventListener(EventBus eventBus) {
    this.eventBus = eventBus;
    eventBus.register(this);
  }

  @Subscribe
  public void handleCustomEvent(CustomEvent event) {
    if (event.getEventTo().equals(EventTo.INTERNAL)) return;
    log.info("Received EXTERNAL event for route '{}': {}", event.getRoute(), event.getMessage());
    eventBus.post(new CustomEvent(EventTo.INTERNAL, "closeProductRes", "close product response"));
  }
}
