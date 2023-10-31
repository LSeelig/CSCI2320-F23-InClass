package csci2320.collections3;

import java.util.function.Function;

public interface ImmutableLinkedList<E> {  
  E get(int index);
  ImmutableLinkedList<E> cons(E elem);
  E head();
  ImmutableLinkedList<E> tail();
  int size();
  <E2> ImmutableLinkedList<E2> map(Function<E, E2> f);

  static <E> ImmutableLinkedList<E> Empty() {
    return new Empty<E>();
  }

  public static record Empty<E>() implements ImmutableLinkedList<E> {
    @Override
    public E get(int index) {
      throw new UnsupportedOperationException("Can't get from empty.");
    }
    @Override
    public ImmutableLinkedList<E> cons(E elem) {
      return new Cons<E>(elem, this);
    }
    @Override
    public E head() {
      throw new UnsupportedOperationException("Can't head from empty.");
    }
    @Override
    public ImmutableLinkedList<E> tail() {
      throw new UnsupportedOperationException("Can't tail from empty.");
    }
    @Override
    public int size() {
      return 0;
    }
    @Override
    public <E2> ImmutableLinkedList<E2> map(Function<E, E2> f) {
      return new Empty<E2>();
    }
  }

  public static record Cons<E>(E elem, ImmutableLinkedList<E> next) implements ImmutableLinkedList<E> {
    @Override
    public E get(int index) {
      if (index == 0) {
        return elem;
      } else {
        return next.get(index-1);
      }
    }
    @Override
    public ImmutableLinkedList<E> cons(E elem) {
      return new Cons<E>(elem, this);
    }
    @Override
    public E head() {
      return elem;
    }
    @Override
    public ImmutableLinkedList<E> tail() {
      return next;
    }
    @Override
    public int size() {
      return 1 + next.size();
    }
    @Override
    public <E2> ImmutableLinkedList<E2> map(Function<E, E2> f) {
      return next.map(f).cons(f.apply(elem));
    }
  }
}
