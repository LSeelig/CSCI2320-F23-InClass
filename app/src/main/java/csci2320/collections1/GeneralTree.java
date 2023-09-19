package csci2320.collections1;

import java.util.List;

public class GeneralTree<E> {
  private static class Node<E> {
    E data;
    List<Node<E>> children;
  }
}
