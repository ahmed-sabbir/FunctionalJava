package sabbir.exceptions;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class HandleException {
	
	public static <E, F> Function<E, Optional<F>> wrapErrors(ExceptionFunction<E, F> op){
		return e ->{
			try {
				return Optional.of(op.apply(e));
			} catch (Throwable t) {
				return Optional.empty();
			}
		};
	}
	
//	public static Optional<Stream<String>> getLinesFromFile(String path){
//		try {
//			return Optional.of(Files.lines(Paths.get(path)));
//		} catch(Throwable t) {
//			//return Stream.empty();
//			return Optional.empty();
//		}
//	}
	
	public static void main(String[] args) {
		
		List<String> fNames = Arrays.asList("a.txt","b.txt","c.txt");
		
		fNames.stream()
				//.flatMap(HandleException::getLinesFromFile)
				//.map(HandleException::getLinesFromFile)
				.map(wrapErrors(f -> Files.lines(Paths.get(f))))
				.peek(opt ->{
					if(!opt.isPresent())
						System.out.println("File not available");
				})
				.filter(Optional::isPresent)
				.flatMap(Optional::get) 
				.forEach(System.out::println);
	}

}
