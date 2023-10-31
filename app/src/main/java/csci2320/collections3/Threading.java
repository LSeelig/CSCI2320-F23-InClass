package csci2320.collections3;

public class Threading {
  public static void main(String[] args) {
    new Thread(() -> {
      for (int i = 0; i < 100; ++i) {
        try {
          Thread.sleep(100);
        } catch(InterruptedException ex) {}
        System.out.println(i + " in thread");
      }
    }).start();

    for (int i = 0; i < 100; ++i) {
      try {
        Thread.sleep(100);
      } catch(InterruptedException ex) {}
      System.out.println(i + " in main");
    }
  }
}
