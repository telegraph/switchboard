package uk.co.telegraph.switchboard.domain.entities;

import static org.assertj.core.api.Assertions.assertThat;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_DESCRIPTION;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_ID;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_NAME;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.APPLICATION_SECRET;
import static uk.co.telegraph.switchboard.domain.entities.ApplicationGenerator.generateApplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationTest {

	private Application application;

	@BeforeEach
	void setUp() {
    application = new Application(APPLICATION_ID);
	}

	@Test
	void should_set_application_id_in_constructor() {
		assertThat(application.getId())
				.isEqualTo(APPLICATION_ID);
	}

	@Test
	void should_set_and_get_name() {
    application.setName(APPLICATION_NAME);

    assertThat(application.getName())
				.isEqualTo(APPLICATION_NAME);
	}

	@Test
	void should_set_and_get_description() {
		application.setDescription(APPLICATION_DESCRIPTION);

		assertThat(application.getDescription())
				.isEqualTo(APPLICATION_DESCRIPTION);
	}

	@Test
	void should_set_and_get_secret() {
		application.setSecret(APPLICATION_SECRET);

		assertThat(application.getSecret())
				.isEqualTo(APPLICATION_SECRET);
	}

	@Test
	void should_convert_to_string() {
		application = generateApplication();

		assertThat(application.toString())
				.startsWith("Application")
				.contains(APPLICATION_ID, APPLICATION_NAME, APPLICATION_DESCRIPTION);
	}

	@Test
	void should_be_equal_to_itself() {
    assertThat(application.equals(application))
				.isTrue();
	}

	@Test
	void should_be_equal_to_null() {
		assertThat(application.equals(null))
				.isFalse();
	}

	@Test
	void should_be_equal_to_a_different_class() {
		assertThat(application.equals(new String("Test")))
				.isFalse();
	}

	@Test
	void should_be_equal_to_another_object_with_same_id() {
		application = generateApplication();
		Application compare = new Application(APPLICATION_ID);

		assertThat(application.equals(compare))
				.isTrue();
	}

	@Test
	void should_not_be_equal_to_another_object_with_different_id() {
		application = generateApplication();
		Application compare = new Application("a77098c4-6cf2-40c6-a62b-66c7d728b2c1");
		compare.setName(APPLICATION_NAME);
		compare.setDescription(APPLICATION_DESCRIPTION);

		assertThat(application.equals(compare))
				.isFalse();
	}

	@Test
	void should_have_the_same_hashCode_than_itself() {
		assertThat(application.hashCode())
				.isEqualTo(application.hashCode());
	}

	@Test
	void should_have_the_same_hashCode_than_an_object_with_same_id() {
    application = generateApplication();
		Application compare = new Application(APPLICATION_ID);

		assertThat(application.hashCode())
				.isEqualTo(compare.hashCode());
	}

	@Test
	void should_not_have_the_same_hashCode_than_an_object_with_different_id() {
		application = generateApplication();

		Application compare = new Application("a77098c4-6cf2-40c6-a62b-66c7d728b2c1");
		compare.setName(APPLICATION_NAME);
		compare.setDescription(APPLICATION_DESCRIPTION);

		assertThat(application.hashCode())
				.isNotEqualTo(compare.hashCode());
	}
}
