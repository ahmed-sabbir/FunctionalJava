package collect;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CollectToAverage {
  public static void main(String[] args) {
    long start = System.nanoTime();
//    Stream.iterate(Double.valueOf(0), ... would run "ordered" bad with parallel!
    Stream.generate(
        () -> ThreadLocalRandom.current().nextDouble(-Math.PI, Math.PI))
//        .parallel()
//        .sequential()
        .parallel()
        .limit(150_000_000L)
        .map(Math::sin)
        .collect(() -> new Average(),
            (a, d) -> a.include(d),
            (a1, a2) -> a1.merge(a2))
        .get()
        .map(a -> "The average is " + a)
        .ifPresent(System.out::println);
    long time = System.nanoTime() - start;
    System.out.printf("Total time %7.4f\n", (time / 1_000_000_000.0));
  }
}
