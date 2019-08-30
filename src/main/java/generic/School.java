package generic;

import student.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class School {

  public static <E> void showAll(List<E> ls) {
    for (E s : ls) {
      System.out.println("> " + s);
    }
    System.out.println("------------------------------");
  }

  public static <E> List<E> getByCriterion(List<E> ls, Predicate<E> crit) {
    List<E> out = new ArrayList<>();
    for (E s : ls) {
      if (crit.test(s)) {
        out.add(s);
      }
    }
    return out;
  }

  public static void main(String[] args) {
    List<Student> school = Arrays.asList(
        Student.of("Fred", 3.4, "Math", "Art"),
        Student.of("Jim", 2.7, "Geography"),
        Student.of("Sheila", 3.7, "Math", "Physics", "Astrophysics", "Quantum Mechanics")
    );
    System.out.println("All students:");
    showAll(school);

    System.out.println("Smart students:");
    showAll(getByCriterion(school, s -> s.getGpa() > 3));

    Predicate<Student> smart = s -> s.getGpa() > 3;
    Predicate<Student> enthusiastic = s -> s.getCourses().size() > 3;
    System.out.println("Smart but not Enthusiastic students:");
    showAll(getByCriterion(school, smart.and(enthusiastic.negate())));

    List<String> ls = Arrays.asList("Fred", "Jim", "Sheila");
    showAll(getByCriterion(ls, s -> s.length() > 3));

  }
}
