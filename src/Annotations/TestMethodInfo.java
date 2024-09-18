package Annotations;

import Annotations.MethodInfo;

//@MethodInfo(purpose = "asfds") // будет подчеркнуто красным - ошибка - пометили нашу аннотацию - @Target - только для методов
public class TestMethodInfo {
    @MethodInfo(author = "Tom", dateOfCreation = 2020, purpose = "Print Hello World")
    public void printHelloWorld() {
        System.out.println("Hello world!");

    }
}
