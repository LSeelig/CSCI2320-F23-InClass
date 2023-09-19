package csci2320.collections2;

import java.util.List;

public class GeneralTree<E> {
  private class Node<E> {
    E data;
    List<Node<E>> children;
  }

  private Node<E> root;
}
