package stream;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;
import static java.util.Comparator.*;

public class StreamEx8 {
    public static void main(String[] args) {
        Student7[] stuArr = {
                new Student7("나자바", true, 1, 1, 300),
                new Student7("김지미", false, 1, 1, 250),
                new Student7("김자바", true, 1, 1, 200),
                new Student7("이지미", false, 1, 2, 150),
                new Student7("남자바", true, 1, 2, 100),
                new Student7("안지미", false, 1, 2, 50),
                new Student7("황지미", false, 1, 3, 100),
                new Student7("강지미", false, 1, 3, 150),
                new Student7("이자바", true, 1, 3, 200),

                new Student7("나자바", true, 2, 1, 300),
                new Student7("김지미", false, 2, 1, 250),
                new Student7("김자바", true, 2, 1, 200),
                new Student7("이지미", false, 2, 2, 150),
                new Student7("남자바", true, 2, 2, 100),
                new Student7("안지미", false, 2, 2, 50),
                new Student7("황지미", false, 2, 3, 100),
                new Student7("강지미", false, 2, 3, 150),
                new Student7("이자바", true, 2, 3, 200)
        };

        System.out.printf("1. 단순그룹화(반별로 그룹화) %n");
        Map<Integer, List<Student7>> stuByBan = Stream.of(stuArr)
                .collect(groupingBy(Student7::getBan));

        for (List<Student7> ban : stuByBan.values()) {
            for (Student7 s : ban) {
                System.out.println(s);
            }
        }
        System.out.printf("%n2. 단순그룹화(성적별로 그룹화)%n");
        Map<Student7.Level, List<Student7>> stuByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student7.Level.HIGH;
                    else if (s.getScore() >= 100) return Student7.Level.MID;
                    else return Student7.Level.LOW;
                }));

        TreeSet<Student7.Level> keySet = new TreeSet<>(stuByLevel.keySet());

        for (Student7.Level key : keySet) {
            System.out.println("["+key+"]");

            for (Student7 s : stuByLevel.get(key)) {
                System.out.println(s);
            }
            System.out.println();
        }

        System.out.printf("%n3. 단순그룹화(성적별 학생수)%n");
        Map<Student7.Level, Long> stuCntByLevel = Stream.of(stuArr)
                .collect(groupingBy(s -> {
                    if (s.getScore() >= 200) return Student7.Level.HIGH;
                    else if (s.getScore() >= 100) return Student7.Level.MID;
                    else return Student7.Level.LOW;
                }, counting()));

        for (Student7.Level key : stuCntByLevel.keySet()) {
            System.out.printf("[%s] - %d명, ", key, stuCntByLevel.get(key));
        }
        System.out.println();

        System.out.printf("%n4. 다중그룹화(학년별, 반별)");
        Map<Integer, Map<Integer, List<Student7>>> stuByHakAndBan =
                Stream.of(stuArr)
                .collect(groupingBy(Student7::getHak,
                        groupingBy(Student7::getBan)));

        for (Map<Integer, List<Student7>> hak : stuByHakAndBan.values()) {
            for (List<Student7> ban : hak.values()) {
                System.out.println();
                for (Student7 s : ban) {
                    System.out.println(s);
                }
            }
        }

        System.out.printf("%n5. 다중그룹화 + 통계(학년별, 반별 1등)%n");
        Map<Integer, Map<Integer, Student7>> topStuByHakAndBan =
                Stream.of(stuArr)
                .collect(groupingBy(Student7::getHak,
                        groupingBy(Student7::getBan,
                                collectingAndThen(maxBy(comparingInt(Student7::getScore)),
                                        Optional::get))));

        for (Map<Integer, Student7> ban : topStuByHakAndBan.values()) {
            for (Student7 s : ban.values()) {
                System.out.println(s);
            }
        }

        System.out.printf("%n6. 다중그룹화 + 통계(학년별, 반별 성적그룹)%n");
        Map<String, Set<Student7.Level>> stuByScoreGroup = Stream.of(stuArr)
                .collect(groupingBy(s -> s.getHak() + "-" + s.getBan(),
                        mapping(s -> {
                            if (s.getScore() >= 200) return Student7.Level.HIGH;
                            else if (s.getScore() >= 100) return Student7.Level.MID;
                            else return Student7.Level.LOW;
                        } , toSet())));

        Set<String> ketSet2 = stuByScoreGroup.keySet();
        for (String key : ketSet2) {
            System.out.println("["+key+"]" + stuByScoreGroup.get(key));
        }
    }
}
