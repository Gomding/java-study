package annotation;

import java.util.ArrayList;

public class AnnotationEx3 {
    @SuppressWarnings("deprecation")        // deprecation관련 경고를 억제
    public static void main(String[] args) {
        NewClass nc = new NewClass();

        nc.oldField = 10;
        System.out.println(nc.getOldField());

        @SuppressWarnings("unchecked")              // 지네릭스 관련 경고를 억제
        ArrayList<NewClass> list = new ArrayList(); // 타입을 지정하지 않음
        list.add(nc);
    }
}
