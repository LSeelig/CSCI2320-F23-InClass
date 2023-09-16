package csci2320.collections3;

public class LinkedStack<E> implements Stack<E> {
  private static class Node<E> {
    E data;
    Node<E> next;
    Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }
  private Node<E> top = null;

  @Override
  public void push(E elem) {
    top = new Node<E>(elem, top);
  }

  @Override
  public E pop() {
    var tmp = top.data;
    top = top.next;
    return tmp;
  }

  @Override
  public E peek() {
    return top.data;
  }

  @Override
  public boolean isEmpty() {
    return top == null;
  }
  
}
