package uk.co.telegraph.switchboard.domain.factories;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.co.telegraph.switchboard.domain.entities.Application;

class ApplicationFactoryTest {

  private static final String APPLICATION_NAME = "Website";

  private ApplicationFactory applicationFactory;

  @BeforeEach
  void setUp() {
    applicationFactory = new ApplicationFactory();
  }

  @Test
  void should_create_an_application_from_a_name() {
    Application application = applicationFactory.create(APPLICATION_NAME);

    assertThat(application.getName())
        .isEqualTo(APPLICATION_NAME);
    assertThat(application.getId())
        .isNotEmpty();
    assertThat(application.getSecret())
        .isNotEmpty();
  }

}
