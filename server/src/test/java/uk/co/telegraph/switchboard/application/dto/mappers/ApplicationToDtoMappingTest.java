package uk.co.telegraph.switchboard.application.dto.mappers;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.telegraph.switchboard.application.dto.ApplicationDtoGenerator.APPLICATION_DTO_DESCRIPTION;
import static uk.co.telegraph.switchboard.application.dto.ApplicationDtoGenerator.APPLICATION_DTO_ID;
import static uk.co.telegraph.switchboard.application.dto.ApplicationDtoGenerator.APPLICATION_DTO_NAME;
import static uk.co.telegraph.switchboard.application.dto.ApplicationDtoGenerator.APPLICATION_DTO_SECRET;
import static uk.co.telegraph.switchboard.application.dto.ApplicationDtoGenerator.generateApplicationDto;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_DESCRIPTION;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_ID;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_NAME;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_SECRET;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.generateApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;
import uk.co.telegraph.switchboard.application.dto.ApplicationDto;
import uk.co.telegraph.switchboard.domain.entities.Application;

class ApplicationToDtoMappingTest {

  private ApplicationToDtoMapping mapping;

  @BeforeEach
  void setUp() {
    mapping = Mappers.getMapper(ApplicationToDtoMapping.class);
  }

  @Test
  void should_map_a_domain_object_to_a_dto() {
    Application application = generateApplication();

    ApplicationDto applicationDto = mapping.dtoFromDomain(application);

    assertThat(applicationDto)
        .hasFieldOrPropertyWithValue("id", APPLICATION_ID)
        .hasFieldOrPropertyWithValue("name", APPLICATION_NAME)
        .hasFieldOrPropertyWithValue("description", APPLICATION_DESCRIPTION)
        .hasFieldOrPropertyWithValue("secret", APPLICATION_SECRET);
  }

  @Test
  void should_map_a_null_domain_object_to_a_null_dto() {
    assertThat(mapping.dtoFromDomain(null))
        .isNull();
  }

  @Test
  void should_map_a_dto_to_a_domain() {
    ApplicationDto applicationDto = generateApplicationDto();

    Application application = mapping.domainFromDto(applicationDto);

    assertThat(application)
        .hasFieldOrPropertyWithValue("id", APPLICATION_DTO_ID)
        .hasFieldOrPropertyWithValue("name", APPLICATION_DTO_NAME)
        .hasFieldOrPropertyWithValue("description", APPLICATION_DTO_DESCRIPTION)
        .hasFieldOrPropertyWithValue("secret", APPLICATION_DTO_SECRET);
  }

  @Test
  void should_map_a_null_dto_object_to_a_null_domain() {
    assertThat(mapping.domainFromDto(null))
        .isNull();
  }
}
