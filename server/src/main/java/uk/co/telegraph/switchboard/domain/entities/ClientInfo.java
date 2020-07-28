package uk.co.telegraph.switchboard.domain.entities;

import java.time.ZonedDateTime;
import java.util.Map;
import lombok.Data;

@Data
public class ClientInfo {
  private Application application;
  private ZonedDateTime time;
  private Map<String, String> properties;
}
