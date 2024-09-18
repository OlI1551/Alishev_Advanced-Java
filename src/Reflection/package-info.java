package Reflection;
/*
Пару слов перед началом
Рефлексия - простая тема, но может быть вначале
придется немного поломать голову, чтобы понять концепцию

Следите внимательно за объяснением
--------------------------------------------------------

Вспомним ООП
Что есть у каждого класса?
Название класса
Название пакета
Поля
Методы

Class:
name
package name
List of attributes
List of methods

class Class {
    String name;
    String packageName;
    List<Attribute> attributes;
    List<Method> methods;
-----------------------------------------

- Все классы, которые мы создавали в Java (и встроенные классы тоже)
можно рассматривать как экземпляры (объекты) класса Class
- Конкретный человек - это экземпляр (объект) класса Person
(со своим id и именем)
- А класс Person в свою очередь - это экземпляр (объект) класса Class
- То есть объекты класса Class - это конкретные классы со своим
названием, методами и полями

Значит, все инструменты ООП мы можем применить к самим
классам как к сущностям
(Рассматриваем класс как объект класса Class и работаем с ним
как с обычным объектом в Java)

Это и называется рефлексией!
----------------------------------------

Класс Class

Служебный класс, экземпляры которого (Java классы) хранят
конкретную информацию о конкретном классе

Уже реализован в Java (Reflection API)
--------------------------------------

Как получить доступ к объекту класса Class?
 - Классу (пусть это MyClass):
 Class c = MyClass.class;

 - Объекту (пусть obj - экземпляр класса MyClass):
 Class c = obj.getClass();

 - Названию класса (пусть полное имя класса - ru.alishev.MyClass):
 Class c = Class.forName("ru.alishev.MyClass");
 ---------------------------------------------
 Можно получить все методы класса
 Method - это тоже класс.
 Методы, которые мы объявляем в классе - это
 экземпляры (объекты) класса Method
 ---------------------------------------------
 Можно получить все поля класса
 Field - это тоже класс.
 Поля, которые мы объявляем в классе - это
 экземпляры (объекты) класса Field

 Рефлексия учитывает инкапсуляцию, поэтому будут возвращены
 только public поля

 Рефлексия может не учитывать инкапсуляцию, тогда будут
 возвращены все поля (даже private). Делается это с помощью
 методов, которые имеют Declared в названии
 * Это используется в Spring Framework для аннотации @Autowired
 --------------------------------------------------------------
 Проверка аннотаций
 Проверяем, что класс Person аннотирован @Author
 * Это повсеместно используется в Spring Framework
-----------------------------------------------------------------
-----------------------------------------------------------------

что еще можно делать с помощью рефлексии в Java?

Для объекта класса Class:
- *Создавать новые объекты класса
(по умолчанию вызывает пустой конструктор - newInstance())
- Получать методы по сигнатуре - getMethod(...)
- Получать конструктор по сигнатуре - getConstructor(...)

Для объекта класса Method:
- Вызывать методы - invoke()

* Метод newInstance() можно вызывать не только на
объектах класса Class, но и на объектах класса Constructor
----------------------------------------------------------

Как получить метод по сигнатуре?

Сигнатура метода в терминах рефлексии - это имя и
набор типов параметров
public class TestReflection {
    public static void main(String[] args) throws NoSuchMethodException {
        Class stringClass = String.class;
        Method m = stringClass.getMethod(
                name: "indexOf",
                String.class, int.class);
        System.out.println(m);
    }
}

Для второго аргумента у метода getMethod() используется Java varargs -
можно передать любое число аргументов на место этого параметра в метод
@CallerSensitive
public Method getMethod(String name, Class<?>... parameterTypes)



 */