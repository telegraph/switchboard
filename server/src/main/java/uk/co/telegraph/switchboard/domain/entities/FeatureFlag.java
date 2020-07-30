package uk.co.telegraph.switchboard.domain.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FeatureFlag {
  private String key;

  public boolean isEnabledForClient(ClientInfo client) {
    throw new UnsupportedOperationException();
  }
}
