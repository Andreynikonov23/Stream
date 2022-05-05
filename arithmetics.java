import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
         методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
        Ваша ридер-обертка должна выводить на консоль решенный пример
        Вызовите готовый метод printSomething(), воспользуйтесь testString
        Верните переменной System.out первоначальный поток

        Возможные операции: + - *
        Шаблон входных данных и вывода: a [знак] b = c
         */
        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream print = new PrintStream(byteArrayOutputStream);
        System.setOut(print);
        printSomething();
        String testString = byteArrayOutputStream.toString();
        System.setOut(printStream);
        Scanner scanner = new Scanner(testString);
        while (scanner.hasNext()){
            String str = scanner.next();
            char[] chars = str.toCharArray();
            if (chars[1] == '+'){
                int a = Integer.parseInt(String.valueOf(chars[0]));
                int b = Integer.parseInt(String.valueOf(chars[2]));
                int result = a + b;
                System.out.println(str + "=" + result);
            }
            if (chars[1] == '-'){
                int a = Integer.parseInt(String.valueOf(chars[0]));
                int b = Integer.parseInt(String.valueOf(chars[2]));
                int result = a - b;
                System.out.println(str + "=" + result);
            }
            if (chars[1] == '*'){
                int a = Integer.parseInt(String.valueOf(chars[0]));
                int b = Integer.parseInt(String.valueOf(chars[2]));
                int result = a * b;
                System.out.println(str + "=" + result);
            }
        }
    }
    public static void printSomething(){
        System.out.println("3-6");
    }
}
