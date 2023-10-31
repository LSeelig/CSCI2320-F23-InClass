package csci2320.collections1;

public class Threading {
  public static void main(String[] args) {
    new Thread(() -> System.out.println("In a thread")).start();
  }
}
