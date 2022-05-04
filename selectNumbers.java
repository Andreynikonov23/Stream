package nick.pack;


import java.io.*;
import java.util.*;

public class Main {
    /*
    Считать с консоли 2 имени файла.
    Вывести во второй файл все числа, которые есть в первом файле.
    Числа выводить через пробел.
     */
    public static void main(String[] args) throws IOException {
       File file = new File("C://test/file.txt");
       Scanner scanner = new Scanner(file);
       ArrayList<String> result = new ArrayList<>();
       while (scanner.hasNext()){
           String next = scanner.next();
           try {
               int num = Integer.parseInt(next);
               result.add(String.valueOf(num));
           } catch (Exception e){
           }
       }
        System.out.println(result);
    }
}
