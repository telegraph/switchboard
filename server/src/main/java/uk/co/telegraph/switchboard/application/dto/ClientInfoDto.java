package uk.co.telegraph.switchboard.application.dto;

import java.time.ZonedDateTime;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientInfoDto {
  private String applicationId;
  private String secret;
  private ZonedDateTime time;
  private Map<String, String> properties;
}
