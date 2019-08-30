package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UseOptiona {
  public static final String THE_NAME = "Freddy";
  public static void main(String[] args) {
    Map<String, String> names = new HashMap<>();
    names.put("Fred", "Jones");

    String lastname = names.get(THE_NAME);
    if (lastname != null) {
      String shout = lastname.toUpperCase();
      String address = "Mr. " + shout;
      System.out.println(address);
    }

    Optional.of(names)
        .map(m -> m.get(THE_NAME))
        .map(n -> n.toUpperCase())
        .map(s -> "Mr. " + s)
        .ifPresent(System.out::println);
  }
}
