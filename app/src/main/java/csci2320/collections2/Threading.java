package csci2320.collections2;

public class Threading {
  public static void main(String[] args) {
    new Thread(() -> System.out.println("Hi there.")).start();
  }
}
