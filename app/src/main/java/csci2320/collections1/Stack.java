package csci2320.collections1;

public interface Stack<E> {
  void push(E elem);
  E pop();
  E peek();
  boolean isEmpty();

  static class StackUnderflowException extends RuntimeException {
    public StackUnderflowException(String message) {
      super(message);
    }
  }
}
