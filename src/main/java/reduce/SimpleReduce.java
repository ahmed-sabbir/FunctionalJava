package reduce;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class SimpleReduce {
  public static void main(String[] args) {
    OptionalInt res = IntStream.iterate(1, x -> x + 1)
        .limit(10)
        .reduce((a, b) -> a + b);
    res.ifPresent(System.out::println);
  }
}
