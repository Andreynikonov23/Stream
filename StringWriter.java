package nick.pack;

import java.io.*;

public class Main {

    /*
    Реализуй логику метода getStackTrace, который в виде одной строки (одного объекта типа String)
    должен возвращать весь стек-трейс переданного исключения.
    Используй подходящий метод класса Throwable, который поможет записать стек-трейс в StringWriter.
    Метод main не участвует в тестировании.
     */
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("error"));
        System.out.println(text);
    }

    public static String getStackTrace(Throwable throwable) {
        StringWriter writer = new StringWriter();
        throwable.printStackTrace(new PrintWriter(writer));

        return writer.toString();
    }
}
