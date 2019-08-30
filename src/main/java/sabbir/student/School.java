package sabbir.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class School {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(Student.of("Fred", 3.4, "Math", "Art"),
				Student.of("Jim", 2.7, "Geography"),
				Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics"));
		
		StudentCriterion smartStudents = Student.getSmartStudentCriterion(3);
		
		System.out.println("All students:");
		showAllWithIterator(students);
		System.out.println("Smart students:");
		
		showAllWithIterator(getStudentsByCriterion(students, smartStudents));
		System.out.println("Not Smart students:");
		showAllWithIterator(getStudentsByCriterion(students, 
				smartStudents.negate()));
		System.out.println("Fairly smart students:");
		showAllWithIterator(getStudentsByCriterion(students,Student.getSmartStudentCriterion(2.5)));
		System.out.println("Enthusiastic students:");
		showAllWithIterator(getStudentsByCriterion(students, Student.getEnthusiasticStudentCriterion()));
		System.out.println("Not enthusiastic students:");
		showAllWithIterator(getStudentsByCriterion(students, 
				Student.getEnthusiasticStudentCriterion().negate()));
		System.out.println("Smart but not enthusiastic students:");
		showAllWithIterator(getStudentsByCriterion(students, 
				smartStudents.and(Student.getEnthusiasticStudentCriterion().negate())));

	}

	public static List<Student> getStudentsByCriterion(List<Student> students, StudentCriterion criteria) {
		List<Student> filteredStudents = new ArrayList<>();
		for (Student student : students) {
			if (criteria.test(student)) {
				filteredStudents.add(student);
			}
		}
		return filteredStudents;
	}

	public static void showAllWithIterator(List<Student> school) {
		for (Student s : school) {
			System.out.println("> " + s);
		}
		System.out.println("------------------------------");

		// how enhanced for loop actually works:
//		    for(Iterator<Student> s=school.iterator(); s.hasNext();) {
//		    	Student student=s.next();
//		    	System.out.println(student);
//		    }
	}
}
