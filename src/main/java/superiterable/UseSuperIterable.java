package superiterable;

import student.Student;
import java.util.Arrays;
import java.util.List;

public class UseSuperIterable {
  public static void main(String[] args) {
    List<Student> school = Arrays.asList(
        Student.of("Fred", 3.4, "Math", "Art"),
        Student.of("Jim", 2.7, "Geography"),
        Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );

    SuperIterable<Student> students = new SuperIterable<>(school);

    students
        .filter(e -> e.getCourses().size() > 1)
        .map(e -> "Student: " + e.getName() + " has gpa: " + e.getGpa())
        .forEach(e -> System.out.println("> " + e));

    System.out.println("-------------------------------");
    students
        .forEach(s -> System.out.println(">> " + s));

    System.out.println("-------------------------------");
    students
        .filter(e -> e.getCourses().size() > 1)
        .flatMap(e -> new SuperIterable<>(e.getCourses()))
        .forEach(e -> System.out.println("> " + e));

    System.out.println("-------------------------------");
    students
        .filter(e -> e.getCourses().size() > 1)
        .flatMap(e -> new SuperIterable<>(
            e.getCourses()).map(n -> "Student " + e.getName() + " takes " + n))
        .forEach(e -> System.out.println("> " + e));

    System.out.println("-------------------------------");
    students
        .map(e -> e.getName())
        .forEach(e -> System.out.println(e));

    System.out.println("-------------------------------");
    students
        .map(Student::getName)
        .forEach(System.out::println);


  }
}
