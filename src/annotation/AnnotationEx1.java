package annotation;

public class AnnotationEx1 {
    public static void main(String[] args) {
        class Parent {
            void parentMethod() {
            }
        }

        class Child extends Parent {
            @Override
            void parentMethod() {
                // void parantmethod() 라고하면 에러가 발생한다.
                // @Override 어노테이션을 붙이지 않았다면 오버라이드 오류라는 메세지가 나타나지 않았을 것입니다.
            }
        }
    }
}
