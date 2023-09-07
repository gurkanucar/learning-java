package org.gucardev.event_bus;

import lombok.Data;

@Data
public class CustomEvent {
  private EventTo eventTo;
  private String route;
  private String message;

  public CustomEvent(EventTo eventTo, String route, String message) {
    this.eventTo = eventTo;
    this.route = route;
    this.message = message;
  }
}
