package uk.co.telegraph.switchboard.domain.entities;

import java.time.ZonedDateTime;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClientInfo {
  private Application application;
  private ZonedDateTime time;
  private Map<String, String> properties;

  public Map<String, Boolean> getFeatureFlags() {
    return application.getEnabledFeaturesForClient(this);
  }
}
