package io.accelerate.solutions.HLO;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HelloTest {

  private HelloSolution solution;

  @BeforeEach
  public void setup() {
    solution = new HelloSolution();
  }

  @Test
  public void helloWorld() {
    assertEquals("Hello, World!", solution.hello("World"));
  }

  @Test
  public void helloEden() {
    assertEquals("Hello, Eden!", solution.hello("Eden"));
  }

}
