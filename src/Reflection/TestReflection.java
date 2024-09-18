/*

 */
package Reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Person person = new Person();

        Class personClass = Person.class;
        Class personClass2 = person.getClass();
        Class personClass3 = Class.forName("Reflection.Person");

        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() + ", "
                    + method.getReturnType() + ", "
                    + Arrays.toString(method.getParameterTypes()));
        }

        System.out.println("------------------------------");

//        Field[] fields = personClass.getFields(); // Этот метод не показывает приватные поля
        Field[] fields = personClass.getDeclaredFields(); // Этот метод нарушает инкапсуляцию и показывает даже приватные поля
        for (Field field : fields) {
            System.out.println(field.getName() + ", "
                    + field.getType());
        }

        System.out.println("------------------------------");

        Annotation[] annotations = personClass.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof Author) {
                System.out.println("Yes ");
            }
        }

//////////////////////////////////////////// 2 ЧАСТЬ ///////////////////////////////////////////////////
        // Сделаем то, что без рефлексии сделать невозможно
        // Считаем из консоли названия двух классов
        // и создадим объекты этих двух классов с помощью рефлексии
        // Затем считаем из консоли названия метода
        // Вызовем этот метод на объекте первого класса
        // В аргументы этого метода передадим объект второго класса
        Scanner sc = new Scanner(System.in);
        // Название_класса1 Название_класса2 Название_метода
        System.out.println("---------------------------------");
        System.out.println("---------------------------------");
        Class classObject1 = Class.forName(sc.next());
        Class classObject2 = Class.forName(sc.next()) ;
        String methodName = sc.next();

        Method m = classObject1.getMethod(methodName, classObject2);
        Object o1 = classObject1.newInstance(); // создаем объект первого класса
        Object o2 = classObject2.getConstructor(String.class).newInstance("String value");
        // в классе String есть конструктор, который принимает на вход строку
        // и создает новую строку, равную переданной строке

        m.invoke(o1, o2); // вызываем метод m на объекте o1 с аргументом o2

        System.out.println(o1);




    }
}
