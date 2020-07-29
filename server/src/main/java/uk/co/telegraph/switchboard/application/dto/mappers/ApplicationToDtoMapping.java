package uk.co.telegraph.switchboard.application.dto.mappers;

import org.mapstruct.Mapper;
import uk.co.telegraph.switchboard.application.dto.ApplicationDto;
import uk.co.telegraph.switchboard.domain.entities.Application;

@Mapper(componentModel = "spring")
public interface ApplicationToDtoMapping {

  ApplicationDto dtoFromDomain(Application domain);

  Application domainFromDto(ApplicationDto dto);
}
