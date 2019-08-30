package sabbir.reduce;

import java.util.Optional;

public class Average {

	public final double SUM;
	public final long COUNT;
	
	{
	    System.out.println("Creating immutable Average");
	}

	public Average() {
		this(0, 0);
	}

	public Average(double sum, long count) {
		this.SUM = sum;
		this.COUNT = count;
	}

	public Average include(double d) {
		return new Average(this.SUM + d, this.COUNT + 1);
	}

	public Average merge(Average other) {
		return new Average(this.SUM + other.SUM, this.COUNT + other.COUNT);
	}

	public Optional<Double> get() {
		if (COUNT > 0) {
			return Optional.of(SUM / COUNT);
		} else {
			return Optional.empty();
		}
	}

}
