package sabbir.student;

import java.util.Arrays;
import java.util.List;

public class Student {
	private String name;
	private double gpa;
	private List<String> courses;

	private Student() {
	}

	public static Student of(String name, double gpa, String... courses) {
		Student self = new Student();
		self.name = name;
		self.gpa = gpa;
		self.courses = Arrays.asList(courses.clone());
		return self;
	}

	public double getGpa() {
		return gpa;
	}

	public List<String> getCourses() {
		return courses;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Student{" + "name='" + name + '\'' + ", gpa=" + gpa + ", courses=" + courses + '}';
	}

	public static StudentCriterion getSmartStudentCriterion(double threshold) {
		return s -> s.gpa > threshold;
	}

	private static final StudentCriterion enthusiasticStudentCriterion = s -> s.getCourses().size() > 3;

	public static StudentCriterion getEnthusiasticStudentCriterion() {
		return enthusiasticStudentCriterion;
	}

}
