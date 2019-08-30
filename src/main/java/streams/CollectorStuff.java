package streams;

import student.Student;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorStuff {
  public static String getLetterGrade(Student s) {
    double gpa = s.getGpa();
    if (gpa > 3.3) return "A";
    else return "B";
  }
  public static void main(String[] args) {
    List<Student> school = Arrays.asList(
        Student.of("Fred", 3.4, "Math", "Art"),
        Student.of("Jim", 2.7, "Geography"),
        Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );

    Map<String, List<Student>> map =
    school.stream()
        .collect(Collectors.groupingBy(s -> getLetterGrade(s)));

    map.forEach((k, v) -> System.out.println("Students with grade " + k + " are " + v));

    Map<String, Long> map2 =
    school.stream()
        .collect(Collectors.groupingBy(s -> getLetterGrade(s),
            Collectors.counting()));
    map2.forEach((k, v) -> System.out.println("Students with grade " + k + " are " + v));

  }

}
