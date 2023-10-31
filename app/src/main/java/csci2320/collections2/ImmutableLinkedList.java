package csci2320.collections2;

import java.util.function.Function;

public interface ImmutableLinkedList<E> {
  E head();
  ImmutableLinkedList<E> tail();
  ImmutableLinkedList<E> cons(E elem);
  E get(int index);
  int size();
  boolean isEmpty();
  <E2> ImmutableLinkedList<E2> map(Function<E, E2> f);

  public static record Nil<E>() implements ImmutableLinkedList<E> {
    @Override
    public E head() {
      throw new UnsupportedOperationException("Can't call head on Nil.");
    }
    @Override
    public ImmutableLinkedList<E> tail() {
      throw new UnsupportedOperationException("Can't call tail on Nil.");
    }
    @Override
    public ImmutableLinkedList<E> cons(E elem) {
      return new Cons<E>(elem, this);
    }
    @Override
    public E get(int index) {
      throw new UnsupportedOperationException("Can't call get on Nil.");
    }
    @Override
    public int size() {
      return 0;
    }
    @Override
    public boolean isEmpty() {
      return true;
    }
    @Override
    public <E2> ImmutableLinkedList<E2> map(Function<E, E2> f) {
      return new Nil<E2>();
    }
  }

  public static record Cons<E>(E elem, ImmutableLinkedList<E> next) implements ImmutableLinkedList<E> {
    @Override
    public E head() {
      return elem;
    }

    @Override
    public ImmutableLinkedList<E> tail() {
      return next;
    }

    @Override
    public ImmutableLinkedList<E> cons(E elem) {
      return new Cons<E>(elem, this);
    }

    @Override
    public E get(int index) {
      if (index == 0) {
        return elem;
      } else {
        return next.get(index - 1);
      }
    }

    @Override
    public int size() {
      return 1 + next.size();
    }

    @Override
    public boolean isEmpty() {
      return false;
    }

    @Override
    public <E2> ImmutableLinkedList<E2> map(Function<E, E2> f) {
      return new Cons<E2>(f.apply(elem), next.map(f));
    }
    
  }
}
