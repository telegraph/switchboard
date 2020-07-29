package uk.co.telegraph.switchboard.domain.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ClientInfoTest {

  @Mock
  private Application application;

  private ClientInfo clientInfo;

  @BeforeEach
  void setUp() {
    clientInfo = new ClientInfo();
  }

  @Test
  void should_set_and_return_application() {
    clientInfo.setApplication(application);

    assertThat(clientInfo.getApplication())
        .isEqualTo(application);
  }

  @Test
  void should_set_and_return_time() {
    ZonedDateTime now = ZonedDateTime.now();

    clientInfo.setTime(now);

    assertThat(clientInfo.getTime())
        .isEqualTo(now);
  }

  @Test
  void should_set_and_return_properties() {
    Map<String, String> properties = new HashMap<>();

    clientInfo.setProperties(properties);

    assertThat(clientInfo.getProperties())
        .isEqualTo(properties);
  }

  @Test
  void should_return_feature_flag_configuration() {
    Map<String, Boolean> flags = new HashMap<>();
    when(application.getEnabledFeaturesForClient(any()))
        .thenReturn(flags);

    clientInfo.setApplication(application);

    assertThat(clientInfo.getFeatureFlags())
        .isEqualTo(flags);
  }

  @Test
  void should_return_a_string_representation() {
    assertThat(clientInfo.toString())
        .startsWith("ClientInfo");
  }

}
