package student;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface StudentCriterion {
//  boolean doStuff();
  boolean test(Student s);
  static StudentCriterion negate(StudentCriterion in) {
    return s -> !in.test(s);
  }

  static StudentCriterion and(StudentCriterion one, StudentCriterion two) {
    return s -> one.test(s) && two.test(s);
  }

  static StudentCriterion or(StudentCriterion one, StudentCriterion two) {
    return s -> one.test(s) || two.test(s);
  }

  default StudentCriterion negate() {
    return s -> !this.test(s);
  }

  default StudentCriterion and(StudentCriterion two) {
    return s -> this.test(s) && two.test(s);
  }

  default StudentCriterion or(StudentCriterion two) {
    return s -> this.test(s) || two.test(s);
  }
}

interface Silly {
  boolean doStuff(Student s);
}

//class SmartStudentCriterion implements StudentCriterion {
//  private double threshold;
//  public SmartStudentCriterion(double threshold) {
//    this.threshold = threshold;
//  }
//  @Override
//  public boolean test(Student s) {
//    return s.getGpa() > threshold;
//  }
//}
//
//class EnthuiasticStudentCriterion implements StudentCriterion {
//
//  @Override
//  public boolean test(Student s) {
//    return s.getCourses().size() > 3;
//  }
//}

public class School {


  public static void showAll(List<Student> ls) {
    for (Student s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("------------------------------");
  }

  public static List<Student> getSmartStudents(List<Student> ls,
                                               double threshold) {
    List<Student> out = new ArrayList<>();
    for (Student s : ls) {
      if (s.getGpa() > threshold) {
        out.add(s);
      }
    }
    return out;
  }

  public static List<Student> getEnthusiasticStudents(List<Student> ls,
                                                      int threshold) {
    List<Student> out = new ArrayList<>();
    for (Student s : ls) {
      if (s.getCourses().size() > threshold) {
        out.add(s);
      }
    }
    return out;
  }
  
//  // Higher order function
//  // aka "command" pattern in OO design pattern terminology
//  public static List<Student> getStudentsByCriterion(List<Student> ls,
//                                               StudentCriterion crit) {
//    List<Student> out = new ArrayList<>();
//    for (Student s : ls) {
//      if (crit.test(s)) {
//        out.add(s);
//      }
//    }
//    return out;
//  }

  public static void main(String[] args) {
    List<Student> school = Arrays.asList(
        Student.of("Fred", 3.4, "Math", "Art"),
        Student.of("Jim", 2.7, "Geography"),
        Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    System.out.println("All students:");
    showAll(school);
    System.out.println("Smart students:");
    showAll(getSmartStudents(school, 3.0));
    System.out.println("Fairly smart students:");
    showAll(getSmartStudents(school, 2.5));
    System.out.println("Enthusiastic students:");
    showAll(getEnthusiasticStudents(school, 3));

//    System.out.println("Smart students:");
//    showAll(getStudentsByCriterion(school,
//        Student.getSmartStudentCriterion(3)));
//    System.out.println("Fairly smart students:");
//    showAll(getStudentsByCriterion(school,
//        Student.getSmartStudentCriterion(2.5)));
//    System.out.println("Enthusiastic students:");
//    showAll(getStudentsByCriterion(school,
//        Student.getEnthusiasticCriterion()));
//
//    Object obj = ((Silly)(s -> s.getGpa() > 3));
//    System.out.println("Class of obj is " + obj.getClass().getName());
//    Method [] methods = obj.getClass().getMethods();
//    for (Method m : methods) {
//      System.out.println("> " + m);
//    }
//        .doStuff(Student.of("Alice", 3.9, "Security")) ;
//
//    System.out.println("Not Smart students:");
//    showAll(getStudentsByCriterion(school,
//        StudentCriterion.negate(Student.getSmartStudentCriterion(3))));
//    System.out.println("Not Fairly smart students:");
//    showAll(getStudentsByCriterion(school,
//        StudentCriterion.negate(Student.getSmartStudentCriterion(2.5))));
//    System.out.println("Not Enthusiastic students:");
//    showAll(getStudentsByCriterion(school,
//        StudentCriterion.negate(Student.getEnthusiasticCriterion())));
//
//    System.out.println("Smart but not Enthusiastic students:");
//    showAll(getStudentsByCriterion(school,
//        StudentCriterion.and(Student.getSmartStudentCriterion(3),
//            StudentCriterion.negate(Student.getEnthusiasticCriterion()))));
//
//    StudentCriterion smart = Student.getSmartStudentCriterion(3);
//    StudentCriterion enthusiastic = Student.getEnthusiasticCriterion();
//    System.out.println("Smart but not Enthusiastic students:");
//    showAll(getStudentsByCriterion(school, smart.and(enthusiastic.negate())));

  }
}
