package sabbir.student;

@FunctionalInterface
public interface StudentCriterion {

	boolean test(Student s);

	default StudentCriterion negate() {
		return s ->!this.test(s);
	}
	
	default StudentCriterion and(StudentCriterion criteria) {
		return s -> this.test(s) && criteria.test(s);
	}
	
	default StudentCriterion or(StudentCriterion criteria) {
		return s -> this.test(s) || criteria.test(s);
	}

}
