package csci2320.collections2;

import java.util.Iterator;

public class LinkedSeq<E> implements Seq<E>, Iterable<E> {
  private static class Node<E> {
    E data;
    Node<E> next;
    public Node(E data, Node<E> next) {
      this.data = data;
      this.next = next;
    }
  }
  private Node<E> head = null;
  private Node<E> tail = null;
  private int numElems = 0;

  @Override
  public E get(int index) {
    if (index < 0 || index >= numElems)
      throw new IndexOutOfBoundsException("Get out of bounds at "+index+" of "+numElems);
    Node<E> rover = head;
    for (int i = 0; i < index; ++i) rover = rover.next;
    return rover.data;
  }

  @Override
  public void set(int index, E elem) {
    if (index < 0 || index >= numElems)
      throw new IndexOutOfBoundsException("Get out of bounds at "+index+" of "+numElems);
    Node<E> rover = head;
    for (int i = 0; i < index; ++i) rover = rover.next;
    rover.data = elem;
  }

  @Override
  public void add(E elem) {
    if (head == null) {
      head = tail = new Node<E>(elem, null);
    } else {
      tail.next = new Node<E>(elem, null);
      tail = tail.next;
    }
    numElems++;
  }

  @Override
  public void insert(int index, E elem) {
    if (head == null) {
      head = tail = new Node<E>(elem, null);
    } else if (index == 0) {
      head = new Node<E>(elem, head);
    } else {
      Node<E> rover = head;
      for (int i = 0; i < index-1; ++i) rover = rover.next;
      rover.next = new Node<E>(elem, rover.next);
      if (rover == tail) tail = tail.next;
    }
    numElems++;
  }

  @Override
  public E remove(int index) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'remove'");
  }

  @Override
  public int size() {
    return numElems;
  }

  @Override
  public boolean isEmpty() {
    return head == null;
  }

  @Override
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private Node<E> rover = head;
      public E next() {
        E tmp = rover.data;
        rover = rover.next;
        return tmp;
      }
      public boolean hasNext() {
        return rover != null;
      }
    };
  }
  
}
