package uk.co.telegraph.switchboard.domain.entities;

import java.util.Map;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Application {
  @Id
  @EqualsAndHashCode.Include
  @Setter(AccessLevel.NONE)
  private String id;
  private String name;
  private String description;

  @Setter(AccessLevel.NONE)
  private ContextAggregator contexts;

  @Setter(AccessLevel.NONE)
  private FeatureFlagAggregator featureFlags;

  @Setter(AccessLevel.NONE)
  private UserGroupAggregator userGroups;

  public Application() {
    contexts = new ContextAggregator();
    featureFlags = new FeatureFlagAggregator();
    userGroups = new UserGroupAggregator();
  }

  public Application(String id) {
    this();
    this.id = id;
  }

  public Map<String, Boolean> getEnabledFeaturesForClient(ClientInfo clientInfo) {
    throw new UnsupportedOperationException();
  }
}
