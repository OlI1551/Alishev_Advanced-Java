package Annotations;
import Annotations.MyAnnotation;

@MyAnnotation
public class TestMain {
    @MyAnnotation
    private String name;

    @MyAnnotation
    public TestMain() {

    }

    @MyAnnotation
    public void test(@MyAnnotation int value) {
        @MyAnnotation String localVar = "Hello";
    }

    @MyAnnotation
    public static void main(@MyAnnotation String[] args) {

    }
}