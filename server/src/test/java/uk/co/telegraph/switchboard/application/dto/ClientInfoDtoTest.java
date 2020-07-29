package uk.co.telegraph.switchboard.application.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClientInfoDtoTest {

  public static final String APPLICATION_ID = "b480cda2-ad30-4003-9f19-7ef5ab0c2a0c";
  public static final String APPLICATION_SECRET = "SDAF90MD09nasf09safdhftg";

  private ClientInfoDto clientInfo;

  @BeforeEach
  void setUp() {
    clientInfo = new ClientInfoDto();
  }

  @Test
  void should_set_and_return_applicationId() {
    clientInfo.setApplicationId(APPLICATION_ID);

    assertThat(clientInfo.getApplicationId())
        .isEqualTo(APPLICATION_ID);
  }

  @Test
  void should_set_and_return_secret() {
    clientInfo.setSecret(APPLICATION_SECRET);

    assertThat(clientInfo.getSecret())
        .isEqualTo(APPLICATION_SECRET);
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
  void should_return_string_representation() {
    assertThat(clientInfo.toString())
        .startsWith("ClientInfoDto");
  }
}
