package csci2320.collections3;

public interface Stack<E> {
  void push(E elem);
  E pop();
  E peek();
  boolean isEmpty();
}
