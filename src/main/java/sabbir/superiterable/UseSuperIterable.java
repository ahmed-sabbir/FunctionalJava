package sabbir.superiterable;

import java.util.Arrays;
import java.util.List;

import sabbir.student.Student;

public class UseSuperIterable {

	public static void main(String[] args) {
		List<Student> school = Arrays.asList(
				Student.of("Fred", 3.4, "Math", "Art"),
				Student.of("Jim", 2.7, "Geography"), 
				Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics")
			);
		
		SuperIterable<Student> students=new SuperIterable<>(school);
		
		
		students
			.filter(s -> s.getCourses().size() > 1)
			.map(e -> "Student:" + e.getName() + " has gpa:"+e.getGpa())
			.forEach(e -> System.out.println(">" + e));
		
		System.out.println("-----------------");
		
		students. 
			forEach(e -> System.out.println(">" + e));
		
		System.out.println("-----------------");
		
		students
			.filter(s -> s.getCourses().size() > 1)
			.flatMap(e -> new SuperIterable<>(
					e.getCourses()).map(n -> "Student " +e.getName() +" takes " +n))
			.forEach(e -> System.out.println(">"+e));
		
		System.out.println("-----------------");
		System.out.println("Method references used:");
		students
			.map(e -> e.getName())
			.forEach(e -> System.out.println(e));
		System.out.println("same as:");
		
		students
			.map(Student::getName)
			.forEach(System.out::println);
		
	
		 
	}
}
