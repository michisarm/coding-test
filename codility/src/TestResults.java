import java.util.stream.*;
import java.util.*;

/**
 * Stream<Student> 및 int PassingScore를 사용하고, 점수가 가장 높거나 낮은 순서로 PassingScore보다 크거나 같은 학생 이름 목록을 반환하는 StudentsThatPass 메서드를 구현합니다.
 *
 * 예를 들어:
 *
 * List<학생> 학생 = new ArrayList<학생>();
 *
 * Students.add(new 학생("마이크", 80));
 * Students.add(new 학생("제임스", 57));
 * Students.add(new Student("Alan", 21));
 *
 * StudentsThatPass(students.stream(), 50).forEach(System.out::println);
 * "Mike"를 인쇄한 다음 "James"를 인쇄해야 합니다.
 */
public class TestResults
{
    public static class Student {
        private String name;
        private int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public String getName() {
            return name;
        }
    }

    public static List<String> studentsThatPass(Stream<Student> students, int passingScore) {
        return students
                .sorted(Comparator.comparing(Student::getScore).reversed())
                .filter(s -> s.getScore() >= passingScore)
                .map(Student::getName)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Mike", 80));
        students.add(new Student("James", 57));
        students.add(new Student("Alan", 21));

        studentsThatPass(students.stream(), 50).forEach(System.out::println);
    }
}