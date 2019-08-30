package sabbir.reduce;

import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class SimpleReduce {
	
	public static void main(String[] args) {
		
		IntBinaryOperator op = (a,b) -> {
			System.out.println("first:"+a);
			System.out.println("second:"+b);
			return a+b;
			
		};
		
		 OptionalInt result = IntStream.iterate(1,  x -> x+1)
				.limit(10)
				.reduce(op);
		 
		 
		
		result.ifPresent(System.out::println);
	}

}
