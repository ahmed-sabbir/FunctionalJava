package streams;

import java.util.stream.Stream;

public class TerminalOps {
  public static void main(String[] args) {

    boolean allSmall = Stream.iterate(1, x -> x + 3)
        .peek(x -> System.out.println("> " + x))
        .limit(400)
        .allMatch(x -> x < 100);
    System.out.println("All small? " + allSmall);
//        .forEach(System.out::println);
  }
}
