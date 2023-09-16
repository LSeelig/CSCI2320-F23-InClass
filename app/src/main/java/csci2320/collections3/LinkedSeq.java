package csci2320.collections3;

import java.util.Iterator;

public class LinkedSeq<E> implements Seq<E> {
  private static class Node<E> {
    E data;
    Node<E> next;
    Node(E data, Node<E> next) {
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
      throw new IndexOutOfBoundsException("Get out of bounds at " + index + " of " + numElems);
    Node<E> rover = head;
    for (int i = 0; i < index; ++i) rover = rover.next;
    return rover.data;
  }

  @Override
  public void set(int index, E elem) {
    if (index < 0 || index >= numElems)
      throw new IndexOutOfBoundsException("Get out of bounds at " + index + " of " + numElems);
    Node<E> rover = head;
    for (int i = 0; i < index; ++i) rover = rover.next;
    rover.data = elem;
  }

  @Override
  public E remove(int index) {
    if (index < 0 || index >= numElems)
      throw new IndexOutOfBoundsException("Get out of bounds at " + index + " of " + numElems);
    numElems--;
    if (index == 0) {
      var tmp = head.data;
      head = head.next;
      if (head == null) tail = null;
      return tmp;
    } else {
      Node<E> rover = head;
      for (int i = 0; i < index-1; ++i) rover = rover.next;
      var tmp = rover.next.data;
      rover.next = rover.next.next;
      if (rover.next == null) tail = rover;
      return tmp;
    }
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
    if (index < 0 || index >= numElems)
      throw new IndexOutOfBoundsException("Insert out of bounds at " + index + " of " + numElems);
    if (index == 0) {
      head = new Node<E>(elem, head);
      if (tail == null) tail = head;
    } else {
      Node<E> rover = head;
      for (int i = 0; i < index-1; ++i) rover = rover.next;
      rover.next = new Node<E>(elem, rover.next);
      if (rover == tail) tail = rover.next;
    }
    numElems++;
  }

  @Override
  public int size() {
    return numElems;
  }
  
  public Iterator<E> iterator() {
    return new Iterator<E>() {
      private Node<E> rover = head;
      public E next() {
        var tmp = rover.data;
        rover = rover.next;
        return tmp;
      }
      public boolean hasNext() {
        return rover != null;
      }
    };
  }

}
