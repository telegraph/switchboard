package uk.co.telegraph.switchboard.domain.repositories;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@AutoConfigureDataMongo
@ExtendWith(SpringExtension.class)
class ApplicationRepositoryIntegrationTest {

  @Autowired
  private ApplicationRepository repository;

  @Test
  void should_create_and_find_by_id() {

  }
}
