package me.vincebae.template;

public class Main {

  public String greeting() {
    return "Hello World!";
  }

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.greeting());
  }
}
