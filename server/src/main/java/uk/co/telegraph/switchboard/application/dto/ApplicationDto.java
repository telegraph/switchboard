package uk.co.telegraph.switchboard.application.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ApplicationDto {
  @EqualsAndHashCode.Include
  private String id;
  private String name;
  private String description;
  private String secret;
}
