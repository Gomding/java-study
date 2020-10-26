package collections_framework;

import java.util.Iterator;

public class MyVectorTest {
    public static void main(String[] args) {
        MyVector2 v = new MyVector2();
        for (int i = 0;  i < 5; i++) {
            v.add(i+"");
        }

        System.out.println("삭제 전 : " + v);
        Iterator it = v.iterator();
        it.next();
        it.remove();
        it.next();
        it.remove();

        System.out.println("삭제 후 : " + v);
    }

}
