package csci2320.collections1;

public interface Stack<E> {
  void push(E elem);
  E pop();
  E peek();
  boolean isEmpty();
}
