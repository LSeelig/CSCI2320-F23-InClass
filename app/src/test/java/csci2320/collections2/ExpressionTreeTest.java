package csci2320.collections2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExpressionTreeTest {
  @Test void simpleExpr() {
    var et = new ExpressionTree("2+3*5");
    assertEquals(17, et.eval());
  }

  @Test void parensExpr() {
    var et = new ExpressionTree("(2+3)*5");
    assertEquals(25, et.eval());
  }
}
