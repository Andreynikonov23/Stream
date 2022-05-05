import java.io.*;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
        Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
        Вызовите готовый метод printSomething(), воспользуйтесь testString
        Верните переменной System.out первоначальный поток
        Вывести модифицированную строку в консоль.
         */
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(byteArrayOutputStream);
        System.setOut(print);
        printSomething();
        String testString = byteArrayOutputStream.toString();
        System.setOut(printStream);
        testString = testString.toUpperCase(Locale.ROOT);
        System.out.println(testString);
    }
    public static void printSomething(){
        System.out.println("Hello World!");
    }
}
