package sabbir.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import sabbir.student.Student;

public class CollectorStuff {
	
	public static String getLetterGrade (Student student) {
		return student.getGpa() > 3.3 ? "A" : "B";
 	}
	
	public static void main(String[] args) {
		
		List<Student> school = Arrays.asList(Student.of("Fred", 3.4, "Math", "Art"),
				Student.of("Jim", 2.7, "Geography"), 
				Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics")
			);
		
		Map<String, List<Student>> groupedStudents = school.stream()
															.collect(Collectors.groupingBy(s -> getLetterGrade(s)));
		
		groupedStudents.forEach((k,v) -> System.out.println("Students with grade "+ k +" are: "+v));
		
		Map<String, Long> groupedStudentsCount = school.stream()
				.collect(Collectors.groupingBy(s -> getLetterGrade(s), Collectors.counting()));
		
		groupedStudentsCount.forEach((k,v) -> System.out.println("Students with grade "+ k +" are: "+v));
	}

}
