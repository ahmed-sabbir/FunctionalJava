package streams;

import student.Student;

import java.util.Arrays;
import java.util.List;

public class UseStream {
  public static void main(String[] args) {
    List<Student> school = Arrays.asList(
        Student.of("Fred", 3.4, "Math", "Art"),
        Student.of("Jim", 2.7, "Geography"),
        Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );

    school.stream()
        .filter(e -> e.getCourses().size() > 1)
        .map(e -> "Student: " + e.getName() + " has gpa: " + e.getGpa())
        .forEach(e -> System.out.println("> " + e));

    System.out.println("-------------------------------");
    school.stream()
        .forEach(s -> System.out.println(">> " + s));

    System.out.println("-------------------------------");
    school.stream()
        .filter(e -> e.getCourses().size() > 1)
        .flatMap(e -> e.getCourses().stream())
        .forEach(e -> System.out.println("> " + e));

    System.out.println("-------------------------------");
    school.stream()
        .filter(e -> e.getCourses().size() > 1)
        .flatMap(e -> e.getCourses().stream().map(
            n -> "Student " + e.getName() + " takes " + n))
        .forEach(e -> System.out.println("> " + e));

    System.out.println("-------------------------------");
    school.stream()
        .map(e -> e.getName())
        .forEach(e -> System.out.println(e));

    System.out.println("-------------------------------");
    school.stream()
        .map(Student::getName)
        .forEach(System.out::println);


  }

}
