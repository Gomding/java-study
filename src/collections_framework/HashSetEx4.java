package collections_framework;

import java.util.HashSet;
import java.util.Objects;

public class HashSetEx4 {
    public static void main(String[] args) {
        HashSet set = new HashSet();

        set.add("abc");
        set.add("abc");
        set.add(new Person2("David", 10));
        set.add(new Person2("David", 10));

        System.out.println(set);
    }
}

class Person2 {
    String name;
    int age;

    Person2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // HashSet의 add 메서드는 새로운 요소를 추가하기 전에 기존에 저장된 것인지 판별하기 위해
    // 추가하려는 요소의 equals()와 hashCode()를 호출하기 때문에 두 메서드를 목적에 맞게 오버라이딩 해야한다.
    public boolean equals(Object obj) {
        if (obj instanceof Person2) {
            Person2 tmp = (Person2)obj;
            return name.equals(tmp.name) && age == tmp.age;
        }
        return false;
    }

    // Object 클래스는 주소로 해시코드를 만들어 내기 때문에 호출할때마다 다름(값이 변하지 않는 이상은 비교할때 항상 같음
    public int hashCode() {
        return Objects.hash(name, age);
    }

    /*public int hashCode() {
        return (name+age).hashCode();
    }*/

    public String toString() {
        return name + ":" + age;
    }
}
