package sabbir.generic;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import sabbir.student.Student;

public class School {
	
	public static void main(String[] args) {
		 List<Student> school = Arrays.asList(
			        Student.of("Fred", 3.4, "Math", "Art"),
			        Student.of("Jim", 2.7, "Geography"),
			        Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
			    );
		 System.out.println("All students:");
		 showAll(school);
		 
		 System.out.println("Smart students:");
		 showAll(getByCriterion(school, s->s.getGpa()>3));
		 
		 System.out.println("Smart but not enthusiastic students:");
		 Predicate<Student> enthusiastic=s-> s.getCourses().size()>3;
		 Predicate<Student> smart = s->s.getGpa()>3;
		 showAll(getByCriterion(school, smart.and(enthusiastic.negate())));
		 
		 List<String> letterList= Arrays.asList("AAAA","BBBB","C");
		 showAll(getByCriterion(letterList, s->s.length()>3));
		 
	}
	
	public static <E> void showAll(List<E> list){
		for(E e : list) {
			System.out.println(">"+e);
		}
		System.out.println("------------");
	}
	
	public static <E> List<E> getByCriterion(List<E> list, Predicate<E> criteria){
		List<E> output = new ArrayList<>();
		for(E element: list) {
			if (criteria.test(element)) {
				output.add(element);
			}
		}
		return output;
	}

}
