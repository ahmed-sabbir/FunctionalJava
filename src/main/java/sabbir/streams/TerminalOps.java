package sabbir.streams;

import java.util.stream.Stream;

public class TerminalOps {
	
	public static void main(String[] args) {
		
		boolean allLessThan100 = Stream.iterate(1, x -> x + 3)
										.peek(s -> System.out.println("> "+s))
										.limit(20)
										.allMatch(x -> x<100);
	
		System.out.println("All small:"+allLessThan100);
	}

}
