package uk.co.telegraph.switchboard.domain.entities;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FeatureFlagTest {

  private static final String FEATURE_FLAG_KEY = "feature.item.like";

  private FeatureFlag featureFlag;

  @BeforeEach
  void setUp() {
    featureFlag = new FeatureFlag();
  }

  @Test
  void should_set_and_return_key() {
    featureFlag.setKey(FEATURE_FLAG_KEY);

    assertThat(featureFlag.getKey())
        .isEqualTo(FEATURE_FLAG_KEY);
  }

  @Test
  void should_return_string_representation() {
    featureFlag.setKey(FEATURE_FLAG_KEY);

    assertThat(featureFlag.toString())
        .startsWith("FeatureFlag")
        .contains(FEATURE_FLAG_KEY);
  }
}
