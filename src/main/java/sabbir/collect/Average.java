package sabbir.collect;

import java.util.Optional;

public class Average {
	
	public double SUM;
	public long COUNT;
	
	{
	    System.out.println("Making a mutable Average");
	}
	
	public Average() {
		
	}

	public void include(double d) {
		this.SUM +=d;
		this.COUNT++;
	}

	public void merge(Average other) {
		this.SUM += other.SUM;
		this.COUNT += other.COUNT;
	}

	public Optional<Double> get() {
		if (COUNT > 0) {
			return Optional.of(SUM / COUNT);
		} else {
			return Optional.empty();
		}
	}

}
