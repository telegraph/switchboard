package uk.co.telegraph.switchboard.domain.entities;

public class ApplicationGenerator {
  public static final String APPLICATION_ID = "d58f5d98-4e54-4a1e-9327-fb4331017608";
  public static final String APPLICATION_NAME = "Mobile Application";
  public static final String APPLICATION_DESCRIPTION = "A simple mobile application";
  public static final String APPLICATION_SECRET = "Some complex secret";

  public static Application generateApplication() {
    Application application = new Application(APPLICATION_ID);
    application.setName(APPLICATION_NAME);
    application.setDescription(APPLICATION_DESCRIPTION);
    application.setSecret(APPLICATION_SECRET);
    return application;
  }

  private ApplicationGenerator() {
  }
}
