package csci2320.collections2;

public record Interval<E extends Comparable<E>>(E min, E max) {
  public boolean overlap(Interval<E> that) {
    // TODO
    return false;
  }

  void foo() {
    var b = 64; //square(8);
    // var adults = people.filter(p -> p.age >= 18);
  }

  double square(double x) {
    return x*x;
  }
}
