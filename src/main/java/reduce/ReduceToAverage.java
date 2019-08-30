package reduce;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class ReduceToAverage {
  public static void main(String[] args) {
    Stream.generate(
        () -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
        .limit(1_000_000)
        .reduce(new Average(),
            (a, d) -> a.include(d),
            (a1, a2) -> a1.merge(a2))
        .get()
        .map(a -> "The average is " + a)
        .ifPresent(System.out::println);
  }
}
