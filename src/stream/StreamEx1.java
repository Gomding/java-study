package stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of( // of() 안의 요소로 Stream 배열을 만듬
                new Student("이자바", 3, 300),
                new Student("김자바", 1, 200),
                new Student("안자바", 2, 100),
                new Student("박자바", 2, 150),
                new Student("소자바", 1, 200),
                new Student("나자바", 3, 290),
                new Student("감자바", 3, 180)
        );

        studentStream.sorted(Comparator.comparing(Student::getBan)
                    .thenComparing(Comparator.naturalOrder()))  // 기본정렬
                    .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;
    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName() { return name; }
    int getBan() { return ban; }
    int getTotalScore() { return totalScore; }

    // 총점 내림차순을 기본 정렬로 한다.
    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
