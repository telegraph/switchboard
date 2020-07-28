package uk.co.telegraph.switchboard.application;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import uk.co.telegraph.switchboard.application.dto.ApplicationDto;
import uk.co.telegraph.switchboard.domain.entities.Application;
import uk.co.telegraph.switchboard.domain.repositories.ApplicationRepository;

@RestController
@RequestMapping("/v1/applications")
public class ApplicationController {

  private final ApplicationRepository repository;

  public ApplicationController(ApplicationRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/{id}")
  public ApplicationDto getById(@PathVariable String id) {
    Application application = repository
        .findById(id)
        .orElseThrow(
            () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Application not found: " + id));
    return null;
  }

  @PostMapping
  public ResponseEntity<ApplicationDto> create(@RequestBody ApplicationDto applicationDto) {
    if (applicationDto.getId() != null) {
      throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST,
          "Category id property should not be set: " + applicationDto.getId()
      );
    }

    return null;
  }
}
