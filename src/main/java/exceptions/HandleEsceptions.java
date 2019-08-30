package exceptions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

interface ExFunction<E, F> {
  F apply(E e) throws Throwable;
}

public class HandleEsceptions {
  public static <E, F> Function<E, Optional<F>> wrap(ExFunction<E,F> op) {
    return e -> {
      try {
        return Optional.of(op.apply(e));
      } catch (Throwable t) {
        return Optional.empty();
      }
    };
  }

//  public static Optional<Stream<String>> getLines(String path) {
//    try {
//      return Optional.of(Files.lines(Paths.get(path)));
//    } catch (Throwable t) {
////      throw new RuntimeException(t);
////      return Stream.empty();
//      return Optional.empty();
//    }
//  }
  public static void main(String[] args) {
    List<String> fNames = Arrays.asList("a.txt", "b.txt", "c.txt");
    fNames.stream()
//        .flatMap(HandleEsceptions::getLines)
//        .map(HandleEsceptions::getLines)
        .map(wrap(n -> Files.lines(Paths.get(n))))
        .peek(opt -> {
          if (!opt.isPresent()) System.out.println("Bad file encountered");
        })
        .filter(Optional::isPresent)
        .flatMap(Optional::get)
        .forEach(System.out::println);
  }
}
