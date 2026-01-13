package io.accelerate.solutions.CHK;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CheckoutTest {
  private CheckoutSolution solution = new CheckoutSolution();

  @BeforeEach
  public void setupSolution() {
    solution = new CheckoutSolution();
  }

  @ParameterizedTest
  @CsvSource({"A,50", "B,30", "C,20", "D,15", "AA,100", "BB,45", "CC,40", "AB,80", "ABC,100", "AAA,130",  "AAAB,160", "AAABB,175", "AAABBC,195"})
  public void testCheckout(String input, Integer expected) {
    var output = solution.checkout(input);
    assertEquals(expected, output);
  }

  @ParameterizedTest
  @ValueSource(strings={"E", "", "1"})
  public void testCheckoutInvalid(String input) {
    assertEquals(-1, solution.checkout(input));

  }

}

