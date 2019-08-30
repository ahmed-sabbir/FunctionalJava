package sabbir.streams;

import java.util.Arrays;
import java.util.List;

import sabbir.student.Student;

public class UseStreams {
	
	public static void main(String[] args) {
		List<Student> school = Arrays.asList(
				Student.of("Fred", 3.4, "Math", "Art"),
				Student.of("Jim", 2.7, "Geography"), 
				Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics")
			);
		
		school.stream()
			.filter(s -> s.getCourses().size()>1)
			.map(e -> "Student: "+ e.getName() +" has gpa: "+e.getGpa())
			.forEach(s -> System.out.println(">"+s));
		
		System.out.println("--------------");
		
		school.stream()
			.forEach(s -> System.out.println(">"+s));
		
		System.out.println("--------------");
		
		school.stream()
			.filter(s -> s.getCourses().size()>1)
			.flatMap(e -> e.getCourses().stream())
			.forEach(e ->System.out.println(">"+e));
		
		System.out.println("--------------");
		
		school.stream()
			.filter(s -> s.getCourses().size()>1)
			.flatMap(e -> e.getCourses().stream().map(n -> "Student: "+ e.getName()+" takes:"+n))
			.forEach(s -> System.out.println(">"+s));
		
		System.out.println("--------------");
		school.stream()
			.map(Student::getName)
			.forEach(s -> System.out.println(">"+s));
	}


}
