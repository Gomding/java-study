
@FunctionalInterface
interface MyMath {
    int calc(int a, int b);
}

public class LamdaTest {

    public static void main(String[] args) {
        MyMath sum = (x, y) -> {
            System.out.println(x + y);
            return x + y;
        };

        MyMath substract = (x, y) -> {
            System.out.println(x - y);
            return x - y;
        };

        sum.calc(1, 2);
        substract.calc(3, 1);
    }

}
