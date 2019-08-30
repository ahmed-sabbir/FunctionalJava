package collect;

import java.util.Optional;

public class Average {
  private long count;
  private double sum;

  {
    System.out.println("Making a mutable Average");
  }

  public Average() {
  }

  public void include(double d) {
    this.sum += d;
    this.count++;
  }

  public void merge(Average other) {
    this.sum += other.sum;
    this.count += other.count;
  }

  public Optional<Double> get() {
    if (count > 0) {
      return Optional.of(sum / count);
    } else {
      return Optional.empty();
    }
  }
}