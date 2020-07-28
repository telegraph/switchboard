package uk.co.telegraph.switchboard.application.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ApplicationDto {
  private String id;
  private String name;
  private String description;
}
