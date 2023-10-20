package csci2320.collections1;

public record Interval<E extends Comparable<E>>(E min, E max) {
  public boolean overlaps(Interval<E> that) {
    // TODO
    return false;
  }

  private void foo() {
    var b = 64; //pureFunc(8);
    // ...
    // var adults = people.filter(p -> p.age >= 18);
    // ....forEach(i -> arr[i] = arr[i]+5)
  }

  private void addFive(int a) {
    a = a+5;
  }

  private int pureFunc(int a) {
    int value = a*a; // Something involving a
    return value;
  }
}
