package csci2320.collections3;

import java.util.ArrayList;
import java.util.List;

public class GeneralTree<E> {
  private static class Node<E> {
    E data;
    List<Node<E>> children = new ArrayList();
    public Node(E elem) {
      data = elem;
    }
  }


}
