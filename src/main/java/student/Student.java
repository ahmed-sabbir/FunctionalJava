package student;

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

  public String getName() {
    return name;
  }

  public double getGpa() {
    return gpa;
  }

  public List<String> getCourses() {
    return courses;
  }

  @Override
  public String toString() {
    return "Student{" +
        "name='" + name + '\'' +
        ", gpa=" + gpa +
        ", courses=" + courses +
        '}';
  }

  public static StudentCriterion getSmartStudentCriterion(double threshold) {
//    return s -> s.getGpa() > threshold ; // expression lambda
    return s -> s.gpa > threshold ; // expression lambda
  }
//  public static StudentCriterion getSmartStudentCriterion(double threshold) {
//    return (Student s) -> { return s.getGpa() > threshold; }; // block lambda
//  }
  // "closure"
  // threshold must be final or "effectively final"
//  public static StudentCriterion getSmartStudentCriterion(double threshold) {
////    threshold = threshold + 0.1;
//    return new StudentCriterion() {
//      @Override
//      public boolean test(Student s) {
//        return s.getGpa() > threshold;
//      }
//    };
//  }

  public static StudentCriterion getEnthusiasticCriterion() {
    return enthuiasticStudentCriterion;
  }

  private static final StudentCriterion enthuiasticStudentCriterion =
      (Student s) -> { return s.getCourses().size() > 3; };

//  private static final StudentCriterion enthuiasticStudentCriterion =
//      /*new StudentCriterion() { */
//       /* @Override
//        public boolean test*/(Student s) -> {
//          return s.getCourses().size() > 3;
//        }
//    /*  }*/;

//  // anonymous inner class
//  private static final StudentCriterion enthuiasticStudentCriterion =
//      new StudentCriterion() {
//        @Override
//        public boolean test(Student s) {
//          return s.getCourses().size() > 3;
//        }
//      };

//  private static final StudentCriterion enthuiasticStudentCriterion =
//      new /*EnthuiasticStudentCriterion();
//
//  private static class EnthuiasticStudentCriterion implements*/ StudentCriterion() {
//    @Override
//    public boolean test(Student s) {
//      return s.getCourses().size() > 3;
//    }
//  };
//
//  private static final EnthuiasticStudentCriterion enthuiasticStudentCriterion =
//      new EnthuiasticStudentCriterion();
//
//  private static class EnthuiasticStudentCriterion implements StudentCriterion {
//    @Override
//    public boolean test(Student s) {
//      return s.getCourses().size() > 3;
//    }
//  }
}
