package uk.co.telegraph.switchboard.application.dto;

import uk.co.telegraph.switchboard.domain.entities.Application;

public class ApplicationDtoGenerator {
  public static final String APPLICATION_DTO_ID = "d58f5d98-4e54-4a1e-9327-fb4331017608";
  public static final String APPLICATION_DTO_NAME = "Mobile Application";
  public static final String APPLICATION_DTO_DESCRIPTION = "A simple mobile application";
  public static final String APPLICATION_DTO_SECRET = "Some complex secret";

  public static ApplicationDto generateApplicationDto() {
    ApplicationDto application = new ApplicationDto();
    application.setId(APPLICATION_DTO_ID);
    application.setName(APPLICATION_DTO_NAME);
    application.setDescription(APPLICATION_DTO_DESCRIPTION);
    application.setSecret(APPLICATION_DTO_SECRET);
    return application;
  }

  private ApplicationDtoGenerator() {
  }
}
