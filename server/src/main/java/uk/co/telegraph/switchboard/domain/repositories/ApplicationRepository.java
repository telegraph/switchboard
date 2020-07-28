package uk.co.telegraph.switchboard.domain.repositories;

import java.util.Optional;
import org.springframework.data.repository.Repository;
import uk.co.telegraph.switchboard.domain.entities.Application;

public interface ApplicationRepository extends Repository<Application, String> {
  /**
   * Retrieves an application by its id.
   *
   * @param id must not be {@literal null}.
   * @return the entity with the given id or {@literal Optional#empty()} if none found.
   * @throws IllegalArgumentException if {@literal id} is {@literal null}.
   */
  Optional<Application> findById(String id);
}
