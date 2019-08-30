package sabbir.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UseOptional {
	
	public static final String THE_NAME="Freddy";
	
	public static void main(String[] args) {
		
		
		
		Map<String, String> names= new HashMap<>();
		names.put("Fred", "Jones");
		
		String lastName=names.get(THE_NAME);
		if(lastName!=null) {	
			String shout = lastName.toUpperCase();
			String address = "Mr." + shout;
			System.out.println(address);
		}
		
		Optional.of(names)
				.map(m -> m.get(THE_NAME))
				.map(n -> n.toUpperCase())
				.map(s -> "Mr."+ s)
				.ifPresent(System.out::println);
	}

}
