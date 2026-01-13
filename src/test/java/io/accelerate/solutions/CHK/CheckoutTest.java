package io.accelerate.solutions.CHK;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CheckoutTest {
  private CheckoutSolution solution = new CheckoutSolution();

  @BeforeEach
  public void setupSolution() {
    solution = new CheckoutSolution();
  }

  @ParameterizedTest
  @CsvSource({"A,50", "B,30", "C,20", "AA,100", "BB,60", "CC,40", "AB,80", "ABC,100", "AAA,130", "BB,45", "AAAB,160", "AAABB,175", "AAABBC,195"})
  public void testCheckout(String input, Integer expected) {

  }

}

