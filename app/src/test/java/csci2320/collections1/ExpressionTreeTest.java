package csci2320.collections1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExpressionTreeTest {
  @Test void simpleExpr() {
    ExpressionTree et = new ExpressionTree("2*3+5");
    assertEquals(11.0, et.eval());
  }
  @Test void parensExpr() {
    ExpressionTree et = new ExpressionTree("2*(3+5)");
    assertEquals(16.0, et.eval());
  }
}
