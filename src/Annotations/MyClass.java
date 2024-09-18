package Annotations;

public class MyClass {
    @Deprecated // сообщаем всем, что этот метод устарел - есть новый
    public void myMethod() {
        System.out.println("Hello from myMethod");
    }
}
