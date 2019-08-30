package reduce;

import java.util.Optional;

public class Average {
  private final long count;
  private final double sum;

  {
    System.out.println("Creating immutable Average");
  }
  public Average() {
    this(0, 0);
  }

  public Average(double sum, long count) {
    this.sum = sum;
    this.count = count;
  }

  public Average include(double d) {
    return new Average(this.sum + d, this.count + 1);
  }

  public Average merge(Average other) {
    return new Average(this.sum + other.sum,
        this.count + other.count);
  }

  public Optional<Double> get() {
    if (count > 0) {
      return Optional.of(sum / count);
    } else {
      return Optional.empty();
    }
  }
}
