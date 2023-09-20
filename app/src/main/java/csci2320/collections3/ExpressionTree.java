package csci2320.collections3;

import java.util.function.BiFunction;

public class ExpressionTree {
  private final Node root;
  public ExpressionTree(String expr) {
    root = parse(expr);
  }

  public ExpressionTree(String... exprs) {
    root = parse(exprs[0]);
  }

  public double eval() {
    return root.eval();
  }

  private static interface Node {
    double eval();
  }

  private static record NumberNode(double value) implements Node {
    public double eval() {
      return value;
    }
  }

  private static record BinaryOpNode(BiFunction<Double, Double, Double> op, Node left, Node right) implements Node {
    public double eval() {
      return op.apply(left.eval(), right.eval());
    }
  }

  private Node parse(String exprLong) {
    String expr = exprLong.trim();
    int parensCount = 0;
    int opLoc = -1;
    int i = expr.length()-1;
    while(i >= 0) {
      char c = expr.charAt(i);
      if (c == ')') parensCount++;
      else if (c == '(') parensCount--;
      else if (parensCount == 0 && (c == '+' || c == '-')) {
        opLoc = i;
        i = -1;
      } else if (parensCount == 0 && opLoc == -1 && (c == '*' || c == '/')) {
        opLoc = i;
      }
      i--;
    }
    if (opLoc == -1) {
      if (expr.startsWith("(")) return parse(expr.substring(1, expr.length()-1));
      else return new NumberNode(Double.parseDouble(expr));
    } else {
      var left = parse(expr.substring(0, opLoc));
      var right = parse(expr.substring(opLoc + 1));
      switch (expr.charAt(opLoc)) {
        case '+': return new BinaryOpNode((l, r) -> l + r, left, right);
        case '-': return new BinaryOpNode((l, r) -> l - r, left, right);
        case '*': return new BinaryOpNode((l, r) -> l * r, left, right);
        case '/': return new BinaryOpNode((l, r) -> l / r, left, right);
      }
      return null;
    }
  }
}
