package csci2320.collections3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExpressionTreeTest {
  @Test void basicExpr() {
    ExpressionTree et = new ExpressionTree("3+2*5");
    assertEquals(13.0, et.eval());
  }

  @Test void parensExpr() {
    ExpressionTree et = new ExpressionTree("(3+2)*5");
    assertEquals(25.0, et.eval());
  }

  void foo() {
    var et = new ExpressionTree("hi", "there", "Trinity");
  }
}
