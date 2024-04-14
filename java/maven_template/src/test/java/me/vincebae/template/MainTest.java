package me.vincebae.template;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

  private Main subject;

  @BeforeEach
  void setUp() {
    subject = new Main();
  }

  @Test
  void greeting_returnsGreeting() {
    String actual = subject.greeting();

    assertThat(actual, is("Hello World!"));
  }
}
