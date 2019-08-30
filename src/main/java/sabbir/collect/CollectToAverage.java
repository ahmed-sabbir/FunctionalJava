package sabbir.collect;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class CollectToAverage {
	
	public static void main(String[] args) {
		
		long start = System.nanoTime();
		
		//Stream.iterate(Double.valueOf(0, .. would run "ordered", bad with parallel)
		// .parallel()
		// .unordered() ..if you don't care about order
		Stream.generate (
				() -> ThreadLocalRandom.current().nextDouble(- Math.PI, Math.PI))
				.parallel()
				.limit (1_000_000_000)
				.map(Math::sin)
				.collect(() -> new Average(), 
						(a1, d) -> a1.include(d),
						(a1,a2) -> a1.merge(a2))
				.get()
				.map(a -> "The average is: " + a )
				.ifPresent(System.out::println);
		
		long time = System.nanoTime() - start;
		System.out.printf("Time taken : %7.4f\n", time / 1_000_000_000.0);
	}

}
