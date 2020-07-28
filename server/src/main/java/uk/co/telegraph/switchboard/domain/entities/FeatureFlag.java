package uk.co.telegraph.switchboard.domain.entities;

import lombok.Data;

@Data
public class FeatureFlag {
  private String key;

  public boolean isEnabledForClient(ClientInfo client) {
    throw new UnsupportedOperationException();
  }
}
