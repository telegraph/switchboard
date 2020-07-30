package uk.co.telegraph.switchboard.domain.factories;

import static org.apache.commons.lang3.RandomStringUtils.random;

import java.util.UUID;
import org.springframework.stereotype.Service;
import uk.co.telegraph.switchboard.domain.entities.Application;

@Service
public class ApplicationFactory {

  public Application create(String name) {
    Application application = new Application();

    UUID uuid = UUID.randomUUID();
    application.setId(uuid.toString());

    application.setName(name);

    application.setSecret(random(12));

    return application;
  }

}
