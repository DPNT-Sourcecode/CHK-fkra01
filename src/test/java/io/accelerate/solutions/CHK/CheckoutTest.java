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
  @CsvSource({ "A,50", "B,30", "C,20", "D,15", "AA,100", "BB,45", "CC,40", "AB,80", "ABC,100", "AAA,130", "AAAB,160",
      "AAABB,175", "AAABBC,195", "AAAAA,200", "AAAAAA,250", "EEB,80", "EE,80", "EEEEBB,160", "BEBEEE,160",
      "ABCDEABCDE,280", "EEEB,120", "ABCDECBAABCABBAAAEEAA,665", "F,10", "FF,20", "FFF,20", "FFFF,30", "FFFFF,40",
      "FFFFFF,40", "H,10", "HHHHH,45", "HHHHHHHHHH,80", "K,70", "KK,120", "KKK,190", "KKKK,240", "NNN,120", "NNNM,120",
      "NNNMM,135", "NNNNMM,175", "NNNNNNMM,240", "PPPPP,200", "PPPPPPPPPP,400", "PPPPPPPPP,400", "QQ,60", "QQQ,80",
      "RRRQ,150", "RRRQQ,180", "RRRQQQ,210", "UUU,120", "UUUU,120", "UUUUUUUU,240", "STX,45", "STY,45", "STZ,45",
      "TXY,45", "TXZ,45", "XYZ,45", "SXY,45", "SXZ,45", "TXZ,45", "SYZ,45", "TYZ,45", "STXY,62", "STXYZ,82",
      "SSTXYZ,90", "SSSZ,65", "ZZZS,65", "STXZ,62"
  })
  public void testCheckout(String input, Integer expected) {
    var output = solution.checkout(input);
    assertEquals(expected, output);
  }

  @ParameterizedTest
  @ValueSource(strings = { "", "1" })
  public void testCheckoutInvalid(String input) {
    assertEquals(-1, solution.checkout(input));

  }

}

