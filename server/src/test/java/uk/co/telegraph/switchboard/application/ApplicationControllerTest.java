package uk.co.telegraph.switchboard.application;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.when;
import static uk.co.telegraph.switchboard.application.dto.ApplicationDtoGenerator.generateApplicationDto;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_ID;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.generateApplication;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import uk.co.telegraph.switchboard.application.dto.ApplicationDto;
import uk.co.telegraph.switchboard.application.dto.mappers.ApplicationToDtoMapping;
import uk.co.telegraph.switchboard.domain.entities.Application;
import uk.co.telegraph.switchboard.domain.repositories.ApplicationRepository;

@ExtendWith(MockitoExtension.class)
class ApplicationControllerTest {

  @Mock
  private ApplicationRepository applicationRepository;

  @Mock
  private ApplicationToDtoMapping mapper;

  private ApplicationController applicationController;

  @BeforeEach
  void setUp() {
    applicationController = new ApplicationController(applicationRepository, mapper);
    RestAssuredMockMvc.standaloneSetup(applicationController);
  }

  @Test
  void should_find_an_application_by_id() {
    Application application = generateApplication();
    when(applicationRepository.findById(APPLICATION_ID))
        .thenReturn(Optional.of(application));
    ApplicationDto applicationDto = generateApplicationDto();
    when(mapper.dtoFromDomain(application))
        .thenReturn(applicationDto);

    given()
      .when()
        .get("/v1/applications/{id}", APPLICATION_ID)
      .then()
        .status(HttpStatus.OK)
        .body("id", equalTo(APPLICATION_ID));
  }

  @Test
  void should_return_not_found_if_one_application_does_not_exists() {
    when(applicationRepository.findById(APPLICATION_ID))
        .thenReturn(Optional.empty());

    given()
      .when()
        .get("/v1/applications/{id}", APPLICATION_ID)
      .then()
        .status(HttpStatus.NOT_FOUND);
  }
}
