import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        /*
        В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
        Ваша ридер-обертка должна выводить только цифры
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
        Scanner scanner = new Scanner(testString);
        while (scanner.hasNext()){
            String str = scanner.next();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                try{
                    int num = Integer.parseInt(String.valueOf(chars[i]));
                    System.out.println(num);
                } catch (Exception e){

                }
            }
        }
    }
    public static void printSomething(){
        System.out.println("testString1242");
    }
}
