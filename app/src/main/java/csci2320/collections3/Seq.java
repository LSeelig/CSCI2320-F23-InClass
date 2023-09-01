package csci2320.collections3;

public interface Seq<E> {
  E get(int index);
  void set(int index, E elem);
  E remove(int index);
  void add(E elem);
  void insert(int index, E elem);
  int size();
}
